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

import com.example.Project.Entity.Department;
import com.example.Project.Interface.Repository.IDepartmentRepository;


@RestController
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private IDepartmentRepository repo;
	
	@GetMapping("/all")
	public List<Department> GetAll()throws IOException{
		List<Department> departments=repo.FindAll(Department.class);
		return departments;
	}
	@GetMapping("/id/{Id}")
	public Department GetById(@PathVariable String Id)throws IOException{
		Department department=repo.FindById(Department.class, Id);
		if(department!=null) {
			return department;
		}
		return null;
	}
	@GetMapping("/code/{Code}")
	public Department GetByCode(@PathVariable String Code )throws IOException{
		Department department=repo.FindByCode("Department", Code);
		if(department!=null) {
			return department;
		}
		return null;
	}
	@PostMapping(value ="/post", produces="application/json")
	public int Insert(@RequestBody Department department)throws IOException {
		int a=repo.Insert(department);
		return a;
	}
	@PutMapping(value ="/put/{Id}", produces="application/json")
	public int Update(@RequestBody Department department,@PathVariable String Id)throws IOException {
		int a=repo.Update(Department.class, department, Id);
		return a;
	}
	@DeleteMapping(value ="delete/{Id}")
	public int Remove(@PathVariable String Id) throws IOException{
		int a=repo.delete(Department.class,  Id);
		return a;
	}
}
