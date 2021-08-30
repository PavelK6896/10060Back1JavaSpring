package app.web.pavelk.chat2.back1.db.cassandra.repo;

import app.web.pavelk.chat2.back1.db.cassandra.schema.Book2;
import org.springframework.data.cassandra.repository.CassandraRepository;


public interface Book2Repo extends CassandraRepository<Book2, Long> {
}
