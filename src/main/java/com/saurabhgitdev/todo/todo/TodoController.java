package com.saurabhgitdev.todo.todo;

import com.saurabhgitdev.todo.todo.dto.CreateTodoRequestBody;
import com.saurabhgitdev.todo.todo.dto.CreateTodoResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public CreateTodoResponse create(@RequestBody CreateTodoRequestBody reqBody) throws BadRequestException {
        return todoService.createTodo(reqBody);
    }

    @GetMapping("{id}")
    public String get(@PathVariable String id) {
        return "Returned data for " + id;
    }

    @GetMapping
    public String getAll() {
        return "Spring Boot REST API is running 🚀";
    }
}