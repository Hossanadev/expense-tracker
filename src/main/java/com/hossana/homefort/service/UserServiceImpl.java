package com.hossana.homefort.service;

import com.hossana.homefort.dto.UserRequest;
import com.hossana.homefort.entity.User;
import com.hossana.homefort.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public String createUser(UserRequest userRequest) {
        if (userRepository.existsByEmail(userRequest.getEmail())) {
            return "You already have an account.";
        }
        if (userRequest.getFirstName().isEmpty()) {
            return "Please enter your first name.";
        }
        if (userRequest.getLastName().isEmpty()) {
            return "Please enter your first name.";
        }
        if (userRequest.getEmail().isEmpty()) {
            return "Please enter your email.";
        }
        if (userRequest.getPassword().isEmpty()) {
            return "Please enter your password.";
        }
        if (userRequest.getPassword().length() < 8) {
            return "Password must be least 8 characters.";
        }
        User newUser = User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .build();
        userRepository.save(newUser);
        return userRequest.getFirstName() + "'s account created successfully.";
    }

    @Override
    public String updateUser(UserRequest userRequest, Long id) {
        if (userRequest.getFirstName().isEmpty()) {
            return "Please enter your first name.";
        }
        if (userRequest.getLastName().isEmpty()) {
            return "Please enter your first name.";
        }
        if (userRequest.getEmail().isEmpty()) {
            return "Please enter your email.";
        }
        if (userRequest.getPassword().isEmpty()) {
            return "Please enter your password.";
        }
        if (userRequest.getPassword().length() < 8) {
            return "Password must be least 8 characters.";
        }
        try {
            User updatedUser = userRepository.findById(id).get();
            updatedUser.setFirstName(userRequest.getFirstName());
            updatedUser.setLastName(userRequest.getLastName());
            updatedUser.setEmail(userRequest.getEmail());
            updatedUser.setPassword(userRequest.getPassword());
            userRepository.save(updatedUser);
            return "Record updated successfully.";
        } catch (NoSuchElementException e) {
            return "User does not exist.";
        }
    }

    @Override
    public String deleteUser(Long id) {
        try {
            User deletedUser = userRepository.findById(id).get();
            userRepository.delete(deletedUser);
            return "Record deleted successfully.";
        } catch (NoSuchElementException e) {
            return "User does not exist.";
        }
    }
}