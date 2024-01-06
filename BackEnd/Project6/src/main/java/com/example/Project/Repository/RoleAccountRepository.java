package com.example.Project.Repository;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import com.example.Project.Entity.Account;
import com.example.Project.Entity.Role;

@Service
public class RoleAccountRepository {
	@PersistenceContext
	private EntityManager entityManager;

	public Account getAccount(String Id) {
		try {
			UUID ID=UUID.fromString(Id);
			String queryString = "SELECT a FROM Account a WHERE a.AccountId= :value";
			TypedQuery<Account> query = (TypedQuery<Account>) entityManager.createQuery(queryString);
			query.setParameter("value", ID);
			Account result = query.getSingleResult();
			return result;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
