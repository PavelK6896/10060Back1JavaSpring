package app.web.pavelk.chat2.back1.auth.controller;


import app.web.pavelk.chat2.back1.auth.exception.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(AuthException.class)
    public ResponseEntity<String> userAlreadyExists(Exception e) {
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }

}
