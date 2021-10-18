package app.web.pavelk.chat2.back1.chat.service;

import app.web.pavelk.chat2.back1.chat.repository.InstantMessageRepository;
import app.web.pavelk.chat2.back1.chat.schema.InstantMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

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

    public List<InstantMessage> listOldMessagesFromUserOnSubscribe(SimpMessageHeaderAccessor headerAccessor) {
        Map<String, Object> sessionAttributes = headerAccessor.getSessionAttributes();
        if (sessionAttributes == null) {
            return Collections.emptyList();
        }
        String chatRoomId = sessionAttributes.get("chatRoomId").toString();
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return instantMessageRepository.findInstantMessagesByUsernameAndChatRoomId(name, chatRoomId);
    }

}
