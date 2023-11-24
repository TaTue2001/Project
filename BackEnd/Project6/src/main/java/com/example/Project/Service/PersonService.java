package com.example.Project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.Project.Interface.Repository.IPersonRepository;
import com.example.Project.Interface.Service.IPersonService;

@Primary
@Service
public class PersonService<T> implements IPersonService<T>{
	@Autowired
	private IPersonRepository<T> iPersonRepository;

	@Override
	public T getPerson(String username, Class classPerson) {
		T t=iPersonRepository.getPersonByUsername(username, classPerson.getName());
		return t;
	}

}
