package org.velosaurus.demo.service;

import org.velosaurus.demo.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    Customer getCustomer(int id);

    void saveCustomer(Customer customer);

    void deleteCustomer(int id);

}
