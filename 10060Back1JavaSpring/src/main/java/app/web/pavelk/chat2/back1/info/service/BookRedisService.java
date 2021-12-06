package app.web.pavelk.chat2.back1.info.service;


import app.web.pavelk.chat2.back1.info.db.redis.repo.BookRedisRepo;
import app.web.pavelk.chat2.back1.info.db.redis.schema.BookRedis;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class BookRedisService {

    private final BookRedisRepo bookRedisRepo;

    public List<BookRedis> getBooksRedis() {
        return (List<BookRedis>) bookRedisRepo.findAll();
    }

    public List<BookRedis> createBooksRedis() {
        bookRedisRepo.save(BookRedis.builder()
                .id(String.valueOf(ThreadLocalRandom.current().nextInt()))
                .name(String.valueOf(ThreadLocalRandom.current().nextDouble()))
                .number(ThreadLocalRandom.current().nextLong())
                .build());
        return getBooksRedis();
    }


}
