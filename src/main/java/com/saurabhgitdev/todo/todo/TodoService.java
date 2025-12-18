package com.saurabhgitdev.todo.todo;

import com.saurabhgitdev.todo.todo.dto.CreateTodoRequestBody;
import com.saurabhgitdev.todo.todo.dto.CreateTodoResponse;
import com.saurabhgitdev.todo.todo.domain.Todo;
import com.saurabhgitdev.todo.todo.dto.findAll.FindAllTodoRequestParams;
import com.saurabhgitdev.todo.todo.dto.findAll.FindAllTodoResponse;
import com.saurabhgitdev.todo.todo.dto.findAll.FindAllTodoResponseTodo;
import com.saurabhgitdev.todo.user.UserService;
import com.saurabhgitdev.todo.user.domain.User;
import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class TodoService {

    private static final Logger log = LoggerFactory.getLogger(TodoService.class);
    private final TodoRepository todoRepository;
    private final UserService userService;

    // Constructor Injection (Spring auto-injects)
    public TodoService(TodoRepository todoRepository, UserService userService) {
        this.todoRepository = todoRepository;
        this.userService = userService;
    }

    public CreateTodoResponse createTodo(CreateTodoRequestBody reqBody) throws BadRequestException {

        if (Objects.equals(reqBody.title(), "")) {
            throw new BadRequestException("Please set a todo title");
        }
        log.info(reqBody.toString());

        User user = userService.getUser(reqBody.userId());
        if (user == null) {
            log.error("User not found");
            throw new BadRequestException("User not found");
        }
        Todo todo = new Todo();
        todo.setUser(user);
        todo.setTitle(reqBody.title());
        todo.setDescription(reqBody.description());

        Todo res = todoRepository.save(todo);

        return new CreateTodoResponse(
                res.getId(),
                res.getTitle(),
                res.getDescription(),
                res.getCreatedTime(),
                res.getUpdatedTime()
        );
    }

    public FindAllTodoResponse findAll(FindAllTodoRequestParams params) throws BadRequestException {
        List<Todo> todos;
        if (params.userId() == null) {
            todos = todoRepository.findAll();
        } else {
            todos = todoRepository.findAllByUser_Id(params.userId());
        }

        List<FindAllTodoResponseTodo> data = todos.stream()
                .map(todo -> FindAllTodoResponseTodo.fromEntity(todo, params.user()))
                .toList();

        return new FindAllTodoResponse(data);
    }
}
