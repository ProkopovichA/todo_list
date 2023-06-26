package com.prokopovich.todo_list.service;

import com.prokopovich.todo_list.entity.UserEntity;
import com.prokopovich.todo_list.model.User;
import com.prokopovich.todo_list.repository.UserRepo;
import exception.UserAlreadyExistException;
import exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("User with that name already exists");
        }
        return userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if(user == null) {
            throw new UserNotFoundException("User not found");
        }
        return User.toModel(user);
    }

     public Long delete(Long id) {
        userRepo.deleteById(id);
        return id;
     }

}
