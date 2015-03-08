package com.technoscatter.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.technoscatter.spring.model.Customer;

@Repository("customerDao")
public class CustomerDaoImpl extends AbstractDao implements CustomerDao{

	public void saveCustomer(Customer customer) {
		persist(customer);
	}

	@SuppressWarnings("unchecked")
	public List<Customer> findAllCustomers() {
		Criteria criteria = getSession().createCriteria(Customer.class);
		return (List<Customer>) criteria.list();
	}

	public void deleteCustomerByAccountNumber(String accountNumber) {
		Query query = getSession().createSQLQuery("delete from Customer where account_number = :accountNumber");
		query.setString("accountNumber", accountNumber);
		query.executeUpdate();
	}

	
	public Customer findByAccountNumber(String accountNumber){
		Criteria criteria = getSession().createCriteria(Customer.class);
		criteria.add(Restrictions.eq("accountNumber",accountNumber));
		return (Customer) criteria.uniqueResult();
	}
	
	public void updateCustomer(Customer customer){
		getSession().update(customer);
	}
	
}
