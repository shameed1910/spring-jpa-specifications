package com.example.jpa.springdatajpaspecifications.repository;

import com.example.jpa.springdatajpaspecifications.model.Employee;
import com.example.jpa.springdatajpaspecifications.model.Employee_;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class EmployeeCustomRepositoryImpl implements EmployeeCustomRepository {

    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Employee> findByFirstNameAndDepartment(String firstname, String department) {

        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
        CriteriaQuery cq=cb.createQuery(Employee.class);

        Root<Employee> employee=cq.from(Employee.class);

        Predicate firstNamePredicate=cb.equal(employee.get(Employee_.FIRSTNAME),firstname);
        Predicate departmentPredicate=cb.equal(employee.get(Employee_.DEPARTMENT),department);

        cq.where(firstNamePredicate,departmentPredicate);

        TypedQuery<Employee> query=entityManager.createQuery(cq);

        return query.getResultList();
    }
}
