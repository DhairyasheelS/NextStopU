package org.example.controller;

import jakarta.validation.Valid;
import org.example.Service.UserSignUp;
import org.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class UserSignupController
{
    @Autowired
    private UserSignUp userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@Valid @RequestBody User user) {
        try {
            if(userService.emailExists(user.getEmail())) {
                return ResponseEntity.badRequest().body("Email is Already in use");
            }
            userService.registerUser(user);
            return ResponseEntity.ok("User Register Successfully!!");
        } catch (Exception e) {
            e.printStackTrace();  // Print stack trace to console
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }

}
