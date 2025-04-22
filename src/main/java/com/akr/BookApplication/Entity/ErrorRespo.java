package com.akr.BookApplication.Entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class ErrorRespo {
    private LocalDateTime timestamp;
    private String message;
    private String details;

    public ErrorRespo(LocalDateTime timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
}
