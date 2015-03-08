package com.technoscatter.spring.dao;

import java.util.List;

import com.technoscatter.spring.model.Customer;

public interface CustomerDao {

	void saveCustomer(Customer customer);
	
	List<Customer> findAllCustomers();
	
	void deleteCustomerByAccountNumber(String accountNumber);
	
	Customer findByAccountNumber(String accountNumber);
	
	void updateCustomer(Customer customer);
}
