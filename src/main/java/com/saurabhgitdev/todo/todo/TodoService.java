package com.saurabhgitdev.todo.todo;

import com.saurabhgitdev.todo.todo.dto.CreateTodoRequestBody;
import com.saurabhgitdev.todo.todo.dto.CreateTodoResponse;
import com.saurabhgitdev.todo.todo.entity.Todo;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    // Constructor Injection (Spring auto-injects)
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public CreateTodoResponse createTodo(CreateTodoRequestBody reqBody) throws BadRequestException {

        if (Objects.equals(reqBody.getTitle(), "")) {
            throw new BadRequestException("Please set a todo title");
        }

        Todo todo = new Todo();
        todo.setTitle(reqBody.getTitle());
        todo.setDescription(reqBody.getDescription());

        todoRepository.save(todo);

        return new CreateTodoResponse(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription()
        );
    }
}
