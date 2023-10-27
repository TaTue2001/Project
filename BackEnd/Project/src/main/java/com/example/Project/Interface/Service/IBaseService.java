package com.example.Project.Interface.Service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface IBaseService<T> {
	List<T> Sort(Class entityClass,String field, int page);
	List<T> Search(Class entityClass, String field , String value, int page);
	List<T> GetAll(Class entityClass, int page);
}
