package app.web.pavelk.chat2.back1.chat.schema;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("chat_rooms")
public class ChatRoom {

    @Id
    private String id;
    private String name;
    private String description;
    private List<ChatRoomUser> connectedUsers = new ArrayList<>();


}
