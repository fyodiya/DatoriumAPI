package com.datorium.Datorium.API.Repo;

import com.datorium.Datorium.API.DTOs.User;

import java.util.ArrayList;

public class UserRepo {

    private ArrayList<User> users = new ArrayList<>();

    public int add(User user) {
        users.add(user);
        return users.size();
    }

    public ArrayList<User> getAllUsers() {
        //return new ArrayList<>(users);
        return users;
    }

    public User update(int userIndex, User updateUserDTO){
        var user = users.get(userIndex);
        user.name = updateUserDTO.name;
        return user;
    }

}
