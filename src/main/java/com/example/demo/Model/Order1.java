package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Order1 implements Comparable<Order1> {

    @Id
    private int orderID;
    private String orderName;
    private int customerID;
    private Date orderDate;

    @Override
    public String toString() {
        return "Order1{" +
                "orderID=" + orderID +
                ", customerID=" + customerID +
                ", orderDate=" + orderDate +
                '}';
    }

    @Override
    public int compareTo(Order1 order) {
        // Compare order dates in descending order
        return order.getOrderDate().compareTo(this.getOrderDate());
    }
}
