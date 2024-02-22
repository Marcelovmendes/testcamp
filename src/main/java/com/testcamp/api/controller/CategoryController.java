package com.testcamp.api.controller;

import com.testcamp.api.dtos.CategoryDTO;
import com.testcamp.api.models.CategoryModel;
import com.testcamp.api.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService= categoryService;
    }

    public ResponseEntity<CategoryModel> createCategory(@RequestBody @Valid  CategoryDTO body){
        CategoryModel createdCategory = categoryService.createCategory(body);
        return  ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

}
