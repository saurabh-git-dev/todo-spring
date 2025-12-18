package com.saurabhgitdev.todo.todo;

import com.saurabhgitdev.todo.todo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findAllByUser_Id(UUID userId);
}
