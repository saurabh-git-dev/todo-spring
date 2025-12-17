package com.saurabhgitdev.todo.todo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

public class CreateTodoResponse {

    @NotNull
    private Long id;

    @NotNull
    @NotBlank
    private String title;

    @Null
    @NotBlank
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CreateTodoResponse(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public CreateTodoResponse() {
    }
}
