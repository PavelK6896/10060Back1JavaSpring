package app.web.pavelk.chat2.back1.chat;

import app.web.pavelk.chat2.back1.chat.schema.ChatRoom;
import app.web.pavelk.chat2.back1.chat.schema.InstantMessage;
import app.web.pavelk.chat2.back1.chat.service.CassandraInstantMessageService;
import app.web.pavelk.chat2.back1.chat.service.RedisChatRoomService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatRoomController {

    private final RedisChatRoomService redisChatRoomService;
    private final CassandraInstantMessageService cassandraInstantMessageService;

    @GetMapping("/c/findAll")
    public List<InstantMessage> findAll() {
        return cassandraInstantMessageService.findAll();
    }

    @GetMapping("/c/findId")
    public List<InstantMessage> findAllInstantMessagesFor(@RequestParam("u") String username, @RequestParam("c") String chatRoomId) {
        return cassandraInstantMessageService.findAllInstantMessagesFor(username, chatRoomId);
    }

    @GetMapping("/c/save")
    public InstantMessage saveC() {
        return cassandraInstantMessageService.save(InstantMessage.builder()
                .chatRoomId(String.valueOf(ThreadLocalRandom.current().nextInt(10, 20)))
                .date(LocalDateTime.now())
                .toUser("22")
                .fromUser("33")
                .text("tt")
                .username("u")
                .build());
    }

    @GetMapping("/rooms")
    @Operation(summary = "findAllChatRoom")
    public List<ChatRoom> findAllChatRoom() {
        return redisChatRoomService.findAll();
    }

    @GetMapping("/room/id")
    @Operation(summary = "findByIdChatRoom")
    public ChatRoom findById(@RequestParam("id") String chatRoomId) {
        return redisChatRoomService.findById(chatRoomId);
    }

    @PostMapping("/room")
    @Operation(summary = "createChatRoom")
    public ChatRoom createChatRoom(@RequestBody ChatRoom chatRoom) {
        return redisChatRoomService.save(chatRoom);
    }

    @GetMapping("/chatroom/{chatRoomId}")
    public void join(@PathVariable String chatRoomId) {
        redisChatRoomService.join(chatRoomId);
    }

}
