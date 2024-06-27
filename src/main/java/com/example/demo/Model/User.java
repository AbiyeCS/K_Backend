package com.example.demo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {

    @Id
    @NotNull
    private String username;

    @NotNull
    private String password;

//    @NotNull
//    private Long roleid;

    @ManyToOne
    private Role role;
}
