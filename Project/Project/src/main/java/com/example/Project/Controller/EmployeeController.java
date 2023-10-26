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

	@GetMapping("/all/{page}")
	public List<Employee> GetAll(@PathVariable int page) throws IOException {
		List<Employee> employees = service.GetAll(Employee.class, page);
		return employees;
	}

//	@GetMapping("/id/{Id}")
//	public List<Employee> GetById(@PathVariable String Id) throws IOException {
//		List<Employee> employee = repo.FindByField(Employee.class, "EmployeeId	",Id,1,10);
//		if (employee != null) {
//			return employee;
//		}
//		return null;
//	}
//
//	@GetMapping("/email/{Email}")
//	public List <Employee> GetByEmail(@PathVariable String Email) throws IOException {
//		List <Employee> employee = repo.FindByField(Employee.class, "Email", Email, 1, 10);
//		if (employee != null) {
//			return employee;
//		}
//		return null;
//	}
//	
//
//	@GetMapping("/sort")
//	public List<Employee> SortByName() throws IOException {
//		List<Employee> employees = repo.SortByField(Employee.class,"JoinDate", 1, 10);
//		return employees;
//	}
//
//	@GetMapping("/code/{Code}")
//	public List<Employee> GetByCode(@PathVariable String Code) throws IOException {
//		List<Employee> employees = repo.FindByField(Employee.class, "EmployeeCode", Code, 1, 10);
//		if (employees != null) {
//			return employees;
//		}
//		return null;
//	}
//	@GetMapping("/name/{Name}")
//	public List<Employee> GetByName2(@PathVariable String Name) throws IOException {
//		List<Employee> employees = repo.FindByField(Employee.class, "FullName", Name, 1,10);
//		if (employees != null) {
//			return employees;
//		}
//		return null;
//	}
//	@PostMapping(value = "/post", produces = "application/json")
//	public int Insert(@RequestBody Employee employee) throws IOException {
//		int a = repo.Insert(employee);
//		return a;
//	}
//
//	@PutMapping(value = "/put/{Id}", produces = "application/json")
//	public int Update(@RequestBody Employee employee, @PathVariable String Id) throws IOException {
//		int a = repo.Update(Employee.class, employee, Id);
//		return a;
//	}
//
//	@DeleteMapping(value = "delete/{Id}")
//	public int Remove(@PathVariable String Id) throws IOException {
//		int a = repo.Delete(Employee.class, Id);
//		return a;
//	}
}
