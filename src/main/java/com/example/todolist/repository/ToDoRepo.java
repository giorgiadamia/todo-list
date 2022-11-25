package com.example.todolist.repository;

import com.example.todolist.entity.ToDoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepo extends CrudRepository<ToDoEntity, Long> {
}
