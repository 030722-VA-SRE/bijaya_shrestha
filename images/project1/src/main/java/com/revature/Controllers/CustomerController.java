package com.revature.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Services.AuthService;
import com.revature.Services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	private CustomerService cs;
	private AuthService as;

	@Autowired
	public CustomerController ( CustomerService cs, AuthService as) {
	super();
	this.cs = cs;
	this.as = as;
	}
}
