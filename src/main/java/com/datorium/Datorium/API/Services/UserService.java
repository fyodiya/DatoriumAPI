package com.datorium.Datorium.API.Services;

import com.datorium.Datorium.API.DTOs.User;
import com.datorium.Datorium.API.Repo.UserRepo;

import java.util.ArrayList;

public class UserService {
    private UserRepo userRepo;

    public UserService(){
        userRepo = new UserRepo();
    }

    public void add(User user){
        userRepo.add(user);
    }

    public ArrayList<User> get(){
        return userRepo.get();
    }

    public User update(int userIndex, User updateUserDTO){
        return userRepo.update(userIndex, updateUserDTO);
    }
}