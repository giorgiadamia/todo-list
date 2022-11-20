package com.example.todolist.controller;

import com.example.todolist.entity.UserEntity;
import com.example.todolist.repository.UserRepo;
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
            if (userRepo.findByUsername(userEntity.getUsername()) != null) {
                return ResponseEntity.badRequest().body("User with such a name already exist");
            }
            userRepo.save(userEntity);
            return ResponseEntity.ok("It's done!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error");
        }
    }

    @GetMapping
    public ResponseEntity getUser() {
        try {
            return ResponseEntity.ok("server");
        } catch (Exception e) {
            ResponseEntity.badRequest().body("error");
        }
        return null;
    }
}
