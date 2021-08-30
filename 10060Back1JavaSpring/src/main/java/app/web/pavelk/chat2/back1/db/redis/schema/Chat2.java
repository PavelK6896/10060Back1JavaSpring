package app.web.pavelk.chat2.back1.db.redis.schema;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("chat2")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Chat2 {

    @Id
    private String id;
    private String name;

}
