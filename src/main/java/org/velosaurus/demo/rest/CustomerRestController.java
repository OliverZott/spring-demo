package org.velosaurus.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
        return this.customerService.getCustomer(customerId);
    }

}
