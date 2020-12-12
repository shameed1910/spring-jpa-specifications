package com.example.jpa.springdatajpaspecifications.controller;

import com.example.jpa.springdatajpaspecifications.model.Employee;
import com.example.jpa.springdatajpaspecifications.repository.EmployeeRepository;
import static com.example.jpa.springdatajpaspecifications.specifications.EmployeeSpecification.*;

import com.example.jpa.springdatajpaspecifications.specifications.EmployeeSpecification;
import org.springframework.beans.factory.annotation.Autowired;


import static org.springframework.data.jpa.domain.Specification.*;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();

    }

    @GetMapping("/employees/{firstname}/{department}")
    public List<Employee> findByFirstnameAndDepartment(@PathVariable("firstname") String firstname,
                                                       @PathVariable("department") String department){


        return employeeRepository.findAll(where(hasFirstName(firstname).and(hasDepartment(department))));
    }

    @GetMapping("/employees/{lastname}")
    public List<Employee> findByFirstnameAndDepartment(@PathVariable("lastname") String lastname){


        return employeeRepository.findAll(containsLastName(lastname));
    }


}
