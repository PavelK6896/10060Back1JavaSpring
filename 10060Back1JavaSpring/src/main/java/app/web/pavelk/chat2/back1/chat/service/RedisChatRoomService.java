package app.web.pavelk.chat2.back1.chat.service;

import app.web.pavelk.chat2.back1.chat.repository.ChatRoomRepository;
import app.web.pavelk.chat2.back1.chat.schema.ChatRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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

    public ChatRoom save(ChatRoom build) {
        return chatRoomRepository.save(build);
    }
}
