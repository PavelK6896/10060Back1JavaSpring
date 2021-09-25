package app.web.pavelk.chat2.back1.chat;

import app.web.pavelk.chat2.back1.chat.service.CassandraInstantMessageService;
import app.web.pavelk.chat2.back1.chat.service.RedisChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatRoomController {

    private final RedisChatRoomService redisChatRoomService;
    private final CassandraInstantMessageService cassandraInstantMessageService;

    @GetMapping("/r")
    public String r() {
        redisChatRoomService.findAll();
        return "ok";
    }

    @GetMapping("/c")
    public String c() {
        cassandraInstantMessageService.findAll();
        return "ok";
    }


}
