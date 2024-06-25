package com.example.demo.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalesEmployee extends Employee {
    private double monthlySales;
    private double commissionRate;

    public double calcPay(){
        return monthlySales * commissionRate;
    }
}
