package com.ajmayen.loginRegistrationPortal.service;

import com.ajmayen.loginRegistrationPortal.model.User;
import com.ajmayen.loginRegistrationPortal.repository.UserRepository;
import com.ajmayen.loginRegistrationPortal.util.CaesarCypher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }


    public User registerUser(User user){
        user.setPassword(CaesarCypher.encrypt(user.getPassword()));
        return userRepository.save(user);
    }


    public Optional<User> loginUser(String username,String password){
        return userRepository.findByUsername(username)
                .filter(user -> CaesarCypher.decrypt(user.getPassword()).equals(password));
    }



    public User updateUser(Integer id,User user){
        User userToUpdate = userRepository.findById(id).orElseThrow();
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(CaesarCypher.encrypt(user.getPassword())) ;
        return userRepository.save(userToUpdate);
    }


    public void deleteUser(Integer id){

        userRepository.deleteById(id);
    }


}
