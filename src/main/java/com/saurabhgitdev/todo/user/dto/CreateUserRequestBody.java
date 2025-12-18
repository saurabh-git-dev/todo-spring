package com.saurabhgitdev.todo.user.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateUserRequestBody {
    @NotBlank
    private String name;

    public String getName() {
        return name;
    }
}
