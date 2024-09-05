package com.foodconference.foodconference.services.impl;

import com.foodconference.foodconference.dto.CategoryProductsDtoResponse;
import com.foodconference.foodconference.models.CategoryProduct;
import com.foodconference.foodconference.repositories.CategoryProductRepository;
import com.foodconference.foodconference.services.CategoryProductService;
import com.foodconference.foodconference.transformers.CategoryProductToCategoryProductDtoResponseTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class CategoryProductServiceImpl implements CategoryProductService {
    private final CategoryProductRepository categoryProductRepository;
    private final CategoryProductToCategoryProductDtoResponseTransformer categoryProductToCategoryProductDtoResponseTransformer;

    @Override
    public List<CategoryProductsDtoResponse> getAllCategories() {
        return categoryProductRepository.findAll().stream().map(categoryProductToCategoryProductDtoResponseTransformer::transform).collect(Collectors.toList());
    }

    @Override
    public CategoryProductsDtoResponse createCategory(String categoryName) {
        CategoryProduct save = categoryProductRepository.save(new CategoryProduct(null, categoryName, null));
        return categoryProductToCategoryProductDtoResponseTransformer.transform(save);
    }

    @Override
    public Optional<CategoryProduct> getCategoryByName(String categoryName) {
     return categoryProductRepository.findByCategoryName(categoryName);
    }
}
