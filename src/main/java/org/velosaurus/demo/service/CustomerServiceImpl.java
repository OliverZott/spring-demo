package org.velosaurus.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.velosaurus.demo.dao.CustomerDAO;
import org.velosaurus.demo.entity.Customer;

import javax.transaction.Transactional;
import java.util.List;

// To detect beans automatically,  Spring uses classpath scanning annotations
// @Service, @Repository, ...
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDAO customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDao = customerDAO;
    }

    // delegates calls to CustomerDao
    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return this.customerDao.getCustomers();
    }

    @Override
    @Transactional
    public Customer getCustomer(int id) {
        return this.customerDao.getCustomer(id);
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        this.customerDao.saveCustomer(customer);
    }

    @Override
    @Transactional
    public void deleteCustomer(int id) {
        this.customerDao.deleteCustomer(id);
    }

}
