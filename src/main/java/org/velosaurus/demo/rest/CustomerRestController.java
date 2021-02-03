package org.velosaurus.demo.rest;

import org.springframework.web.bind.annotation.*;
import org.velosaurus.demo.entity.Customer;
import org.velosaurus.demo.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    private final CustomerService customerService;

    // constructor injection
    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Spring REST uses Jackson in background for object-json mapping
    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return this.customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {

        Customer customer = this.customerService.getCustomer(customerId);

        if (customer == null) {
            throw new CustomerNotFoundException("Customer id not found: " + customerId);
        }

        return this.customerService.getCustomer(customerId);
    }

    // due to jackson we can access request body as pojo, no json needed
    @PostMapping("/customers")
    public Customer adCustomer(@RequestBody Customer customer) {

        // set id to 0 for "saveOrUpdate" -> on null/0 it will insert, else update
        customer.setId(0);
        customerService.saveCustomer(customer);

        return customer;
    }

    // by giving an ID, db entry will be updated
    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer) {

        customerService.saveCustomer(customer);

        return customer;
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {

        customerService.deleteCustomer(customerId);

        return String.format("Deleted customer with ID: %d", customerId);
    }

}
