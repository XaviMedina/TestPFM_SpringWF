package org.atsistemas.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.atsistemas.model.Customer;
import org.atsistemas.repository.CustomerRepository;
import org.atsistemas.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Resource
	private CustomerRepository customerRepository;
	
	@Transactional
	public Customer create(Customer customer) {
		Customer createdCustomer = customer;
		return customerRepository.save(createdCustomer);
	}

	@Transactional
	public Customer delete(Customer customer) {
		Customer deletedCustomer = customerRepository.findOne(customer.getId());
		
		if(deletedCustomer == null){
			try {
				throw new SQLException("Customer does not exist.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		customerRepository.delete(customer);
		
		return deletedCustomer;
	}

	@Transactional
	public List<Customer> findAll() {
		return (List<Customer>) customerRepository.findAll();
	}

	@Transactional
	public Customer update(Customer customer) {
		Customer updatedCustomer = customerRepository.findOne(customer.getId());
		
		if(updatedCustomer == null){
			try {
				throw new SQLException("Customer does not exist.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		updatedCustomer.setDNI(customer.getDNI());
		updatedCustomer.setFirstName(customer.getFirstName());
		updatedCustomer.setLastName(customer.getLastName());
		
		return updatedCustomer;
	}

	public Customer findById(long id) {
		return customerRepository.findOne(id);
	}
	
	/**
	 * Método para añadir varios registros en BD al crearse el bean.
	 */
	@PostConstruct
	public void init(){
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer("47181590B","Xavi","Medina Torregrosa"));
		customers.add(new Customer("23547231R","Silvia","Gracia Bolinches"));
		customers.add(new Customer("64456236J","Dani","Medina Torregrosa"));
		customers.add(new Customer("23434561C","Ivan","Barrio Muñoz"));
		for(Customer customer : customers){
			customerRepository.save(customer);
		}
	}

}
