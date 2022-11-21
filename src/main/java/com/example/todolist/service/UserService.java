package com.example.todolist.service;

import com.example.todolist.entity.UserEntity;
import com.example.todolist.exception.UserAlreadyExistException;
import com.example.todolist.exception.UserNotFoundException;
import com.example.todolist.model.User;
import com.example.todolist.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    // POST request
    public void registration(UserEntity userEntity) throws UserAlreadyExistException {
        if (userRepo.findByUsername(userEntity.getUsername()) != null) {
            throw new UserAlreadyExistException("User already exist");
        }
        userRepo.save(userEntity);
    }

    // GET requests
    public User getOne(Long id) throws UserNotFoundException {
        Optional isUser = userRepo.findById(id);
        if (isUser.isEmpty()) { // check if exist
            throw new UserNotFoundException("No user with such id");
        }
        UserEntity user = (UserEntity) isUser.get();
        return User.toModel(user);
    }

    public User getByUsername(String username) throws UserNotFoundException {
        UserEntity user = userRepo.findByUsername(username);
        if (user == null) { // check if exist
            throw new UserNotFoundException("No user with such username");
        }
        return User.toModel(user);
    }

    // DELETE requests
    public Long deleteOne(Long id) {
        userRepo.deleteById(id);
        return id;
    }

    public String deleteUsername(String username) {
        userRepo.deleteByUsername(username);
        return username;
    }
}
