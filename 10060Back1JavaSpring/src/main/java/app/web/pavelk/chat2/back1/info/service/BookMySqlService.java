package app.web.pavelk.chat2.back1.info.service;


import app.web.pavelk.chat2.back1.info.db.mysql.repo.BookMySqlRepo;
import app.web.pavelk.chat2.back1.info.db.mysql.schema.BookMySql;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class BookMySqlService {

    private final BookMySqlRepo bookMySqlRepo;

    public List<BookMySql> getBooksMySql() {
        return bookMySqlRepo.findAll();
    }

    public List<BookMySql> createBookMySql() {
        bookMySqlRepo.save(BookMySql.builder()
                .number(ThreadLocalRandom.current().nextLong())
                .name(String.valueOf((char) ThreadLocalRandom.current().nextInt(34, 125)))
                .build());
        return getBooksMySql();
    }
}
