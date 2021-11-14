package app.web.pavelk.chat2.back1.chat;

import app.web.pavelk.chat2.back1.chat.schema.ChatRoomUser;
import app.web.pavelk.chat2.back1.chat.schema.InstantMessage;
import app.web.pavelk.chat2.back1.chat.service.CassandraInstantMessageService;
import app.web.pavelk.chat2.back1.chat.service.RedisChatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
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
        log.info("SubscribeMapping/connected.users");
        return redisChatRoomService.listChatRoomConnectedUsersOnSubscribe(headerAccessor);
    }


    @SubscribeMapping("/old.messages")
    public List<InstantMessage> listOldMessagesFromUserOnSubscribe(@NotNull SimpMessageHeaderAccessor headerAccessor) {
        log.info("SubscribeMapping/old.messages");
        return cassandraInstantMessageService.listOldMessagesFromUserOnSubscribe(headerAccessor);
    }



}
