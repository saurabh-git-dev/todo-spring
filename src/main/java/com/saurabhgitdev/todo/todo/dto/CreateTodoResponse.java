package com.saurabhgitdev.todo.todo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

import java.time.OffsetDateTime;

public record CreateTodoResponse(@NotNull Long id, @NotBlank String title,
                                 @Schema(nullable = true, requiredMode = Schema.RequiredMode.REQUIRED) @Null String description,
                                 @NotBlank OffsetDateTime createdTime, @NotBlank OffsetDateTime updatedTime) {
    public CreateTodoResponse(Long id, String title, String description, OffsetDateTime createdTime, OffsetDateTime updatedTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }
}
