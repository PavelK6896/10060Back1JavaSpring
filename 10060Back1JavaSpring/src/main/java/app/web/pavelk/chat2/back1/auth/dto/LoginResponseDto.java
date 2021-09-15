package app.web.pavelk.chat2.back1.auth.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class LoginResponseDto {
    String token;
    LocalDateTime expiresAt;
    String username;
    String refresh;
}
