package com.saurabhgitdev.todo.todo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;

public class CreateTodoRequestBody {
    @NotBlank
    private String title;

    @Null
    private String description;


    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CreateTodoRequestBody(String title, String description) {
        this.title = this.title;
        this.description = description;
    }

    public CreateTodoRequestBody() {
    }
}
