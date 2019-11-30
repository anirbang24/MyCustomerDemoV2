package com.anirban.domain.customer.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

import java.util.Date;

import com.anirban.domain.customer.dto.CustomerDto;
import com.anirban.domain.customer.model.Customer;
import com.anirban.domain.customer.model.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository repository;

	@Autowired
	CustomerServiceImpl(CustomerRepository repository) {
		this.repository = repository;
	}

	@Override
	public CustomerDto createCustomer(CustomerDto customerDto) {
		Customer newCust = convertToModel(customerDto);
		newCust = repository.save(newCust);
		return convertToDto(newCust);
	}

	@Override
	public CustomerDto deleteCustomer(String id) {
		Customer deleted = findCustomerById(id);
		repository.delete(deleted);
		return convertToDto(deleted);
	}

	@Override
	public List<CustomerDto> findAllCustomers() {
		List<Customer> customerEntries = repository.findAll();
		return convertToDtos(customerEntries);

	}

	@Override
	public CustomerDto getCustomerbyId(String id) {
		Customer found = findCustomerById(id);
		return convertToDto(found);

	}

	@Override
	public CustomerDto updateCustomer(CustomerDto customerDto) {
		Customer updated = findCustomerById(customerDto.getCustId());
		updated.setFirstName(customerDto.getFirstName());
		updated.setLastName(customerDto.getLastName());
		updated.setPhone(customerDto.getPhone());
		updated.setEmail(customerDto.getEmail());
		updated.setModified(new Date());
		updated = repository.save(updated);
		return convertToDto(updated);

	}

	private Customer findCustomerById(String id) {
		Optional<Customer> result = repository.findById(id);
		Customer found = result.get();
		return found;
	}

	private List<CustomerDto> convertToDtos(List<Customer> models) {
		return models.stream().map(this::convertToDto).collect(toList());
	}

	public Customer convertToModel(CustomerDto custDto) {
		Customer custModel = new Customer();
		new ObjectId();
		custModel.setId(ObjectId.get());
		custModel.setCusttId(custDto.getCustId());
		custModel.setFirstName(custDto.getFirstName());
		custModel.setLastName(custDto.getLastName());
		custModel.setPhone(custDto.getPhone());
		custModel.setEmail(custDto.getEmail());
		custModel.setCreated(new Date());
		custModel.setModified(new Date());

		return custModel;
	}

	public CustomerDto convertToDto(Customer cust) {
		CustomerDto custDto = new CustomerDto();
		custDto.setCustId(cust.getCustId());
		custDto.setFirstName(cust.getFirstName());
		custDto.setLastName(cust.getLastName());
		custDto.setPhone(cust.getPhone());
		custDto.setEmail(cust.getEmail());

		return custDto;
	}
}
