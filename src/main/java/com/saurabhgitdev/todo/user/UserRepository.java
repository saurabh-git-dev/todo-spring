package com.saurabhgitdev.todo.user;

import com.saurabhgitdev.todo.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

}
