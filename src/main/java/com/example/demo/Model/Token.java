package com.example.demo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Token {
    @Id
    @NotNull
    private String token;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date expiry;

    @ManyToOne
    private User user;
}
