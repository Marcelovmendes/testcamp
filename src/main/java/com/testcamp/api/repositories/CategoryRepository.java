package com.testcamp.api.repositories;

import com.testcamp.api.models.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryModel,Long> {
}
