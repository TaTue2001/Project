//package com.example.Project.Controller;
//
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.Project.Entity.Category;
//import com.example.Project.Entity.Product;
//import com.example.Project.Interface.Repository.IBaseRepository;
//import com.example.Project.Interface.Service.IProductService;
//import com.example.Project.Repository.BaseRepository;
//import com.example.Project.Response.MyDataObject;
//import com.example.Project.Response.ResponseAPI;
//import com.example.Project.Response.StatusResponse;
//import com.example.Project.Service.FirebaseService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@RestController
//@RequestMapping("/demo")
//public class CartController {
//	@Autowired
//	private BaseRepository<Category> repo;
//	@Autowired
//	private IProductService service;
//	@Autowired
//	private FirebaseService firebaseService;
////	@GetMapping("/all")
////	public Category getDepartment( @RequestParam String field , @RequestParam String value)  {
////		Category a=repo.FindByField(Category.class, field, value);
////		return a;
////	}
////	@GetMapping("/all")
////	public Category getDepartment(@RequestBody Product product)  {
////		Category a=service.insertProduct(product);
//////		String a=product.getCategoryName();
////		return a;
////	}
////	@PostMapping(value = "/signup", produces = "application/json")
////	public int Insert( @RequestBody Map<String, Object> requestBody)throws ClassNotFoundException {
////		ObjectMapper mapper = new ObjectMapper();
////		T t = mapper.convertValue(requestBody, entityType);
////		int a = repo.Insert(t);
////		return a;
////	}
////    @PostMapping("/email")
////    public String sendVerificationEmail(@RequestParam String email) {
////        firebaseService.sendEmailVerification(email);
////        return "Verification email sent to " + email;
////    }
//}
