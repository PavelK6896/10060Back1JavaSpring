package app.web.pavelk.chat2.back1.service;


import app.web.pavelk.chat2.back1.repo.Book2Repo;
import app.web.pavelk.chat2.back1.schema.Book2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class Book2Service {

    private final Book2Repo book2Repo;

    public List<Book2> getBooks() {
        return book2Repo.findAll();
    }

    public List<Book2> create() {
        book2Repo.save(Book2.builder().bookId(ThreadLocalRandom.current().nextLong())
                .username(String.valueOf(ThreadLocalRandom.current().nextLong())).build());
        return getBooks();
    }
}
