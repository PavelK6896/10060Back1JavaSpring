package app.web.pavelk.chat2.back1.controller;


import app.web.pavelk.chat2.back1.schema.Book;
import app.web.pavelk.chat2.back1.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final BookService bookService;

    @GetMapping("/g")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/c")
    public List<Book> CreateRandom() {
        return bookService.create();
    }


}
