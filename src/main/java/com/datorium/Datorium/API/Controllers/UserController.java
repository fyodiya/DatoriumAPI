package com.datorium.Datorium.API.Controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    //CRUD
    //AddUser
    //UpdateUser
    //GetUser
    //DeleteUser

    @GetMapping("/test")
    public String test(){
        return "testy testy";
    }
}