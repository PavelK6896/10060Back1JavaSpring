package app.web.pavelk.chat2.back1.auth.service;

import app.web.pavelk.chat2.back1.auth.exception.AuthException;
import app.web.pavelk.chat2.back1.auth.repo.RefreshRepo;
import app.web.pavelk.chat2.back1.auth.repo.UserRepo;
import app.web.pavelk.chat2.back1.auth.schema.Refresh;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshService {

    private final RefreshRepo refreshRepo;
    private final UserRepo userRepo;

    public Refresh generateRefresh(String username, HttpServletRequest httpServletRequest) {
        String remoteAddress = httpServletRequest.getRemoteAddr();
        String clientIP = httpServletRequest.getHeader("X-Real-IP");
        System.out.println(remoteAddress);
        System.out.println(clientIP);
        Refresh refresh;
        Refresh.RefreshBuilder refreshBuilder = Refresh.builder();
        Optional<Refresh> byUsernameAndRemoteAddress = refreshRepo.findByUsernameAndRemoteAddress(username, remoteAddress);
        LocalDateTime now = LocalDateTime.now();
        if (byUsernameAndRemoteAddress.isPresent()) {
            refresh = byUsernameAndRemoteAddress.get();
            refresh.setConnected(now);
            refresh = refreshRepo.save(refresh);
        } else {
            refreshBuilder
                    .token(UUID.randomUUID().toString())
                    .created(now)
                    .connected(now)
                    .remoteAddress(remoteAddress)
                    .userId(userRepo.findByUsername(username).orElseThrow(() -> new AuthException("Not found user.")).getId());
            refresh = refreshRepo.save(refreshBuilder.build());
        }
        return refresh;
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
