package com.datorium.Datorium.API.Controllers;
import com.datorium.Datorium.API.DTOs.User;
import com.datorium.Datorium.API.Services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    public UserController(){
        userService = new UserService();
    }

    //CRUD
    //AddUser
    //UpdateUser
    //GetUser
    //DeleteUser

//    @GetMapping("/test")
//    public String test(){
//        return "testy testy";
//    }

    //@GetMapping
    @PostMapping("/add") //localhost:8080/user/add
    public int add(@RequestBody User user){
        return userService.add(user);
    }

}