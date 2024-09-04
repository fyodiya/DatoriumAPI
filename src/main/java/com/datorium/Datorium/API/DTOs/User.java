package com.datorium.Datorium.API.DTOs;

public class User {
    private int id;
    public String name;
    private String email;

    public User() {}

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Add method to set the name and email
    public void add(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Get methods
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Other getter and setter methods (for id, if needed)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
