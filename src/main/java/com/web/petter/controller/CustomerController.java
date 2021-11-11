package com.web.petter.controller;


import com.web.petter.model.Customer;
import com.web.petter.service.api.CustomerServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceAPI customerServiceAPI;

    @PostMapping("/add")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        Customer customer1 = customerServiceAPI.save(customer);
        return new ResponseEntity<Customer>(customer1, HttpStatus.CREATED);

    }

    @GetMapping("/find/all")
    public List<Customer> readCustomers(){
        return customerServiceAPI.getAll();
    }

    @GetMapping("/find/{id}")
    public Customer readCustomer(@PathVariable int id){
        return customerServiceAPI.get(id);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable int id){
        Customer customer = customerServiceAPI.get(id);
        if (customer != null){
            customerServiceAPI.delete(id);
        }else{
            return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }



}
