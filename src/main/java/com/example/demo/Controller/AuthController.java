package com.example.demo.Controller;

import com.example.demo.Exception.FailedToLoginException;
import com.example.demo.Exception.FailedToGenerateTokenException;
import com.example.demo.Model.Login;
import com.example.demo.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login loginRequest) {
        System.err.println("login endpoint hit with username: " + loginRequest.getUsername());
        try {
            String token = authService.login(loginRequest.getUsername(), loginRequest.getPassword());
            return ResponseEntity.ok(token);
        } catch (FailedToLoginException e) {
            System.err.println("FailedToLoginException: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (FailedToGenerateTokenException e) {
            System.err.println("FailedToGenerateTokenException: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
