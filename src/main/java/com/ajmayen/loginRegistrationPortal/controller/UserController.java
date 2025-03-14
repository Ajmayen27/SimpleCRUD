package com.ajmayen.loginRegistrationPortal.controller;

import com.ajmayen.loginRegistrationPortal.model.User;
import com.ajmayen.loginRegistrationPortal.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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



    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable int id,@RequestBody User user){
        return userService.updateUser(id,user);
    }



    @GetMapping("/allUsers")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return ResponseEntity.ok("Successfully Deleted");
    }



}
