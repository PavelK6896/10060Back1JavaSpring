package app.web.pavelk.chat2.back1.auth.controller;

import app.web.pavelk.chat2.back1.auth.dto.LoginRequestDto;
import app.web.pavelk.chat2.back1.auth.dto.LoginResponseDto;
import app.web.pavelk.chat2.back1.auth.dto.RefreshRequestDto;
import app.web.pavelk.chat2.back1.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto) {
        return authService.login(loginRequestDto);
    }

    @PostMapping("/logout")
    public void logout(@Valid @RequestBody RefreshRequestDto refreshRequestDto) {
        authService.logout(refreshRequestDto);
    }

    @PostMapping("/refresh")
    public LoginResponseDto refresh(@Valid @RequestBody RefreshRequestDto refreshRequestDto) {
        return authService.refresh(refreshRequestDto);
    }

}
