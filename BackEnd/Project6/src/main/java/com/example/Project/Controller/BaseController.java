package com.example.Project.Controller;


import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.example.Project.Interface.Repository.IBaseRepository;
import com.example.Project.Interface.Service.IBaseService;
import com.example.Project.Response.MyDataObject;
import com.example.Project.Response.ResponseAPI;
import com.example.Project.Response.StatusResponse;

@RestController
public abstract class BaseController<T> {
	@Autowired
	private IBaseRepository<T> repo;
	@Autowired
	private IBaseService<T> service;
	private final Class<T> entityType;
 
    protected BaseController(Class<T> clazz) {
        this.entityType = clazz;
    }
	
	@GetMapping("/all")
	public ResponseEntity<ResponseAPI> getAll( @RequestParam int pageSize, @RequestParam int page)  {
		List<T>  entitys= service.GetAll(entityType, page, pageSize);
		ResponseAPI response =null;
		try {
			MyDataObject<T> data=new MyDataObject<T>(entitys);
			response = new ResponseAPI<T>(StatusResponse.SUCCESS, data, null);
		} catch (Exception ex) {
			response = new ResponseAPI<T>(StatusResponse.CANCEL_DATA_NOT_EXIST, null, null);
		}
		return ResponseEntity.ok(response);
	}

	@GetMapping("/search")
	public ResponseEntity<ResponseAPI> SearchByField( @RequestParam String field, @RequestParam String value,@ RequestParam int pageSize, @RequestParam int page) throws ClassNotFoundException {
		List<T> entitys = service.Search(entityType, field, value, pageSize, page);
		ResponseAPI response =null;
		try {
			MyDataObject<T> data=new MyDataObject<T>(entitys);
			response = new ResponseAPI(StatusResponse.SUCCESS, data, null);
		} catch (Exception ex) {
			response = new ResponseAPI(StatusResponse.CANCEL_DATA_NOT_EXIST, null, null);
		}
		return ResponseEntity.ok(response);
	}

	@GetMapping("/sort")
	public ResponseEntity<ResponseAPI> SortByField( @RequestParam String field, @RequestParam int page, @RequestParam int pageSize)throws ClassNotFoundException {
		List<T> entitys = service.Sort(entityType, field, page, pageSize);
		ResponseAPI response =null;
		try {
			MyDataObject<T> data=new MyDataObject<T>(entitys);
			response = new ResponseAPI(StatusResponse.SUCCESS, data, null);
		} catch (Exception ex) {
			response = new ResponseAPI(StatusResponse.CANCEL_DATA_NOT_EXIST, null, null);
		}
		return ResponseEntity.ok(response);
	}

	@PostMapping(value = "/add", produces = "application/json")
	public int Insert( @RequestBody Map<String, Object> requestBody)throws ClassNotFoundException {
		ObjectMapper mapper = new ObjectMapper();
		T t = mapper.convertValue(requestBody, entityType);
		int a = repo.Insert(t);
		return a;
	}

//	@PutMapping(value = "/put/{Id}")
//	public int Update(@PathVariable String Id, @RequestBody Map<String, Object> requestBody) throws ClassNotFoundException {
//		ObjectMapper mapper = new ObjectMapper();
//		T t = mapper.convertValue(requestBody, entityType);
//		int a = repo.Update(entityType, t, Id);
//		return a;
//	}

	@DeleteMapping("/delete/{Id}")
	public int Delete( @PathVariable String Id) throws ClassNotFoundException {
		int a = repo.Delete(entityType, Id);
		return a;
	}
	
	@PatchMapping("/patch/{Id}")
	public T pacthE( @PathVariable String Id, @RequestBody Map<String, Object> requestBody)throws ClassNotFoundException {
		T a = repo.patchEntity(entityType,Id ,requestBody);
		return a;
	}

}
