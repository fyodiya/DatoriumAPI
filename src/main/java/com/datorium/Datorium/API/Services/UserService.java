package com.datorium.Datorium.API.Services;

import com.datorium.Datorium.API.DTOs.User;
import com.datorium.Datorium.API.Repo.UserRepo;
import org.apache.coyote.BadRequestException;

import java.util.ArrayList;

public class UserService {
    private UserRepo userRepo;

    public UserService() {
        userRepo = new UserRepo();
    }

    public void add(User user) throws BadRequestException {
        if(user.name.isEmpty()){
            throw new BadRequestException("User name is empty");
        }

        userRepo.add(user);
    }

    public ArrayList<User> get(User user) {
        if (user != null && user.getName() != null) {
            return userRepo.get();
        } else {
            System.err.println("Invalid user object or user name is null.");
            return new ArrayList<>(); //return an empty list if user is null
        }
    }

    public User update(int userIndex, User updateUserDTO) {
        if (updateUserDTO != null && updateUserDTO.getName() != null) {
            return userRepo.update(userIndex, updateUserDTO);
        } else {
            System.err.println("Invalid update data.");
            return null;
        }
    }
}