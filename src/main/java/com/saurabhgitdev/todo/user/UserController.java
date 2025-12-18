package com.saurabhgitdev.todo.user;

import com.saurabhgitdev.todo.user.dto.CreateUserRequestBody;
import com.saurabhgitdev.todo.user.dto.CreateUserResponse;
import com.saurabhgitdev.todo.user.dto.FindAllUserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<CreateUserResponse> signup(@RequestBody CreateUserRequestBody requestBody) {
        CreateUserResponse res = userService.createUser(requestBody);
        return  ResponseEntity.ok(res);
    }

    @GetMapping
    public ResponseEntity<FindAllUserResponse> findAll() {
        FindAllUserResponse res = userService.findAll();
        return ResponseEntity.ok(res);
    }
}
