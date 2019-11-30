package com.anirban.domain.customer.controller;

import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.anirban.domain.customer.dto.CustomerDto;
import com.anirban.domain.customer.service.CustomerService;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;

	@GetMapping(path = "/", produces = "application/json")
	List<CustomerDto> findAllCustomers() {
		return service.findAllCustomers();
	}

	@PostMapping(path = "/", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public CustomerDto addCustomer(@RequestBody @Valid CustomerDto customerEntry) {
		return service.createCustomer(customerEntry);

	}

}
