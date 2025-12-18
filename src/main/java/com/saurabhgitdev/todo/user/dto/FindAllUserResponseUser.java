package com.saurabhgitdev.todo.user.dto;

import com.saurabhgitdev.todo.user.domain.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;
import java.util.UUID;

public record FindAllUserResponseUser(@NotNull UUID id, @NotNull String name, @NotBlank OffsetDateTime createdTime,
                                      @NotBlank OffsetDateTime updatedTime) {
    public FindAllUserResponseUser(UUID id, String name, OffsetDateTime createdTime, OffsetDateTime updatedTime) {
        this.id = id;
        this.name = name;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    public static FindAllUserResponseUser fromEntity(User user) {
        return new FindAllUserResponseUser(
                user.getId(),
                user.getName(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}