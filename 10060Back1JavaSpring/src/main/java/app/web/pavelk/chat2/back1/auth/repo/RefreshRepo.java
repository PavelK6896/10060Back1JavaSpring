package app.web.pavelk.chat2.back1.auth.repo;

import app.web.pavelk.chat2.back1.auth.schema.Refresh;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshRepo extends JpaRepository<Refresh, Long> {
    Optional<Refresh> findByToken(String token);

    void deleteByToken(String token);
}
