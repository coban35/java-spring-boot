package com.app.drone.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class DroneExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(DroneExceptionHandler.class);

    @ExceptionHandler(DroneIdNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> droneIdNotFoundException() {
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), "404", "Drone Id Not Found.");
        LOGGER.error("Drone Id Not Found.");
        return new ResponseEntity<>(exceptionResponse, HttpStatus.EXPECTATION_FAILED);
    }

}
