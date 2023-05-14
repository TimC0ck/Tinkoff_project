package ru.tinkoff.edu.java.bot.configuration;
import jakarta.validation.constraints.NotNull;

public record ApplicationConfig(@NotNull String test, @NotNull String token, @NotNull boolean useQueue, String queueName, String exchangeName) {}