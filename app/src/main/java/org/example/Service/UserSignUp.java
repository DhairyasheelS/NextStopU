package org.example.Service;

import org.example.Repository.UserRepo;
import org.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserSignUp
{
    private final UserRepo userRepository;
    private final PasswordEncoder passwordEncoder;

    // Constructor-based Dependency Injection
    @Autowired
    public UserSignUp(UserRepo userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(User user) {
        // Check if email already exists
        if (emailExists(user.getEmail())) {
            throw new IllegalArgumentException("Email already in use.");
        }

        // Encrypt user password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save and return the registered user
        return userRepository.save(user);
    }

    public boolean emailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
