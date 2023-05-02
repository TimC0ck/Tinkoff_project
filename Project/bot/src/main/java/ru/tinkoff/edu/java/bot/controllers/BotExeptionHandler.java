package ru.tinkoff.edu.java.bot.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.tinkoff.edu.java.bot.DTO.response.ApiErrorResponse;

@RestControllerAdvice
public class BotExeptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    Object ApiError(ApiErrorResponse apiErrorResponse) {
        return null;
    }
}

