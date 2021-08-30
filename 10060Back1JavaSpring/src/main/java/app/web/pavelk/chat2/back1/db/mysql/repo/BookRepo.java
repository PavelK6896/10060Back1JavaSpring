package app.web.pavelk.chat2.back1.db.mysql.repo;


import app.web.pavelk.chat2.back1.db.mysql.schema.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {

}
