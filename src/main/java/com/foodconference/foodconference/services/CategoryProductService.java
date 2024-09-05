package com.foodconference.foodconference.services;

import com.foodconference.foodconference.dto.CategoryProductsDtoResponse;
import com.foodconference.foodconference.models.CategoryProduct;

import java.util.List;
import java.util.Optional;

public interface CategoryProductService {
    List<CategoryProductsDtoResponse> getAllCategories();

    CategoryProductsDtoResponse createCategory(String categoryName);

    Optional<CategoryProduct> getCategoryByName(String categoryName);
}
