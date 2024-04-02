package com.hossana.expensetracker.service;

import com.hossana.expensetracker.dto.UserRequest;
import com.hossana.expensetracker.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    String createUser(UserRequest userRequest);
    String updateUser(UserRequest userRequest, Long id);
    String deleteUser(UserRequest userRequest, Long id);
}
