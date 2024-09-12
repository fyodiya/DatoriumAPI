package com.datorium.Datorium.API.Repo;

import com.datorium.Datorium.API.DTOs.User;

import java.sql.*;
import java.util.ArrayList;

public class UserRepo {

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
                String query = "SELECT id, name, email FROM users";
                ResultSet result = statement.executeQuery(query);

                while (result.next()) {
                    var user = new User();
                    user.setId(result.getInt("id"));
                    user.setName(result.getString("name"));
                    user.setEmail(result.getString("email"));
                    resultList.add(user);
                }
            }
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        }

        return resultList;
    }

    public User update(User user) {
        String url = "jdbc:sqlite:my.db";
        try (Connection conn = DriverManager.getConnection(url);
             Statement statement = conn.createStatement()) {
            if (conn != null) {
                String sql = "UPDATE users SET name = '" + user.getName() + "', email = '" + user.getEmail() + "' WHERE id = " + user.getId();
                statement.executeUpdate(sql);
                System.out.println("User with ID " + user.getId() + " was updated.");
            }
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        }

        return user;
    }

    public void delete(int id) {
        String url = "jdbc:sqlite:my.db";
        try (Connection conn = DriverManager.getConnection(url);
             Statement statement = conn.createStatement()) {
            if (conn != null) {
                String sql = "DELETE FROM users WHERE id = " + id;
                int rowsAffected = statement.executeUpdate(sql);
                if (rowsAffected > 0) {
                    System.out.println("User with ID " + id + " was deleted.");
                } else {
                    System.out.println("No user found with ID " + id);
                }
            }
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        }
    }
}