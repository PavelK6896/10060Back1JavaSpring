package app.web.pavelk.chat2.back1.chat;

import app.web.pavelk.chat2.back1.chat.repository.InstantMessageRepository;
import app.web.pavelk.chat2.back1.chat.schema.ChatRoomUser;
import app.web.pavelk.chat2.back1.chat.schema.InstantMessage;
import app.web.pavelk.chat2.back1.chat.service.CassandraInstantMessageService;
import app.web.pavelk.chat2.back1.chat.service.RedisChatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class WebsocketController {

    private final RedisChatRoomService redisChatRoomService;
    private final CassandraInstantMessageService cassandraInstantMessageService;

    @SubscribeMapping("/connected.users")
    public List<ChatRoomUser> listChatRoomConnectedUsersOnSubscribe(@NotNull SimpMessageHeaderAccessor headerAccessor) {
        log.info("Sub scribeMapping/connected.users 1");
        return redisChatRoomService.listChatRoomConnectedUsersOnSubscribe(headerAccessor);
    }

    @SubscribeMapping("/old.messages")
    public List<InstantMessage> listOldMessagesFromUserOnSubscribe(@NotNull SimpMessageHeaderAccessor headerAccessor) {
        log.info("Sub scribeMapping/old.messages 2");
        return cassandraInstantMessageService.listOldMessagesFromUserOnSubscribe(headerAccessor);
    }


    @SubscribeMapping("/message")
    public void subMessage(@NotNull SimpMessageHeaderAccessor headerAccessor) {
        log.info("Sub Message " + headerAccessor.toString());
    }


    @MessageMapping("/chat")
    public void messageChat(String s) {
        log.info("messageChat " + s);
    }

    @MessageMapping("/message")
    public void messageMessage(String s) {
        log.info("messageMessage " + s);
    }


    private final SimpMessagingTemplate simpMessagingTemplate;
    private final InstantMessageRepository instantMessageRepository;

    @MessageMapping("/send.message")
    public void sendMessage(@Payload InstantMessage instantMessage, SimpMessageHeaderAccessor headerAccessor) {
        String chatRoomId = "101";
        instantMessage.setFromUser("One user");
        instantMessage.setChatRoomId(chatRoomId);

        //отправить сообщение всем
        simpMessagingTemplate.convertAndSend(
                "/topic/" + chatRoomId + ".public.messages",
                instantMessage);
        instantMessageRepository.save(instantMessage);
    }


}
