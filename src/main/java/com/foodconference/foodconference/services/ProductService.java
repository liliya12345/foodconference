package com.foodconference.foodconference.services;

import com.foodconference.foodconference.dto.CategoryProductsDtoResponse;
import com.foodconference.foodconference.dto.ProductDtoRequest;
import com.foodconference.foodconference.dto.ProductDtoResponse;

public interface ProductService {
 ProductDtoResponse addProduct(ProductDtoRequest productDtoRequest);
}
