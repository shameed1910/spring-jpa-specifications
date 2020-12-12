package com.example.jpa.springdatajpaspecifications.specifications;

import com.example.jpa.springdatajpaspecifications.model.Employee;
import com.example.jpa.springdatajpaspecifications.model.Employee_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class EmployeeSpecification {

    public static Specification<Employee> hasFirstName(String firstname){
        return ((root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get(Employee_.FIRSTNAME),firstname);
        });
    }
    public static Specification<Employee> containsLastName(String lastname){
        return ((root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get(Employee_.LASTNAME),"%"+ lastname + "%");
        });
    }

    public static Specification<Employee> hasDepartment(String department){
        return ((root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get(Employee_.DEPARTMENT),department);
        });
    }
}
