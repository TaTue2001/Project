package com.example.Project.Service;

//import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Project.Entity.Employee;
import com.example.Project.Interface.Repository.IEmployeeRepository;
import com.example.Project.Interface.Service.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	private IEmployeeRepository repo;
	
	@Override
	public List<Employee> SortByName() {
        List<Employee> employeesO=repo.FindAll(Employee.class);
        Comparator<Employee> nameComparator= Comparator.comparing(Employee::getFullName);
        Collections.sort(employeesO,nameComparator);
		return employeesO;
	}

}
