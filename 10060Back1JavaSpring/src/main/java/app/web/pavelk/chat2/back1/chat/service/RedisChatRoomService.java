package app.web.pavelk.chat2.back1.chat.service;

import app.web.pavelk.chat2.back1.chat.repository.ChatRoomRepository;
import app.web.pavelk.chat2.back1.chat.schema.ChatRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RedisChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    public ChatRoom findById(String chatRoomId) {
        ChatRoom chatRoom = chatRoomRepository.findById(chatRoomId).orElseThrow(() -> new RuntimeException());
        System.out.println(chatRoom.getId());
        return chatRoom;
    }

    public List<ChatRoom> findAll() {
        List<ChatRoom> list = (List<ChatRoom>) chatRoomRepository.findAll();
        System.out.println(list.size());
        return list;
    }

}
