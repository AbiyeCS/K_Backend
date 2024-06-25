package com.example.demo.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryEmployee extends Employee {
    private int salary;

    public double calcPay(String role){
        if(role.equals("Software Engineer")){
            return salary/12.0 + 1000;
        }
        return salary/12.0;
    }
}
