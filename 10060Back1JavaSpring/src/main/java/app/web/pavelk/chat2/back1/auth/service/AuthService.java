package app.web.pavelk.chat2.back1.auth.service;

import app.web.pavelk.chat2.back1.auth.dto.LoginRequestDto;
import app.web.pavelk.chat2.back1.auth.dto.LoginResponseDto;
import app.web.pavelk.chat2.back1.auth.dto.RefreshRequestDto;
import app.web.pavelk.chat2.back1.auth.schema.Refresh;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final RefreshService refreshService;
    private final UserDetailsService userDetailsServiceImpl;
    private final JwtProvider jwtProvider;

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword());
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        org.springframework.security.core.userdetails.User principal =
                (org.springframework.security.core.userdetails.User) usernamePasswordAuthenticationToken.getPrincipal();
        LoginResponseDto loginResponseDto = jwtProvider.generateToken(principal);
        loginResponseDto.setRefresh(refreshService.generateRefresh().getToken());
        return loginResponseDto;
    }

    public LoginResponseDto refresh(RefreshRequestDto refreshRequestDto) {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User)
                userDetailsServiceImpl.loadUserByUsername(refreshRequestDto.getUsername());
        Refresh refresh = refreshService.validateRefresh(refreshRequestDto.getRefresh());
        LoginResponseDto loginResponseDto = jwtProvider.generateToken(principal);
        loginResponseDto.setRefresh(refreshService.updateRefresh(refresh).getToken());
        return loginResponseDto;
    }

    public void logout(RefreshRequestDto refreshRequestDto) {
        userDetailsServiceImpl.loadUserByUsername(refreshRequestDto.getUsername());
        refreshService.deleteRefresh(refreshRequestDto.getRefresh());
    }
}
