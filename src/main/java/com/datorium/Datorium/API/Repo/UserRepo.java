package com.datorium.Datorium.API.Repo;

import com.datorium.Datorium.API.DTOs.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class UserRepo {

    private ArrayList<User> users = new ArrayList<>();//Mocked db

    public void add(User user) {
        String url = "jdbc:sqlite:my.db";
        try (Connection conn = DriverManager.getConnection(url);
             Statement statement = conn.createStatement()) {
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
            System.err.println("SQL error: " + e.getMessage());
        }
    }

    public ArrayList<User> get() {
        String url = "jdbc:sqlite:my.db";
        ArrayList<User> resultList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url);
             Statement statement = conn.createStatement()) {

            if (conn != null) {
                String query = "SELECT name FROM users";
                var result = statement.executeQuery(query);

                while (result.next()) {
                    var user = new User();
                    user.setName(result.getString("name"));
                    resultList.add(user);
                }
            }
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        }

        return resultList;
    }

    public User update(int userIndex, User updateUserDTO) {
        String url = "jdbc:sqlite:my.db";
        try (Connection conn = DriverManager.getConnection(url);
             Statement statement = conn.createStatement()) {

            if (conn != null) {
                String sql = "UPDATE users SET name = '" + updateUserDTO.getName() + "', email = '" + updateUserDTO.getEmail() + "' WHERE id = " + userIndex;
                statement.executeUpdate(sql);
                System.out.println("User with ID " + userIndex + " updated in the database.");

                sql = "SELECT id, name, email FROM users WHERE id = " + userIndex;
                ResultSet result = statement.executeQuery(sql);
                if (result.next()) {
                    User updatedUser = new User();
                    updatedUser.setId(result.getInt("id"));
                    updatedUser.setName(result.getString("name"));
                    updatedUser.setEmail(result.getString("email"));
                    return updatedUser;
                }
            }
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        }
        return null;
    }
}