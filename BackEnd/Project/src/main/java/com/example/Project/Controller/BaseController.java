package com.example.Project.Controller;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.example.Project.Interface.Repository.IBaseRepository;
import com.example.Project.Interface.Service.IBaseService;

@RestController
@RequestMapping("/{entityClass}")
public class BaseController<T> {
	@Autowired
	private IBaseRepository<T> repo;
	@Autowired
	private IBaseService<T> service;


	@GetMapping("/all/{page}")
	public List<T> getAll(@PathVariable String entityClass, @PathVariable int page) throws ClassNotFoundException {
		Class<?> entityClazz = Class.forName("com.example.Project.Entity." + entityClass);
		List<T> entitys = service.GetAll(entityClazz, page);
		return entitys;
	}

//	@GetMapping("/id/{Id}")
//	public T getById(@PathVariable String entityClass,@PathVariable String Id) throws ClassNotFoundException {
//		Class<?> entityClazz = Class.forName("com.example.Project.Entity." + entityClass);
//		T entity = repo.FindById(entityClazz, Id);
//		return entity;
//	}

	@GetMapping("/{field}/{value}/{page}")
	public List<T> SearchByField(@PathVariable String entityClass,@PathVariable String field,@PathVariable String value, @PathVariable int page) throws ClassNotFoundException {
		Class<?> entityClazz = Class.forName("com.example.Project.Entity." + entityClass);
		List<T> entitys = service.Search(entityClazz, field, value, page);
		return entitys;
	}
	
	@GetMapping("/sort/{field}/{page}")
	public List<T> SortByField(@PathVariable String entityClass,@PathVariable String field, @PathVariable int page) throws ClassNotFoundException {
		Class<?> entityClazz = Class.forName("com.example.Project.Entity." + entityClass);
		List<T> entitys = service.Sort(entityClazz, field, page);
		return entitys;
	}

	@PostMapping(value = "/add", produces = "application/json")
	public int Insert(@PathVariable String entityClass,@RequestBody Map<String, Object> requestBody) throws ClassNotFoundException {
		Class<T> entityClazz = resolveEntityClass(entityClass);
	    ObjectMapper mapper = new ObjectMapper();
	    T t = mapper.convertValue(requestBody, entityClazz);
		int a = repo.Insert(t);
		return a;
	}

	@PutMapping(value = "/put/{Id}")
	public int Update(@PathVariable String entityClass, @PathVariable String Id,@RequestBody Map<String, Object> requestBody) throws ClassNotFoundException {
		Class<T> entityClazz = resolveEntityClass(entityClass);
	    ObjectMapper mapper = new ObjectMapper();
	    T t = mapper.convertValue(requestBody, entityClazz);
		int a = repo.Update(entityClazz,t, Id);
		return a;
	}

	@DeleteMapping("/delete/{Id}")
	public int Delete(@PathVariable String entityClass,@PathVariable String Id) throws ClassNotFoundException {
		Class<?> entityClazz = Class.forName("com.example.Project.Entity." + entityClass);
		int a = repo.Delete(entityClazz,Id);
		return a;
	}
    private Class<T> resolveEntityClass(String entityClassName) throws ClassNotFoundException {
        String fullClassName = "com.example.Project.Entity." + entityClassName;
        return (Class<T>) Class.forName(fullClassName);
    }

}
