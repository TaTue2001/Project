package com.example.Project.Interface.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.Project.Entity.Employee;
@Repository
public interface IEmployeeRepository extends IBaseRepository<Employee> {
	Employee FindByEmail(String email);
	List<Employee> FindLimit(int page, int pageSize);
	List<Employee> FindByName(String name);
	List<Employee> FindByPosition(String position);
}
