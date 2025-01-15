package com.ajmayen.loginregistrationdemo.controller;

import com.ajmayen.loginregistrationdemo.model.User;
import com.ajmayen.loginregistrationdemo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        User registeredUser = userService.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user){
        Optional<User> loggedInUser = userService.loginUser(user.getUsername(),user.getPassword());
        if(loggedInUser.isPresent()){
            return ResponseEntity.ok("Login Successful");
        }
        return ResponseEntity.status(401).body("Invalid user or password");
    }


}
