package app.web.pavelk.chat2.back1.service;


import app.web.pavelk.chat2.back1.db.redis.repo.Chat2Repo;
import app.web.pavelk.chat2.back1.db.redis.schema.Chat2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class Chat2Service {

    private final Chat2Repo chat2Repo;

    public Chat2 create() {
        return chat2Repo.save(Chat2.builder().id(String.valueOf(ThreadLocalRandom.current().nextInt()))
                .name(String.valueOf(ThreadLocalRandom.current().nextDouble())).build());
    }

    public List<Chat2> getChats() {
        return (List<Chat2>) chat2Repo.findAll();
    }

}
