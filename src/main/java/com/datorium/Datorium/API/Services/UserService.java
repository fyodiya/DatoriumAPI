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
        if (user.getName().isEmpty() || user.getEmail().isEmpty()) {
            throw new BadRequestException("User name or email is empty!");
        }
        userRepo.add(user);
    }

    public ArrayList<User> get(User user) {
        if (user != null && user.getName() != null) {
            return userRepo.get();
        } else {
            System.err.println("Invalid user object or user name is null.");
            return new ArrayList<>(); // Return an empty list if user is null
        }
    }

    public ArrayList<User> getAll() {
        return userRepo.get();
    }

    public User update(User user) {
        if (user.getName() != null && user.getEmail() != null) {
            return userRepo.update(user);
        } else {
            System.err.println("Invalid data for user update.");
            return null;
        }
    }
}
