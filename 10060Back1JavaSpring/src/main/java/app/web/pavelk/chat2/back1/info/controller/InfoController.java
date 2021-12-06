package app.web.pavelk.chat2.back1.info.controller;


import app.web.pavelk.chat2.back1.info.db.cassandra.schema.BookCassandra;
import app.web.pavelk.chat2.back1.info.db.mysql.schema.BookMySql;
import app.web.pavelk.chat2.back1.info.db.redis.schema.BookRedis;
import app.web.pavelk.chat2.back1.info.service.BookCassandraService;
import app.web.pavelk.chat2.back1.info.service.BookMySqlService;
import app.web.pavelk.chat2.back1.info.service.BookRedisService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Info", description = "test")
public class InfoController {

    private final BookCassandraService bookCassandraService;
    private final BookMySqlService bookMySqlService;
    private final BookRedisService bookRedisService;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @GetMapping("/")
    @Operation(summary = "Check chat 2")
    public String checkChat2() {
        return "Chat 2 ok.";
    }

    @GetMapping("/books-my-sql")
    @Operation(summary = "getBooksMySql")
    public List<BookMySql> getBooksMySql() {
        return bookMySqlService.getBooksMySql();
    }

    @PostMapping("/books-my-sql")
    @Operation(summary = "createBookMySql")
    public List<BookMySql> createBookMySql() {
        return bookMySqlService.createBookMySql();
    }

    @GetMapping("/books-redis")
    @Operation(summary = "getBooksRedis")
    public List<BookRedis> getBooksRedis() {
        return bookRedisService.getBooksRedis();
    }

    @PostMapping("/books-redis")
    @Operation(summary = "createBooksRedis")
    public List<BookRedis> createBooksRedis() {
        return bookRedisService.createBooksRedis();
    }

    @GetMapping("/books-cassandra")
    @Operation(summary = "getBooksCassandra")
    public List<BookCassandra> getBooksCassandra() {
        return bookCassandraService.getBooksCassandra();
    }

    @PostMapping("/books-cassandra")
    @Operation(summary = "createBooksCassandra")
    public List<BookCassandra> createBooksCassandra() {
        return bookCassandraService.createBooksCassandra();
    }

    @GetMapping("/send-topic-message")
    public String sendTopicMessage() {
        simpMessagingTemplate.convertAndSend("/topic/", "message");
        return "sendTopicMessage";
    }

}
