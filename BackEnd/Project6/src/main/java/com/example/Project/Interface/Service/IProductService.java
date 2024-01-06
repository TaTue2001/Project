package com.example.Project.Interface.Service;

import org.springframework.stereotype.Repository;

import com.example.Project.Entity.Category;
import com.example.Project.Entity.Product;

@Repository 
public interface IProductService {
	int insertProduct(Product product);
}
