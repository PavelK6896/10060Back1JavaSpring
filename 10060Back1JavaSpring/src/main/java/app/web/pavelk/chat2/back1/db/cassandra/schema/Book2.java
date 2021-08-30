package app.web.pavelk.chat2.back1.db.cassandra.schema;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("book2")
public class Book2 {

    @PrimaryKeyColumn(name = "bookId", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private Long bookId;

    private String username;

}
