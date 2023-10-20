package com.example.Project.Interface.Service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.Project.Entity.Employee;

@Repository
public interface IEmployeeService {
	List<Employee> SortByName();
	
}
