package app.web.pavelk.chat2.back1.db.cassandra.config;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CassandraConfig {
    @Bean
    public CqlSession session() {
        CqlSession cqlSession = CqlSession.builder().withKeyspace("test3").build();
        cqlSession.execute(
                "create table IF NOT EXISTS book2 (" +
                        "bookId bigint primary key," +
                        "username text" +
                        ");"
        );
        return cqlSession;
    }
}
