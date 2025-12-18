package com.saurabhgitdev.todo.todo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record CreateTodoRequestBody(@NotBlank UUID userId, @NotBlank String title,
                                    @Schema(nullable = false, requiredMode = Schema.RequiredMode.NOT_REQUIRED) @NotNull(message = "description must not be null") @Size(min = 1, message = "description must not be empty") String description) {
    @Override
    public UUID userId() {
        return userId;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public String title() {
        return title;
    }

    public CreateTodoRequestBody(UUID userId, String title, String description) {
        this.userId = userId;
        this.title = title;
        this.description = description;
    }
}
