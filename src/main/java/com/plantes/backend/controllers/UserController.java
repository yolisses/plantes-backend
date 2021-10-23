package com.plantes.backend.controllers;

import com.plantes.backend.models.User;
import com.plantes.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    public List<User> users = new ArrayList<>();

    @Autowired
    UserRepository  userRepository;

    @GetMapping("/")
    public List<User> helloWorld() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User one(@PathVariable("id") Long id) {
        Optional<User> userFound = userRepository.findById(id);
        return userFound.isPresent() ? userFound.get() : null;
    }

    @PostMapping("/")
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }
}
