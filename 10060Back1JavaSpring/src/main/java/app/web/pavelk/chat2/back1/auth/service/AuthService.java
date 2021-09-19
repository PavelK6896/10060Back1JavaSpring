package app.web.pavelk.chat2.back1.auth.service;

import app.web.pavelk.chat2.back1.auth.dto.LoginRequestDto;
import app.web.pavelk.chat2.back1.auth.dto.LoginResponseDto;
import app.web.pavelk.chat2.back1.auth.dto.RefreshRequestDto;
import app.web.pavelk.chat2.back1.auth.schema.Refresh;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final RefreshService refreshService;
    private final UserDetailsService userDetailsServiceImpl;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public LoginResponseDto login(LoginRequestDto loginRequestDto, HttpServletRequest httpServletRequest) {
        System.out.println(passwordEncoder.encode("1"));
        System.out.println(passwordEncoder.matches("1", "{bcrypt}$2a$10$QBZDblpmpF8fBvQw9QUSKuzoUwGyvwes02h.cQgtAeHyxWNSf50Le"));
        System.out.println(loginRequestDto);

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) authenticate.getPrincipal();
        LoginResponseDto loginResponseDto = jwtProvider.generateToken(principal);

        loginResponseDto.setRefresh(refreshService.generateRefresh(principal.getUsername(), httpServletRequest).getToken());
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
