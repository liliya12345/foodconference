package com.foodconference.foodconference.transformers;

import com.foodconference.foodconference.dto.CategoryProductsDtoResponse;
import com.foodconference.foodconference.models.CategoryProduct;
import org.springframework.stereotype.Component;

@Component
public class CategoryProductToCategoryProductDtoResponseTransformer extends Transformer<CategoryProductsDtoResponse, CategoryProduct> {
    @Override
    public CategoryProductsDtoResponse transform(CategoryProduct categoryProduct) {
        CategoryProductsDtoResponse categoryProductsDtoResponse = new CategoryProductsDtoResponse();
        categoryProductsDtoResponse.setId(categoryProduct.getId());
        categoryProductsDtoResponse.setCategoryName(categoryProduct.getCategoryName());
        return categoryProductsDtoResponse;
    }
}
