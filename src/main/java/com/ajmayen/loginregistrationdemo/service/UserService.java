package com.ajmayen.loginregistrationdemo.service;

import com.ajmayen.loginregistrationdemo.model.User;
import com.ajmayen.loginregistrationdemo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> loginUser(String username,String password){
        return userRepository.findByUsername(username)
                .filter(user -> user.getPassword().equals(password));
    }



}
