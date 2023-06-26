package com.prokopovich.todo_list.controller;

import com.prokopovich.todo_list.entity.UserEntity;
import com.prokopovich.todo_list.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            if (userRepo.findByUsername(user.getUsername()) != null) {
                return ResponseEntity.badRequest().body("User with that name already exists");
            }
            userRepo.save(user);
            return ResponseEntity.ok("User successfully created");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping
    public ResponseEntity getUsers() {
        try {
            return ResponseEntity.ok("Server is work");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }

    }
}
