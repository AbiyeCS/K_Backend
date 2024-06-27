package com.example.demo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;
    private String name;
    private String email;

//    @ManyToOne
//    private Order1 order;
}
