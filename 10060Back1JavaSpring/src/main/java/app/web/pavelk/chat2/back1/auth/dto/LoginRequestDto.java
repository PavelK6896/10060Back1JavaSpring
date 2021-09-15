package app.web.pavelk.chat2.back1.auth.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginRequestDto {
    @NotNull
    String username;
    @NotNull
    String password;
}
