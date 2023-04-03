package ru.tinkoff.edu.java.scrapper.DTO.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.Set;

public record StackOverflowResponse(
        @JsonProperty("question_id") long questionId,
        @JsonProperty("tags") Set<String> tags,
        @JsonProperty("is_answered") boolean isAnswered,
        @JsonProperty("protected_date") OffsetDateTime protectedDate,
        @JsonProperty("last_activity_date") OffsetDateTime lastActivityDate,
        @JsonProperty("creation_date") OffsetDateTime creationDate,
        @JsonProperty("last_edit_date") OffsetDateTime lastEditDate,
        @JsonProperty("link") String link
) {
}
