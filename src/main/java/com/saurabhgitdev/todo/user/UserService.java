package com.saurabhgitdev.todo.user;

import com.saurabhgitdev.todo.user.domain.User;
import com.saurabhgitdev.todo.user.dto.CreateUserRequestBody;
import com.saurabhgitdev.todo.user.dto.CreateUserResponse;
import com.saurabhgitdev.todo.user.dto.FindAllUserResponse;
import com.saurabhgitdev.todo.user.dto.FindAllUserResponseUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    // Constructor Injection (Spring auto-injects)
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public CreateUserResponse createUser(CreateUserRequestBody reqBody) {
        log.info(reqBody.toString());
        User user = new User();
        user.setName(reqBody.name());

        User res = userRepository.save(user);

        return new CreateUserResponse(
                res.getId(),
                res.getName(),
                res.getCreatedAt(),
                res.getUpdatedAt()
        );
    }

    public User getUser(UUID id) {
        log.info(id.toString());
        return userRepository.getReferenceById(id);
    }

    public FindAllUserResponse findAll() {
        List<User> users = userRepository.findAll();
        List<FindAllUserResponseUser> data = users.stream()
                .map(FindAllUserResponseUser::fromEntity)
                .toList();
        return new FindAllUserResponse(data);
    }
}
