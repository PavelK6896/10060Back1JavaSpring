package app.web.pavelk.chat2.back1.chat;

import app.web.pavelk.chat2.back1.chat.schema.ChatRoom;
import app.web.pavelk.chat2.back1.chat.schema.ChatRoomUser;
import app.web.pavelk.chat2.back1.chat.schema.InstantMessage;
import app.web.pavelk.chat2.back1.chat.service.CassandraInstantMessageService;
import app.web.pavelk.chat2.back1.chat.service.RedisChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
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

    @GetMapping("/r/findAll")
    public List<ChatRoom> r() {
        return redisChatRoomService.findAll();
    }

    @GetMapping("/r/findById")
    public ChatRoom findById(@RequestParam("c") String chatRoomId) {
        return redisChatRoomService.findById(chatRoomId);
    }

    @GetMapping("/r/save")
    public ChatRoom saveR() {
        return redisChatRoomService.save(ChatRoom.builder()
                .id(String.valueOf(ThreadLocalRandom.current().nextInt(10, 20)))
                .description("dd")
                .name("nn")
                .build());
    }

    @GetMapping("/chatroom/{chatRoomId}")
    public void join(@PathVariable String chatRoomId) {
        redisChatRoomService.join(chatRoomId);
    }

    @SubscribeMapping("/connected.users")
    public List<ChatRoomUser> listChatRoomConnectedUsersOnSubscribe(@NotNull SimpMessageHeaderAccessor headerAccessor) {
        return redisChatRoomService.listChatRoomConnectedUsersOnSubscribe(headerAccessor);
    }

    @SubscribeMapping("/old.messages")
    public List<InstantMessage> listOldMessagesFromUserOnSubscribe(@NotNull SimpMessageHeaderAccessor headerAccessor) {
        return cassandraInstantMessageService.listOldMessagesFromUserOnSubscribe(headerAccessor);
    }


}
