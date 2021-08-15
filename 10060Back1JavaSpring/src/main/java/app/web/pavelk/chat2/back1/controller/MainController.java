package app.web.pavelk.chat2.back1.controller;


import app.web.pavelk.chat2.back1.schema.Book;
import app.web.pavelk.chat2.back1.schema.Chat2;
import app.web.pavelk.chat2.back1.service.BookService;
import app.web.pavelk.chat2.back1.service.Chat2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final BookService bookService;
    private final Chat2Service chat2Service;

    @GetMapping("/g")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/c")
    public List<Book> CreateRandom() {
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


}
