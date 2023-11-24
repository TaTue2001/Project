package com.example.Project.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.Entity.Department;

import io.swagger.annotations.Api;

@Api(tags = "Department")
@RestController
@RequestMapping("/department")
public class DepartmentController extends BaseController<Department>{

	public DepartmentController() {
		super(Department.class);
	}
	
}
