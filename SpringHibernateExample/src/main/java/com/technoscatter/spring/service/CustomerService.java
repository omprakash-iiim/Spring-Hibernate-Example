package com.technoscatter.spring.service;

import java.util.List;

import com.technoscatter.spring.model.Customer;

public interface CustomerService {

	void saveCustomer(Customer customer);

	List<Customer> findAllCustomer();

	void deleteCustomerByAccountNumber(String accountNumber);

	Customer findByAccountNumber(String accountNumber);

	void updateCustomer(Customer customer);
}
