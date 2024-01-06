package com.example.Project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Project.Entity.Category;
import com.example.Project.Entity.Product;
import com.example.Project.Interface.Repository.ICategoryRepository;
import com.example.Project.Interface.Repository.IProductRepository;
import com.example.Project.Interface.Service.IProductService;

@Service
public class ProductService implements IProductService {
	@Autowired
	private IProductRepository productRepository;
	
	@Autowired
	private ICategoryRepository categoryRepository;

	@Override
	public int insertProduct(Product product) {
		Category category= categoryRepository.FindByField(Category.class,"CategoryName",product.getCategoryName());
		if(category!=null) {
			product.setCategory(category);
		}else {
			product.setCategory(null);
		}
		int rs=productRepository.Insert(product);
		return rs;
	}
}
