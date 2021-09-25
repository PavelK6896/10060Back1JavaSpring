package app.web.pavelk.chat2.back1.chat.repository;


import app.web.pavelk.chat2.back1.chat.schema.InstantMessage;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

public interface InstantMessageRepository extends CassandraRepository<InstantMessage, InstantMessage.InstantMessageId> {
    List<InstantMessage> findInstantMessagesByUsernameAndChatRoomId(String username, String chatRoomId);
}
