package com.example.Project.Repository;

import org.springframework.stereotype.Service;

import com.example.Project.Entity.Category;
import com.example.Project.Interface.Repository.ICategoryRepository;

@Service
public class CategoryRepository extends BaseRepository<Category> implements ICategoryRepository {
}
