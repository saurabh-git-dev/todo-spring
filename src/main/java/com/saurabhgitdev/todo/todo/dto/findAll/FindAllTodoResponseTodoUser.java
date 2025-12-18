package com.saurabhgitdev.todo.todo.dto.findAll;

import com.saurabhgitdev.todo.user.domain.User;
import jakarta.validation.constraints.NotNull;

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