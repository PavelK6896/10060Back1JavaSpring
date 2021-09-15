package app.web.pavelk.chat2.back1.auth.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class RefreshRequestDto {
    @NotNull
    private String refresh;
    @NotNull
    private String username;
}
