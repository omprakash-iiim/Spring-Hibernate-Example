package com.technoscatter.spring;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.technoscatter.spring.configuration.AppConfig;
import com.technoscatter.spring.model.Customer;
import com.technoscatter.spring.service.CustomerService;

public class AppMain {

	public static void main(String args[]) {
		
		//used for java based configuration
		//AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//used for xml based configuration
		ApplicationContext context =new ClassPathXmlApplicationContext("spring-context.xml");

		CustomerService service = (CustomerService) context.getBean("customerService");

		/*
		 * Create Customer1
		 */
		Customer customer1 = new Customer();
		customer1.setName("Rahul");
		customer1.setDateOfBirth(new LocalDate(2010, 10, 10));
		customer1.setAccountNumber("A-101");

		/*
		 * Create Customer2
		 */
		Customer customer2 = new Customer();
		customer2.setName("Rohit");
		customer2.setDateOfBirth(new LocalDate(2012, 11, 11));
		customer2.setAccountNumber("A-102");

		/*
		 * Persist both Customerss
		 */
		service.saveCustomer(customer1);
		service.saveCustomer(customer2);

		/*
		 * Get all customer list from database
		 */
		List<Customer> customerList = service.findAllCustomer();
		for (Customer cust : customerList) {
			System.out.println(cust);
		}

		/*
		 * delete an customer
		 */
		service.deleteCustomerByAccountNumber("A-102");

		/*
		 * update an customer
		 */

		Customer customer = service.findByAccountNumber("A-101");
		customer.setName("Rohan");
		service.updateCustomer(customer);

		/*
		 * Get all customers list from database
		 */
		List<Customer> customers = service.findAllCustomer();
		for (Customer cust : customers) {
			System.out.println(cust);
		}

		//context.close();
	}
}
