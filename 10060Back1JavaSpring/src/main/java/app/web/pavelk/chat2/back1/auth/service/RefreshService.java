package app.web.pavelk.chat2.back1.auth.service;

import app.web.pavelk.chat2.back1.auth.exception.AuthException;
import app.web.pavelk.chat2.back1.auth.repo.RefreshRepo;
import app.web.pavelk.chat2.back1.auth.schema.Refresh;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshService {

    private final RefreshRepo refreshRepo;

    public Refresh generateRefresh() {
        return refreshRepo.save(Refresh.builder()
                .created(LocalDateTime.now())
                .token(UUID.randomUUID().toString())
                .build());
    }

    public Refresh validateRefresh(String token) {
        return refreshRepo.findByToken(token).orElseThrow(() -> new AuthException("Invalid refresh Token"));
    }

    public Refresh updateRefresh(Refresh refresh) {
        refresh.setToken(UUID.randomUUID().toString());
        return refreshRepo.save(refresh);
    }

    public void deleteRefresh(String token) {
        refreshRepo.deleteByToken(token);
    }


}
