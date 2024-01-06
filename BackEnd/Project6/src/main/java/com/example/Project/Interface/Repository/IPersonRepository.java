package com.example.Project.Interface.Repository;

import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository<T> {
	T getPersonByUsername(String username, String classPerson);
}
