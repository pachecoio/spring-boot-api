package com.example.focinhos.controller;

import com.example.focinhos.model.User;
import com.example.focinhos.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/api/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping()
    public @ResponseBody
    Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseEntity create(@RequestBody User input) {
        User user = userRepository.save(input);
        return ResponseEntity.status(201).body(user);
    }

}
