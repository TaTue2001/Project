package com.example.Project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.Entity.Delivery;
import com.example.Project.Entity.Product;
import com.example.Project.Interface.Repository.IProductRepository;
import com.example.Project.Interface.Service.IPersonService;
import com.example.Project.Interface.Service.IProductService;

import io.swagger.annotations.Api;

@Api(tags = "Product")
@RestController
@RequestMapping("/product")
public class ProductController  extends BaseController<Product> {
	@Autowired
	private IProductService iProductService;
	
	public ProductController() {
		super(Product.class);
	}
	@PostMapping("/add")
	public int saveProduct(@RequestBody Product product) {
		int a=iProductService.insertProduct(product);
		return a;
	}
}