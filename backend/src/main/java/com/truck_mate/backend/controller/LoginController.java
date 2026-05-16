package com.truck_mate.backend.controller;

import com.truck_mate.backend.DTO.CreateUserRequest;
import com.truck_mate.backend.Model.User;
import com.truck_mate.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:5173")
public class LoginController {
private final UserService service;

public LoginController(UserService ser){
    this.service=ser;
}
    @GetMapping("/hello")
    public String hello() {
        return "Hello from Truck Mate!";
    }
    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody CreateUserRequest req) {
        User usr = service.createUser(req.fname, req.lname, req.email, req.pd);

        return ResponseEntity.ok(usr);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> showAll() {
        return ResponseEntity.ok(service.showAll());
    }
    @GetMapping("/users/{email}")
    public ResponseEntity<User> showUser(@PathVariable String email) {
        return ResponseEntity.ok(service.showUser(email));
    }
}