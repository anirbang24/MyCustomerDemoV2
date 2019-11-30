package com.anirban.domain.customer.model.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;


import com.anirban.domain.customer.model.Customer;


public interface CustomerRepository extends MongoRepository<Customer, String> {

}
