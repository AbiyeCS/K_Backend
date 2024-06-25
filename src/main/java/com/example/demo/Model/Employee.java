package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Employee implements IPayable {

    @Id
    private int id;
    private String name;
    private int salary;

    public double calcPay(){
        return salary/12.0;
    }
}
