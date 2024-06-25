package com.example.demo.Repository;

import com.example.demo.Model.Order1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order1, Integer> {

}
