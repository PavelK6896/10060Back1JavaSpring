package app.web.pavelk.chat2.back1.info.db.redis.repo;

import app.web.pavelk.chat2.back1.info.db.redis.schema.BookRedis;
import org.springframework.data.repository.CrudRepository;

public interface BookRedisRepo extends CrudRepository<BookRedis, String> {
}
