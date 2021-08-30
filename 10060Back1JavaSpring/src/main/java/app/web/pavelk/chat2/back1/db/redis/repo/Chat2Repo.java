package app.web.pavelk.chat2.back1.db.redis.repo;

import app.web.pavelk.chat2.back1.db.redis.schema.Chat2;
import org.springframework.data.repository.CrudRepository;

public interface Chat2Repo extends CrudRepository<Chat2, String> {
}
