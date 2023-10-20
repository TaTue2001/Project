package com.example.Project.Controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.Interface.Repository.IBaseRepository;
import com.example.Project.Interface.Service.IBaseService;

@RestController
@RequestMapping()
public class BaseController<T> {
	
//		private IBaseRepository repo;
//		private IBaseService service;
//			
//	    @GetMapping("/all")
//	    public ArrayList<T> getAll(){
//	    	ArrayList<T> entitys=new ArrayList<>();
//	    	return entitys;
//	    }
//	    @GetMapping("/id/{Id}")
//	    public T getById(String Id) {
//	    	return null;
//	    }
//		@PostMapping(value ="/{entity}/post", produces="application/json")
//		public int Insert(@RequestBody T t) {
//			int a=repo.Insert(t);
//			return a;
//		}
//		@PutMapping(value ="/{entity}/put/{Id}")
//		public int Update(@RequestBody T t,@PathVariable String Id) {
//			int a=repo.Update(t,Id);
//			return a;
//		}
//		@DeleteMapping("/{entity}/delete/{Id}")
//		public int Delete(@PathVariable String Id) {
//			int a=repo.Delete(Id);
//			return a;
//		}
//	
}
