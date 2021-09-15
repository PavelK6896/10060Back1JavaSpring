package app.web.pavelk.chat2.back1.auth.repo;

import app.web.pavelk.chat2.back1.auth.schema.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
