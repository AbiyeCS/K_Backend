package com.example.demo.Service;

import com.example.demo.Model.Employee;
import com.example.demo.Repository.EmployeeRepository;

import java.util.List;

public class EmployeeService {
    EmployeeRepository employeeRepository;

    public List<Employee> findAll() {

        Employee employee = new Employee();
        return employeeRepository.findAll();
    }
}
