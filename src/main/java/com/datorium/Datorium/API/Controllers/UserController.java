package com.datorium.Datorium.API.Controllers;

import com.datorium.Datorium.API.DTOs.UpdateUserDTO;
import com.datorium.Datorium.API.DTOs.User;
import com.datorium.Datorium.API.Services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController() {
        userService = new UserService();
    }

    @PostMapping("/add") //localhost:8080/user/add
    public int add(@RequestBody User user) {
        return userService.add(user);
    }

    @GetMapping("/all") //localhost:8080/user/all
    public ArrayList<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/update")
    public User user(@RequestBody UpdateUserDTO updateUserDTO){
        return userService.update(updateUserDTO.userIndex, updateUserDTO.user);
    }

}

// CRUD
// AddUser
// UpdateUser
// GetUser
// DeleteUser