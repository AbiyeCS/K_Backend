package com.example.demo.Controller;

import com.example.demo.Model.Order1;
import com.example.demo.Repository.OrderRepository;
import com.example.demo.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderService orderService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/order")
    public ResponseEntity<?> newOrder(@RequestBody Order1 newOrder, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            // Log validation errors
//            bindingResult.getAllErrors().forEach(error -> {
//                System.out.println(error.getDefaultMessage());
//            });
//
//            // You might want to return a ResponseEntity with a meaningful response or throw an exception
//            return ResponseEntity.badRequest().body("Validation error");
//        }

        Order1 savedOrder = orderRepository.save(newOrder);
        return ResponseEntity.ok(savedOrder);
    }

    @GetMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order1> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/order/{id}")
    Order1 getOrderById(@PathVariable int id) {
        return orderService.findOrderById(id);
    }

    @PutMapping("/order/{id}")
    Order1 updateOrder(@PathVariable int id, @RequestBody Order1 newOrder) {
        return orderService.updateOrder(id, newOrder);
    }
    @DeleteMapping("/order/{id}")
    String deleteOrderById(@PathVariable int id) {
        return orderService.deleteOrder(id);
    }
}
