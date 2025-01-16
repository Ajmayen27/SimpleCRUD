package com.ajmayen.loginregistrationdemo.service;

import com.ajmayen.loginregistrationdemo.model.User;
import com.ajmayen.loginregistrationdemo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

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



    public User updateUser(Integer id,User user){
        User userToUpdate = userRepository.findById(id).orElseThrow();
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());
        return userRepository.save(userToUpdate);
    }


    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }


}
