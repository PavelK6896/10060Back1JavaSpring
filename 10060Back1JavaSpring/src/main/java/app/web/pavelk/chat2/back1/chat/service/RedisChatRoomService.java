package app.web.pavelk.chat2.back1.chat.service;

import app.web.pavelk.chat2.back1.chat.repository.ChatRoomRepository;
import app.web.pavelk.chat2.back1.chat.schema.ChatRoom;
import app.web.pavelk.chat2.back1.chat.schema.ChatRoomUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    public ChatRoom findById(String chatRoomId) {
        return chatRoomRepository.findById(chatRoomId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));
    }

    public List<ChatRoom> findAll() {
        return (List<ChatRoom>) chatRoomRepository.findAll();
    }

    public ChatRoom save(ChatRoom chatRoom) {
        return chatRoomRepository.save(chatRoom);
    }

    public List<ChatRoomUser> listChatRoomConnectedUsersOnSubscribe(SimpMessageHeaderAccessor headerAccessor) {
        Map<String, Object> sessionAttributes = headerAccessor.getSessionAttributes();
        if (sessionAttributes == null) {
            return Collections.emptyList();
        }
        String chatRoomId = Objects.requireNonNullElse(sessionAttributes.get("chatRoomId"), "101").toString();
        return findById(chatRoomId).getConnectedUsers();
    }

    public void join(String chatRoomId) {
        log.info(chatRoomId);
    }
}
