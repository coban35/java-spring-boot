package com.app.drone.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {

    private LocalDateTime creationDate;

    private String code;

    private String message;

    public ExceptionResponse(LocalDateTime creationDate, String code, String message) {
        this.creationDate = creationDate;
        this.code = code;
        this.message = message;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
