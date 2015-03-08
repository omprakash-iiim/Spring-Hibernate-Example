package com.technoscatter.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.technoscatter.spring.dao.CustomerDao;
import com.technoscatter.spring.model.Customer;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao dao;
	
	public void saveCustomer(Customer customer) {
		dao.saveCustomer(customer);
	}

	public List<Customer> findAllCustomer() {
		return dao.findAllCustomers();
	}

	public void deleteCustomerByAccountNumber(String accountNumber) {
		dao.deleteCustomerByAccountNumber(accountNumber);
	}

	public Customer findByAccountNumber(String accountNumber) {
		return dao.findByAccountNumber(accountNumber);
	}

	public void updateCustomer(Customer customer){
		dao.updateCustomer(customer);
	}
}
