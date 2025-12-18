package com.saurabhgitdev.todo.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;
import java.util.UUID;

public record CreateUserResponse(@NotNull UUID id, @NotBlank String name, @NotBlank OffsetDateTime createdTime,
                                 @NotBlank OffsetDateTime updatedTime) {
    @Override
    public UUID id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public OffsetDateTime createdTime() {
        return createdTime;
    }

    @Override
    public OffsetDateTime updatedTime() {
        return updatedTime;
    }

    public CreateUserResponse(UUID id, String name, OffsetDateTime createdTime, OffsetDateTime updatedTime) {
        this.id = id;
        this.name = name;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }
}
