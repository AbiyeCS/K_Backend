package com.example.demo.Service;
import com.example.demo.Exception.FailedToGenerateTokenException;
import com.example.demo.Exception.FailedToLoginException;
import com.example.demo.Model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Repository.TokenRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenRepository tokenRepository;

    public boolean validLogin(String username, String password) {
        System.err.println("validLogin called with username: " + username);
        User user = userRepository.findByUsername(username);
        if (user == null) {
            System.err.println("User not found: " + username);
            return false;
        }
        boolean matches = password.equals(user.getPassword()); // Compare plaintext passwords
        if (!matches) {
            System.err.println("Password does not match for user: " + username);
        }
        return matches;
    }

    public String generateToken(User user) throws FailedToGenerateTokenException {
        try {
            String tokenString = UUID.randomUUID().toString();
            Date expiryDate = new Date(System.currentTimeMillis() + 8 * 60 * 60 * 1000); // 8 hours

            Token token = new Token();
            token.setToken(tokenString);
            token.setExpiry(expiryDate);
            token.setUser(user);

            tokenRepository.save(token);

            System.out.println("Token generated for user: " + user.getUsername());
            return tokenString;
        } catch (Exception e) {
            throw new FailedToGenerateTokenException("Failed to generate token");
        }
    }

    public String login(String username, String password) throws FailedToLoginException, FailedToGenerateTokenException {
        if (validLogin(username, password)) {
            User user = userRepository.findByUsername(username);
            return generateToken(user);
        } else {
            throw new FailedToLoginException("Invalid username or password");
        }
    }
}
