package app.web.pavelk.chat2.back1.auth.controller;

import app.web.pavelk.chat2.back1.auth.dto.LoginRequestDto;
import app.web.pavelk.chat2.back1.auth.dto.LoginResponseDto;
import app.web.pavelk.chat2.back1.auth.dto.RefreshRequestDto;
import app.web.pavelk.chat2.back1.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponseDto login(@Validated LoginRequestDto loginRequestDto) {
        return authService.login(loginRequestDto);
    }

    @PostMapping("/logout")
    public void logout(@Validated RefreshRequestDto refreshRequestDto) {
        authService.logout(refreshRequestDto);
    }

    @PostMapping("/refresh")
    public LoginResponseDto refresh(@Validated RefreshRequestDto refreshRequestDto) {
        return authService.refresh(refreshRequestDto);
    }

}
