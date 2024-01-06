package com.example.Project.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.Entity.Address;

import io.swagger.annotations.Api;

@Api(tags = "Address")
@RestController
@RequestMapping("/address")
public class AddressController extends BaseController<Address> {
	public AddressController() {
		super(Address.class);
	}
}