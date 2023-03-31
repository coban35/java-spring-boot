package com.app.user.exception;

import com.app.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserExceptionHandler.class);

    @ExceptionHandler(UserIdNotFoundException.class)
    public final ResponseEntity<ApiResponse> userIdNotFoundException() {
        ApiResponse apiResponse = new ApiResponse(new Date(), "404", "User Id Not Found.");
        LOGGER.error("User Id Not Found.");
        return new ResponseEntity<>(apiResponse, HttpStatus.EXPECTATION_FAILED);
    }

}
