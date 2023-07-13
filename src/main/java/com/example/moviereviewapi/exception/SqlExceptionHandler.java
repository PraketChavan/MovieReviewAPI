package com.example.moviereviewapi.exception;

import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Log
public class SqlExceptionHandler {

    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "The movie with the given imdbId already exists")
    @ExceptionHandler({ MovieAlreadyExistsException.class })
    public void conflict() {
    }

}
