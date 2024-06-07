package com.hossana.expensetracker.controller;

import com.hossana.expensetracker.dto.UserRequest;
import com.hossana.expensetracker.entity.User;
import com.hossana.expensetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/create")
    public String createUser(@RequestBody UserRequest user) {
       return userService.createUser(user);
    }

    @PutMapping("/edit/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody UserRequest user) {
        return userService.updateUser(user, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
