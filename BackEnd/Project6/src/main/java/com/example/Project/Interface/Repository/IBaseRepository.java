package com.example.Project.Interface.Repository;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;



@Repository
public interface IBaseRepository<T> {
//	List <T> FindAll(Class entityClass);
//	T GetById(Class entityClass, String Id);
//	List<T> SortByField(Class entityClass, String field,int page, int pageSize);
	T FindById(Class entityClass, String Id);

	int Delete(Class entityClass, String Id);

	int Insert(T model);

	int Update(Class entityClass, T model, String Id);

	List<T> Active(Class entityClass, String field, String value, int page, int pageSize);
}