package com.datorium.Datorium.API.Controllers;

import com.datorium.Datorium.API.DTOs.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

public class DatoriumAPIController {


    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name); // "Hello " + name;
    }

    @GetMapping("/sum")
    public int sum(@RequestParam(value = "number1") int number1, @RequestParam(value = "number2") int number2) {
        return number1 + number2;
    }

    @GetMapping("/multiply")
    public int multiply(@RequestParam(value = "number1") int number1, @RequestParam(value = "number2") int number2) {
        return number1 * number2;
    }

    //Create an array in the endpoint, fill the array with data and access it from the URL
    @GetMapping("/cats")
    public String[] cats(@RequestParam(value = "cat1") String cat1, @RequestParam(value = "cat2") String cat2) {
        String[] cats = {cat1, cat2};
        return cats;
    }

    @GetMapping("/getNamesOfElinasCats")
    public List<String> getNamesOfElinasCats() {
        return Arrays.asList("Lesya", "Shprotik");
    }

    //Create an object (new class, cheese or wine or whatever) in the endpoint,
    // fill the object, access it from the URL

    /*
    two-dimensional array
     */
    @GetMapping("/draw")
    public int[][] draw() {
        return new int[][]{
                new int[]{1, 0, 1, 0, 1},
                new int[]{0, 1, 0, 1, 0},
                new int[]{1, 0, 1, 0, 1},
                new int[]{0, 1, 0, 1, 0},
                new int[]{1, 0, 1, 0, 1}
        };
    }

    @GetMapping("/getBook")
    public Book book(@RequestParam(value = "title") String title,
                     @RequestParam(value = "author") String author) {
        var book = new Book();
        book.title = title;
        book.author = author;

        return book;
    }


    @PostMapping("/postexample")
    public Book addBook(@RequestBody Book book) {
        book.title = book.title.toUpperCase();
        return book;

    }

    //user authorisation
    @PostMapping("/authorize")
    public User authorize(@RequestBody Credentials credentials) {
        // username + password
        if (credentials.username.equals("fyodiya")  && credentials.password.equals("123")){
            var user = new User();
            user.name = "Elina";
            return user;
        }
        return new User();
    }

    @PostMapping("/growPlant")
    public Plant growPlant(@RequestBody Seed seed) {

        if (seed.type.equals("rose") && seed.environment.equals("sunny")) {
            var plant = new Plant();
            plant.name = "garden rose";
            plant.type = "flower";
            return plant;
        }
        var defaultPlant = new Plant();
        defaultPlant.name = "unknown plant";
        defaultPlant.type = "unknown";
        return defaultPlant;
    }

}
