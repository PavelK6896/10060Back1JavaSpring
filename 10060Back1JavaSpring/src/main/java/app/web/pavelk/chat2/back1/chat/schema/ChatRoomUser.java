package app.web.pavelk.chat2.back1.chat.schema;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoomUser {

    private String username;
    private LocalDateTime joinedAt = LocalDateTime.now();

}
