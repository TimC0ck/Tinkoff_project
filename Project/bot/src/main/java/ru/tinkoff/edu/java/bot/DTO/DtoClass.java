package ru.tinkoff.edu.java.bot.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Validated
@Data
public class DtoClass {
    public DtoClass(@NotNull int id,@NotNull String url,@NotNull String description,@NotNull int[] tgChatIds){
        this.id = id;
        this.url = url;
        this.description = description;
        this.tgChatIds = tgChatIds;
    }
    @NotNull
    private int id;
    @NotNull
    private String url;
    @NotNull
    private String description;
    @NotNull
    private int[] tgChatIds;
}