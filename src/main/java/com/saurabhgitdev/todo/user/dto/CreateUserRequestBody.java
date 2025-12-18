package com.saurabhgitdev.todo.user.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateUserRequestBody (@NotBlank String name) {
    public CreateUserRequestBody(String name) {
        this.name = name;
    }
}
