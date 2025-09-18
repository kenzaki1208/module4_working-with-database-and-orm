package org.example.week2working_with_database_and_orm.working_with_database_and_orm.practice.p1.service;

import org.example.week2working_with_database_and_orm.working_with_database_and_orm.practice.p1.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void save(Customer customer);
    Customer findById(int id);
    void remove(int id);
}
