package app.web.pavelk.chat2.back1.info.db.cassandra.repo;

import app.web.pavelk.chat2.back1.info.db.cassandra.schema.BookCassandra;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface BookCassandraRepo extends CassandraRepository<BookCassandra, Long> {
}
