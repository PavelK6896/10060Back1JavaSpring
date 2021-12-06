package app.web.pavelk.chat2.back1.info.db.cassandra.config;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

@Configuration
@Repository
public class CassandraConfig {
    @Bean
    public CqlSession session() {
        //create keyspace chat2 with replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

        CqlSession cqlSession = CqlSession.builder().withKeyspace("chat2").build();
        cqlSession.execute(
                "create table IF NOT EXISTS book_cassandra (" +
                        "book_id bigint primary key," +
                        "username text," +
                        "number int" +
                        ");"
        );
        cqlSession.execute(
                "create table IF NOT EXISTS messages (" +
                        "username text," +
                        "chatRoomId text," +
                        "date timestamp," +
                        "fromUser text," +
                        "toUser text," +
                        "text text," +
                        "PRIMARY KEY ((username, chatRoomId), date)" +
                        ");"
        );
        return cqlSession;
    }
}
