package com.saurabhgitdev.todo.todo;

import com.saurabhgitdev.todo.todo.dto.CreateTodoRequestBody;
import com.saurabhgitdev.todo.todo.dto.CreateTodoResponse;
import com.saurabhgitdev.todo.todo.dto.findAll.FindAllTodoRequestParams;
import com.saurabhgitdev.todo.todo.dto.findAll.FindAllTodoResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<CreateTodoResponse> create(@RequestBody CreateTodoRequestBody reqBody) throws BadRequestException {
        CreateTodoResponse res = todoService.createTodo(reqBody);
        return ResponseEntity.ok(res);
    }

    @GetMapping
    public ResponseEntity<FindAllTodoResponse> findAll(@ModelAttribute FindAllTodoRequestParams params) {
        FindAllTodoResponse res = todoService.findAll(params);
        return ResponseEntity.ok(res);
    }
}