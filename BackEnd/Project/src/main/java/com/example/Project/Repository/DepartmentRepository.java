package com.example.Project.Repository;

import org.springframework.stereotype.Service;

import com.example.Project.Entity.Department;
import com.example.Project.Interface.Repository.IDepartmentRepository;

@Service
//@Component("department")
public class DepartmentRepository extends BaseRepository<Department> implements IDepartmentRepository {

}
