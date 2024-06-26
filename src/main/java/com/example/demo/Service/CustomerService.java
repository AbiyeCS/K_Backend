package com.example.demo.Service;

import com.example.demo.Exception.FailedToGetProductsException;
import com.example.demo.Exception.ProductDoesNotExistException;
import com.example.demo.Model.Customer;
import com.example.demo.Repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    public String deleteCustomer(Integer id) {
        if(!customerRepository.existsById(id)) {
            throw new ProductDoesNotExistException("Customer with id " + id + " does not exist");
        }
        customerRepository.deleteById(id);

        return "Customer with id: " + id + " deleted";
    }

    public Customer updateCustomer(Integer id, Customer newCustomer) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setName(newCustomer.getName());
                    customer.setEmail(newCustomer.getEmail());
                    customer.setId(newCustomer.getId());
                    return customerRepository.save(customer);
                }).orElseThrow(() -> new ProductDoesNotExistException("Customer with id " + id + " does not exist"));
    }

    public Customer findCustomerById(Integer id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElseThrow(() -> new ProductDoesNotExistException("This customer does not exist"));
    }

    public List<Customer> getAllCustomers(){
        List<Customer> customers = customerRepository.findAll();

        try{
            List<Customer> customers1 = customerRepository.findAll();
            System.out.println(customers1);
        }catch (Exception e){
            throw new FailedToGetProductsException();
        }


        return customers;
    }
}
