package com.example.todolist.controller;

import com.example.todolist.entity.UserEntity;
import com.example.todolist.exception.UserAlreadyExistException;
import com.example.todolist.exception.UserNotFoundException;
import com.example.todolist.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity userEntity) {
        try {
            userService.registration(userEntity);
            return ResponseEntity.ok("It's done!");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error");
        }
    }

    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id) { // query param
        try {
            return ResponseEntity.ok(userService.getOne(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.deleteOne(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error id");
        }
    }

}
