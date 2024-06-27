package com.example.demo.Repository;

import com.example.demo.Model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, String> {
    Token findByToken(String token);
}
