package com.revature.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.repositories.BobaRepository;
import com.revature.repositories.CustomerRepository;

@Service
public class AuthService {
	private BobaRepository br;
	private CustomerRepository cr;
	@Autowired
	public AuthService(BobaRepository br, CustomerRepository cr) {
		super();
		this.br = br;
		this.cr = cr;
	}
}
