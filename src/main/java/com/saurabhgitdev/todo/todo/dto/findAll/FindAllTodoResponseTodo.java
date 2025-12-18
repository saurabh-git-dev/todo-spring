package com.saurabhgitdev.todo.todo.dto.findAll;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.saurabhgitdev.todo.todo.domain.Todo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

import java.time.OffsetDateTime;

public record FindAllTodoResponseTodo(@NotNull Long id, @NotBlank String title,
                                      @Schema(nullable = true, requiredMode = Schema.RequiredMode.REQUIRED) @Null String description,
                                      @NotBlank OffsetDateTime createdTime, @NotBlank OffsetDateTime updatedTime,
                                      @Schema(requiredMode = Schema.RequiredMode.NOT_REQUIRED)
                                      @JsonInclude(JsonInclude.Include.NON_NULL) @Null FindAllTodoResponseTodoUser user) {
    public FindAllTodoResponseTodo(Long id, String title, String description, OffsetDateTime createdTime, OffsetDateTime updatedTime, FindAllTodoResponseTodoUser user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
        this.user = user;
    }

    public static FindAllTodoResponseTodo fromEntity(Todo todo, boolean includeUser) {
        return new FindAllTodoResponseTodo(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.getCreatedTime(),
                todo.getUpdatedTime(),
                includeUser ? FindAllTodoResponseTodoUser.fromEntity(todo.getUser()) : null
        );
    }

}