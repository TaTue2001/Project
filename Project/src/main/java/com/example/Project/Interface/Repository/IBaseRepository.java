package com.example.Project.Interface.Repository;

import java.util.List;

public interface IBaseRepository <T> {
	List <T> FindAll(Class entityClass);
	T GetById(Class entityClass, String Id);
	T FindById(Class entityClass,String Id);
	T FindByCode(String entityClass,String Code);
	int delete(Class entityClass,String Id);
	int Insert(T model);
	int Update (Class entityClass, T model, String Id);
}