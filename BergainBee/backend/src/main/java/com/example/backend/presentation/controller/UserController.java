package com.example.backend.presentation.controller;


import com.example.backend.business.domain.model.BaseProduct;
import com.example.backend.business.domain.model.User;
import com.example.backend.business.service.UserService;
import com.example.backend.data.database.AuthenticationService;
import com.example.backend.data.database.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private final UserService userService;
    @Autowired
    private final AuthenticationService authenticationService;

    public UserController(UserService userService, AuthenticationService authenticationService) {
        this.userService = userService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@RequestBody User user) {
        authenticationService.register(user.getUsername(), user.getPassword(), user.getEmail());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Session> loginUser(@RequestBody User user) {
        User authenticatedUser = authenticationService.login(user.getUsername(), user.getPassword());
        if (authenticatedUser != null) {
            Session session = Session.startSession(authenticatedUser);
            return ResponseEntity.ok(session);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/{userId}/favorites")
    public ResponseEntity<List<BaseProduct>> getFavoriteProducts(@PathVariable int userId) {
        List<BaseProduct> favorites = userService.getFavoriteProducts(userId);
        return ResponseEntity.ok(favorites);
    }
    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
