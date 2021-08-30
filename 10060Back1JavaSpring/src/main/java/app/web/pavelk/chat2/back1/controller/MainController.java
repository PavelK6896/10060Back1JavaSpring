package app.web.pavelk.chat2.back1.controller;


import app.web.pavelk.chat2.back1.db.mysql.schema.Book;
import app.web.pavelk.chat2.back1.db.cassandra.schema.Book2;
import app.web.pavelk.chat2.back1.db.redis.schema.Chat2;
import app.web.pavelk.chat2.back1.service.Book2Service;
import app.web.pavelk.chat2.back1.service.BookService;
import app.web.pavelk.chat2.back1.service.Chat2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final BookService bookService;
    private final Chat2Service chat2Service;
    private final Book2Service book2Service;

    @GetMapping("/g1")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/c1")
    public List<Book> createRandom() {
        return bookService.create();
    }

    @GetMapping("/g2")
    public List<Chat2> getChats() {
        return chat2Service.getChats();
    }

    @GetMapping("/c2")
    public Chat2 createChat() {
        return chat2Service.create();
    }

    @GetMapping("/g3")
    public List<Book2> getBooks2() {
        return book2Service.getBooks();
    }

    @GetMapping("/c3")
    public List<Book2> createBooks2() {
        return book2Service.create();
    }

    private final SimpMessagingTemplate simpMessagingTemplate;

    @GetMapping("/g4")
    public String mX() {
        simpMessagingTemplate.convertAndSend("/topic/", "message");
        return "ok";
    }


}
