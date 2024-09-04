package com.datorium.Datorium.API.Repo;

import com.datorium.Datorium.API.DTOs.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserRepo {

    private ArrayList<User> users = new ArrayList<>();//Mocked db

    public void add(User user){
        String url = "jdbc:sqlite:my.db";
        try (Connection conn = DriverManager.getConnection(url);
             Statement statement = conn.createStatement()){
            if (conn != null) {
                String sql = "CREATE TABLE IF NOT EXISTS users (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "name TEXT NOT NULL, " +
                        "email TEXT NOT NULL)";
                statement.execute(sql);

                sql = "INSERT INTO users (name, email) VALUES ('" + user.getName() + "', '" + user.getEmail() + "')";
                statement.execute(sql);
                System.out.println("User " + user.getName() + " added to the database.");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<User> get(){
        return users;
    }

    public User update(int numberOfChristmasPresents, User updateUserDTO){
        var user = users.get(numberOfChristmasPresents);
        user.name = updateUserDTO.name;
        return user;
    }
}

//    private void insertUserIntoDB(User user) {
//        try (Connection conn = DriverManager.getConnection(DB_URL);
//             Statement statement = conn.createStatement()) {
//
//            if (conn != null) {
//                String sql = "CREATE TABLE IF NOT EXISTS users (" +
//                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                        "name TEXT NOT NULL, " +
//                        "email TEXT NOT NULL)";
//                statement.execute(sql);
//
//                sql = "INSERT INTO users (name, email) VALUES ('" + user.getName() + "', '" + user.getEmail() + "')";
//                statement.execute(sql);
//                System.out.println("User " + user.getName() + " added to the database.");
//            }
//
//        } catch (SQLException e) {
//            System.err.println("SQL error: " + e.getMessage());
//        }
//    }
