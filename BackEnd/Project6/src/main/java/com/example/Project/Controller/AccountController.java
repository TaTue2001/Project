package com.example.Project.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.Entity.Account;

import io.swagger.annotations.Api;

@Api(tags = "Account")
@RestController
@RequestMapping("/account")
public class AccountController extends BaseController<Account> {
	public AccountController() {
		super(Account.class);
	}
	
}
