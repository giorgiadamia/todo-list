package com.example.todolist.controller;

import com.example.todolist.entity.ToDoEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class ToDoController {

    @PostMapping
    public ResponseEntity createTask(@RequestBody ToDoEntity toDoEntity) {
        try {
            return null; // here
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error id");
        }
    }
}
