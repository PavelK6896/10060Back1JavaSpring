package app.web.pavelk.chat2.back1.service;


import app.web.pavelk.chat2.back1.repo.BookRepo;
import app.web.pavelk.chat2.back1.schema.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepo bookRepo;

    public List<Book> getBooks() {
        return bookRepo.findAll();
    }

    public List<Book> create() {
        bookRepo.save(Book.builder().b1(ThreadLocalRandom.current().nextLong()).build());
        return getBooks();
    }
}
