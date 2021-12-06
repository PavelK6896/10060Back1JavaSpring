package app.web.pavelk.chat2.back1.info.service;


import app.web.pavelk.chat2.back1.info.db.cassandra.repo.BookCassandraRepo;
import app.web.pavelk.chat2.back1.info.db.cassandra.schema.BookCassandra;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class BookCassandraService {

    private final BookCassandraRepo bookCassandraRepo;

    public List<BookCassandra> getBooksCassandra() {
        return bookCassandraRepo.findAll();
    }

    public List<BookCassandra> createBooksCassandra() {
        bookCassandraRepo.save(BookCassandra.builder()
                .bookId(ThreadLocalRandom.current().nextLong())
                .username(String.valueOf((char) ThreadLocalRandom.current().nextInt(50, 125)))
                .number(ThreadLocalRandom.current().nextInt())
                .build());
        return getBooksCassandra();
    }
}
