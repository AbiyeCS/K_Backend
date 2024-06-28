package com.example.demo.Service;

import com.example.demo.Model.Role;
import com.example.demo.Model.User;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public User register(User user) {
        Role userRole = roleRepository.findById(2L)
                //2L ensures that the method is called with a Long value rather than an int, avoiding potential type conversion issues.
                .orElseThrow(() -> new RuntimeException("User role not found"));

        user.setRole(userRole);
        return userRepository.save(user);
    }
}
