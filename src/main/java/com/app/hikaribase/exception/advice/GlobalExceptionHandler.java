package com.app.hikaribase.exception.advice;

import com.app.hikaribase.config.ApiConstants;
import com.app.hikaribase.dto.response.ErrorResponse;
import com.app.hikaribase.exception.ConnectionTestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConnectionTestException.class)
    public ResponseEntity<?> handleConnectionTestError(ConnectionTestException e) {
        log.info("Error while validating new MySQL connection", e);
        ErrorResponse response = ErrorResponse.builder()
                .message(ApiConstants.CONNECTION_TEST_FAILED_MESSAGE)
                .timeStamp(LocalDateTime.now()).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<?> handleDBException(DataAccessException e) {
        String msg = Optional.of(e.getMostSpecificCause()).map(Throwable::getMessage)
                .orElse("");

        if (msg.contains(ApiConstants.UNIQUE)) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("The DB entity with same details already exists");
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("There was some error with DB operation.");
    }
}
