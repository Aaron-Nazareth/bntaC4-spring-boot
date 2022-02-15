package com.aaronnazareth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController // Add @RestController to expose your methods as REST services to clients
public class SpringBootApplicationCounter { // All your code should be inside this one class
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationCounter.class, args);
    }

    // Outside of main, create a variable static int count = 0;
    static int count = 0;   // Number of CL trophies Arsenal have won

    // All methods should have a @GetMapping
    @GetMapping(path = "current-count") // Create a method to get current count. i.e localhost:8080/current-count
    int currentCount() {
        return count;
    }

    @GetMapping(path = "increment-count")   // Create method to increment the count. i.e localhost:8080/increment-count
    int incrementCount() {
        return ++count;
    }

    @GetMapping(path = "decrement-count")   // Create method to decrement the count. i.e localhost:8080/decrement-count
    int decrementCount() {
        return --count;
    }
}
// Test your api with chrome