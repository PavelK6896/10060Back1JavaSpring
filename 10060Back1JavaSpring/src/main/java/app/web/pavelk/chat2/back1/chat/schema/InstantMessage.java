package app.web.pavelk.chat2.back1.chat.schema;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("messages")
public class InstantMessage {

    @JsonIgnore
    @PrimaryKeyColumn(name = "username", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String username;

    @PrimaryKeyColumn(name = "chatRoomId", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private String chatRoomId;

    @PrimaryKeyColumn(name = "date", ordinal = 2, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
    private LocalDateTime date;

    private String fromUser;
    private String toUser;
    private String text;


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InstantMessageId {
        private String username;
        private String chatRoomId;
        private LocalDateTime date;
    }

}
