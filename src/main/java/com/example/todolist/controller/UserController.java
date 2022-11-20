package com.example.todolist.controller;

import com.example.todolist.entity.UserEntity;
import com.example.todolist.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity userEntity) {
        try {
            userRepo.save(userEntity);
            return ResponseEntity.ok("It's done!");
        } catch (Exception e) {
            ResponseEntity.badRequest().body("error");
        }
        return null;
    }

    @GetMapping
    public ResponseEntity getUser() {
        try {
            return ResponseEntity.ok("servddddder");
        } catch (Exception e) {
            ResponseEntity.badRequest().body("error");
        }
        return null;
    }
}
