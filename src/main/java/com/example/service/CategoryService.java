package com.example.service;

import java.util.List;

import com.example.entity.Category;

public interface CategoryService {
	Category createCategory(Category category);
	List<Category> getAllCategories();
}
