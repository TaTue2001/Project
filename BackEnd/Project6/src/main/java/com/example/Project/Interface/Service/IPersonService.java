package com.example.Project.Interface.Service;

import org.springframework.stereotype.Repository;

@Repository
public interface IPersonService<T> {
	T getPerson(String username, Class classPerson);
}
