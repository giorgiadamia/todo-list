package com.example.todolist.controller;

import com.example.todolist.entity.ToDoEntity;
import com.example.todolist.exception.TaskNotFoundException;
import com.example.todolist.exception.UserNotFoundException;
import com.example.todolist.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @PostMapping
    public ResponseEntity createTask(@RequestBody ToDoEntity toDoEntity,
                                     @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(toDoService.createOneTask(toDoEntity, userId));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error id");
        }
    }

    @PutMapping
    public ResponseEntity updateTask(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(toDoService.updateOneTask(id));
        } catch (TaskNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error id");
        }
    }
}
