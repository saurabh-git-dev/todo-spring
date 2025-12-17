package com.saurabhgitdev.todo.todo;

import com.saurabhgitdev.todo.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
