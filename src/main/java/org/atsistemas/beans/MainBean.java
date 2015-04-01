package org.atsistemas.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.atsistemas.model.Customer;
import org.atsistemas.service.CustomerService;
import org.primefaces.event.SelectEvent;
import org.primefaces.mobile.event.SwipeEvent;
import org.springframework.beans.factory.annotation.Autowired;


@ManagedBean
@SessionScoped
public class MainBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	List<Customer> fetchedCustomers;
	
	Customer selectedCustomer = new Customer();
	
	@Autowired
	private CustomerService customerService;

	public List<Customer> getFetchedCustomers() {
		if(fetchedCustomers == null){
			fetchedCustomers = customerService.findAll();
		}
		return fetchedCustomers;
	}

	public void setFetchedCustomers(List<Customer> fetchedCustomers) {
		this.fetchedCustomers = fetchedCustomers;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	public Customer getSelectedCustomer() {
		return selectedCustomer;
	}

	public void setSelectedCustomer(Customer selectedCustomer) {
		this.selectedCustomer = selectedCustomer;
	}

	public void swipeCustomer(SwipeEvent event) {
		selectedCustomer = null;
		selectedCustomer = (Customer) event.getData();
    }
     
    public void tapCustomer(SelectEvent event) {
    	selectedCustomer = null;
    	selectedCustomer = (Customer) event.getObject();
    }
    
    public void delete(){
    	customerService.delete(selectedCustomer);
    	fetchedCustomers = null;
    	selectedCustomer = new Customer();
    }
    
    public String creationForm(){
    	selectedCustomer = new Customer();
    	return "pm:customerForm?transition=slidedown";
    }
    
    public String backToMain(){
    	return "pm:main?transition=slideup";
    }
    
    public String save(){
    	if(selectedCustomer.getId() != 0){
    		customerService.update(selectedCustomer);
    	}
    	else{
    		customerService.create(selectedCustomer);
    	}
    	fetchedCustomers = null;
    	selectedCustomer = new Customer();
    	return "pm:main?transition=slideup";
    }
    
    public String navigateToUpdate(){
    	return "pm:customerForm?transition=slidedown";
    }

}
