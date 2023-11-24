package com.example.Project.Interface.Repository;

public interface IPersonRepository<T> {
	T getPersonByUsername(String username, String classPerson);
}
