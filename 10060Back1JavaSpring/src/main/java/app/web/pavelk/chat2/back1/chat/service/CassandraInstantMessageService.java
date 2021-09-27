package app.web.pavelk.chat2.back1.chat.service;

import app.web.pavelk.chat2.back1.chat.repository.InstantMessageRepository;
import app.web.pavelk.chat2.back1.chat.schema.InstantMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CassandraInstantMessageService {

    private final InstantMessageRepository instantMessageRepository;

    public List<InstantMessage> findAllInstantMessagesFor(String username, String chatRoomId) {
        return instantMessageRepository.findInstantMessagesByUsernameAndChatRoomId(username, chatRoomId);
    }

    public List<InstantMessage> findAll() {
        return instantMessageRepository.findAll();
    }

    public InstantMessage save(InstantMessage instantMessage) {
        return instantMessageRepository.save(instantMessage);
    }

}
