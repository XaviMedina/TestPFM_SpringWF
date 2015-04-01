package org.atsistemas.repository;

import org.atsistemas.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

public interface CustomerRepository extends CrudRepository<Customer,Long>{

}
