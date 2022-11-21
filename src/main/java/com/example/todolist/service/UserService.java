package com.example.todolist.service;

import com.example.todolist.entity.UserEntity;
import com.example.todolist.exception.UserAlreadyExistException;
import com.example.todolist.exception.UserNotFoundException;
import com.example.todolist.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void registration(UserEntity userEntity) throws UserAlreadyExistException {
        if (userRepo.findByUsername(userEntity.getUsername()) != null) {
            throw new UserAlreadyExistException("User already exist");
        }
        userRepo.save(userEntity);
    }

    public UserEntity getOne(Long id) throws UserNotFoundException {
        Optional user = userRepo.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("No such user");
        }
        return (UserEntity) user.get();
    }
}