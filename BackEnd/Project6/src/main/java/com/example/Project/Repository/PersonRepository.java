package com.example.Project.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import com.example.Project.Entity.Customer;
import com.example.Project.Interface.Repository.IPersonRepository;

@Service
public class PersonRepository<T> implements IPersonRepository<T>{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public T getPersonByUsername(String username, String classPerson) {
		String queryString = "SELECT c FROM "+ classPerson +" c JOIN c.account a WHERE a.UserName = :username";
	    try {
	        TypedQuery<T> query = (TypedQuery<T>) entityManager.createQuery(queryString);
	        query.setParameter("username", username);
	        return query.getSingleResult();
	    } catch (NoResultException e) {
	        return null;
	    }
	}

}
