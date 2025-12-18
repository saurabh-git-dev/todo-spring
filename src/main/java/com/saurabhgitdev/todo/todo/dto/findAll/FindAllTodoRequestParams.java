package com.saurabhgitdev.todo.todo.dto.findAll;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Null;

import java.util.Objects;
import java.util.UUID;

public record FindAllTodoRequestParams(@Schema(requiredMode = Schema.RequiredMode.NOT_REQUIRED) @Null UUID userId,
                                       @Schema(requiredMode = Schema.RequiredMode.NOT_REQUIRED) @Null Boolean user) {
    public FindAllTodoRequestParams(UUID userId, Boolean user) {
        this.userId = userId;
        this.user = Objects.requireNonNullElse(user, Boolean.FALSE);
    }
}
