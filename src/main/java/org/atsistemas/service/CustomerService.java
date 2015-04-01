package org.atsistemas.service;

import java.util.List;

import org.atsistemas.model.Customer;

public interface CustomerService {
	
	public Customer create(Customer customer);
	public Customer delete(Customer customer);
	public List<Customer> findAll();
	public Customer update(Customer customer);
	public Customer findById(long id);
	
}
