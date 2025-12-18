package com.saurabhgitdev.todo.todo.dto.findAll;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.saurabhgitdev.todo.todo.domain.Todo;
import com.saurabhgitdev.todo.user.domain.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

import java.time.OffsetDateTime;
import java.util.UUID;

public record FindAllTodoResponseTodoUser(@NotNull UUID id, @NotNull String name) {
    public FindAllTodoResponseTodoUser(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public static FindAllTodoResponseTodoUser fromEntity(User user) {
        return new FindAllTodoResponseTodoUser(
                user.getId(),
                user.getName()
        );
    }
}