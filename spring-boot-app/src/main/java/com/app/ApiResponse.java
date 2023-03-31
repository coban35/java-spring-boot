package com.app;

import java.util.Date;

public class ApiResponse {

    private Date creationDate;

    private String code;

    private String message;

    public ApiResponse(Date creationDate, String code, String message) {
        this.creationDate = creationDate;
        this.code = code;
        this.message = message;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
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
