package ru.tinkoff.edu.java.bot.exceptions;


import ru.tinkoff.edu.java.bot.DTO.ApiErrorResponse;


public class internalServerErrorException extends RuntimeException {

    private final ApiErrorResponse apiErrorResponse;

    public internalServerErrorException(ApiErrorResponse apiErrorResponse) {
        super("Something went wrong on Scrapper server");
        this.apiErrorResponse = apiErrorResponse;
    }

    public ApiErrorResponse getApiErrorResponse() {
        return apiErrorResponse;
    }
}