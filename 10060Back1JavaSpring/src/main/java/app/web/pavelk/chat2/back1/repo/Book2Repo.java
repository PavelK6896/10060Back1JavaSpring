package app.web.pavelk.chat2.back1.repo;

import app.web.pavelk.chat2.back1.schema.Book2;
import org.springframework.data.cassandra.repository.CassandraRepository;


public interface Book2Repo extends CassandraRepository<Book2, Long> {
}
