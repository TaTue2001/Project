package com.example.Project.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.Entity.Employee;
import com.example.Project.Interface.Repository.IEmployeeRepository;
import com.example.Project.Interface.Service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private IEmployeeRepository repo;
	@Autowired
	private IEmployeeService service;

	@GetMapping("/all")
	public List<Employee> GetAll() throws IOException {
		List<Employee> employees = repo.FindAll(Employee.class);
		return employees;
	}

	@GetMapping("/page/{page}")
	public List<Employee> GetByPage(@PathVariable int page) throws IOException {
		List<Employee> employees = repo.FindLimit(page, 10);
			return employees;
	}

	@GetMapping("/id/{Id}")
	public Employee GetById(@PathVariable String Id) throws IOException {
		Employee employee = repo.FindById(Employee.class, Id);
		if (employee != null) {
			return employee;
		}
		return null;
	}

	@GetMapping("/email/{email}")
	public Employee GetByEmail(@PathVariable String email) throws IOException {
		Employee employee = repo.FindByEmail(email);
		if (employee != null) {
			return employee;
		}
		return null;
	}
	
	@GetMapping("/name/{name}")
	public List<Employee> GetByName(@PathVariable String name) throws IOException {
		List<Employee> employees = repo.FindByName(name);
		return employees;
	}
	@GetMapping("/sort")
	public List<Employee> SortByName() throws IOException {
		List<Employee> employees = service.SortByName();
		return employees;
	}


	@GetMapping("/code/{Code}")
	public Employee GetByCode(@PathVariable String Code) throws IOException {
		Employee employee = repo.FindByCode("Employee", Code);
		if (employee != null) {
			return employee;
		}
		return null;
	}

	@PostMapping(value = "/post", produces = "application/json")
	public int Insert(@RequestBody Employee employee) throws IOException {
		int a = repo.Insert(employee);
		return a;
	}

	@PutMapping(value = "/put/{Id}", produces = "application/json")
	public int Update(@RequestBody Employee employee, @PathVariable String Id) throws IOException {
		int a = repo.Update(Employee.class, employee, Id);
		return a;
	}

	@DeleteMapping(value = "delete/{Id}")
	public int Remove(@PathVariable String Id) throws IOException {
		int a = repo.delete(Employee.class, Id);
		return a;
	}
}
