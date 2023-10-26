package com.example.Project.Interface.Repository;


import org.springframework.stereotype.Repository;

import com.example.Project.Entity.Employee;
@Repository
public interface IEmployeeRepository extends IBaseRepository<Employee> {
	Employee FindByEmail(String email);
}
