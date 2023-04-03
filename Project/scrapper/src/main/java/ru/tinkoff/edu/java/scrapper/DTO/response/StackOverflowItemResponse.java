package ru.tinkoff.edu.java.scrapper.DTO.response;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

    public record StackOverflowItemResponse(@JsonProperty("items") List<StackOverflowItemResponse> items){}

