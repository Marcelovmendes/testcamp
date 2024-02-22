package com.testcamp.api.services;

import com.testcamp.api.dtos.CategoryDTO;
import com.testcamp.api.models.CategoryModel;
import com.testcamp.api.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    public CategoryModel createCategory(CategoryDTO dto){
        CategoryModel category = new CategoryModel(dto);
        return categoryRepository.save(category);
    }
}
