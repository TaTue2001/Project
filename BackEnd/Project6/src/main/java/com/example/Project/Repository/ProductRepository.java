package com.example.Project.Repository;

import org.springframework.stereotype.Service;

import com.example.Project.Entity.Product;
import com.example.Project.Interface.Repository.IProductRepository;

@Service
public class ProductRepository extends BaseRepository<Product> implements IProductRepository {
}
