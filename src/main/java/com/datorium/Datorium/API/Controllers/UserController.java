package com.datorium.Datorium.API.Controllers;

import com.datorium.Datorium.API.DTOs.User;
import com.datorium.Datorium.API.Services.UserService;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController() {
        userService = new UserService();
    }

    @PostMapping("/add") // localhost:8080/user/add
    public void add(@RequestBody User user) throws BadRequestException {
        userService.add(user);
    }

    @GetMapping("/get")
    public ArrayList<User> get(User user) {
        return userService.get(user);
    }

    @GetMapping("/get/all") // localhost:8080/user/get/all
    public ArrayList<User> getAll() {
        return userService.getAll();
    }

    @PostMapping("/update")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/delete") // localhost:8080/user/delete?id=1
    public void delete(@RequestParam(name = "id") int id) {
        userService.delete(id);
    }
}