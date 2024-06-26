package com.example.demo.Controller;

import com.example.demo.Model.Customer;
import com.example.demo.Repository.CustomerRepository;
import com.example.demo.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/customer",produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> newOrder(@RequestBody Customer newCustomer) {
        Customer savedCustomer = customerRepository.save(newCustomer);
        return ResponseEntity.ok(savedCustomer);
    }

    @GetMapping("/customers")
    public List<Customer> getAllOrders() {
        return customerService.getAllCustomers();
    }
    @GetMapping("/customer/{id}")
    Customer getCustomerById(@PathVariable int id) {
        return customerService.findCustomerById(id);
    }
    @PutMapping("/customer/{id}")
    Customer updateOrder(@PathVariable int id, @RequestBody Customer newCustomer) {
        return customerService.updateCustomer(id, newCustomer);
    }
    @DeleteMapping("/customer/{id}")
    String deleteOrderById(@PathVariable int id) {
        return customerService.deleteCustomer(id);
    }

}
