package com.example.todolist.service;

import com.example.todolist.entity.ToDoEntity;
import com.example.todolist.entity.UserEntity;
import com.example.todolist.exception.TaskNotFoundException;
import com.example.todolist.exception.UserNotFoundException;
import com.example.todolist.repository.ToDoRepo;
import com.example.todolist.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepo toDoRepo;
    @Autowired
    private UserRepo userRepo;

    public ToDoEntity createOneTask(ToDoEntity toDoEntity, Long userId) throws UserNotFoundException {
        Optional isUser = userRepo.findById(userId);
        if (isUser.isEmpty()) {
            throw new UserNotFoundException("No user with such id");
        }
        UserEntity user = (UserEntity) isUser.get();
        toDoEntity.setUser(user);
        return toDoRepo.save(toDoEntity);
    }

    public ToDoEntity updateOneTask(Long id) throws TaskNotFoundException {
        Optional isTask = toDoRepo.findById(id);
        if (isTask.isEmpty()) {
            throw new TaskNotFoundException("No user with such id");
        }
        ToDoEntity toDoEntity = (ToDoEntity) isTask.get();
        toDoEntity.setCompleted(!toDoEntity.getCompleted());
        return toDoRepo.save(toDoEntity);
    }
}
