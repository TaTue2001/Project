package com.example.Project.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.Entity.Category;

import io.swagger.annotations.Api;

@Api(tags = "Category")
@RestController
@RequestMapping("/category")
public class CategoryController  extends BaseController<Category> {
	public CategoryController() {
		super(Category.class);
	}
}
