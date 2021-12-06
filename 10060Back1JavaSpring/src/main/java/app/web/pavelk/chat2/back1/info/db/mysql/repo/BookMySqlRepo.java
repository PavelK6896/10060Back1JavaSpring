package app.web.pavelk.chat2.back1.info.db.mysql.repo;

import app.web.pavelk.chat2.back1.info.db.mysql.schema.BookMySql;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookMySqlRepo extends JpaRepository<BookMySql, Long> {

}
