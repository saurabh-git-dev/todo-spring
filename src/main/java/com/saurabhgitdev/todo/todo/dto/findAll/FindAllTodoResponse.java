package com.saurabhgitdev.todo.todo.dto.findAll;

import jakarta.validation.constraints.NotNull;

import java.util.List;


public record FindAllTodoResponse(@NotNull List<FindAllTodoResponseTodo> data) {
    public FindAllTodoResponse(List<FindAllTodoResponseTodo> data) {
        this.data = data;
    }
}
