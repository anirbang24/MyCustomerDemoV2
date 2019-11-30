package com.anirban.domain.customer.service;

import java.util.List;
import com.anirban.domain.customer.dto.CustomerDto;

public interface CustomerService {

	CustomerDto createCustomer(CustomerDto customer);

	CustomerDto deleteCustomer(String id);

	List<CustomerDto> findAllCustomers();

	CustomerDto getCustomerbyId(String id);

	CustomerDto updateCustomer(CustomerDto customer);
}
