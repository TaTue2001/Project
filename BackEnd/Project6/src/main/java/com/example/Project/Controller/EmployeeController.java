package com.example.Project.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.Entity.Employee;

import io.swagger.annotations.Api;

@Api(tags = "Employee")
@RestController
@RequestMapping("/employee")
public class EmployeeController extends BaseController<Employee> {

	public EmployeeController() {
		super(Employee.class);
	}

}
