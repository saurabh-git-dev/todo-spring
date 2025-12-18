package com.saurabhgitdev.todo.user.dto;

import com.saurabhgitdev.todo.todo.dto.findAll.FindAllTodoResponseTodoUser;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record FindAllUserResponse (@NotNull List<FindAllUserResponseUser> data) {
    public FindAllUserResponse(List<FindAllUserResponseUser> data) {
        this.data = data;
    }
}