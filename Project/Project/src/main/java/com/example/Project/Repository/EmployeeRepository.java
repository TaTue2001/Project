package com.example.Project.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Primary;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.stereotype.Service;

import com.example.Project.Entity.Employee;
import com.example.Project.Interface.Repository.IEmployeeRepository;

@Service
@Primary
public class EmployeeRepository extends BaseRepository<Employee> implements IEmployeeRepository{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Employee FindByEmail(String email) {
		try {
			String queryString="SELECT e  FROM Employee e WHERE e. Email = :email";
			TypedQuery<Employee> query = (TypedQuery<Employee>) entityManager.createQuery(queryString);
	        query.setParameter("email",email);
	        List<Employee> result = query.getResultList();
	        if(result.size() > 0){
	            return result.get(0);
	        }
	        return null;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
