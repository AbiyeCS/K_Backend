package com.example.demo.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Contractor implements IPayable{

    private String name;
    private double dailyRate;
    private int daysWorked;

    @Override
    public double calcPay() {
        return daysWorked*dailyRate;
    }
}
