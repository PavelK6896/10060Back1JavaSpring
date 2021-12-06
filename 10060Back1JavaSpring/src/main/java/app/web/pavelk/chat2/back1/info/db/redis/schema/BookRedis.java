package app.web.pavelk.chat2.back1.info.db.redis.schema;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("chat2")
public class BookRedis {

    @Id
    private String id;
    private String name;
    private Long number;

}
