package com.example.Project.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.Entity.Customer;
import com.example.Project.Entity.Department;

@RestController
@RequestMapping("/customer")
public class CustomerController extends BaseController<Customer> {
	
//	protected CustomerController() {
//		super(Customer.class);	
//	}
	
	public CustomerController() {
		super(Customer.class);
	}

	@GetMapping("/details")
	public Customer getDetails(@RequestParam String username) {
		Customer c=null;
		return c;
	}
}
