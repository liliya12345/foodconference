package com.foodconference.foodconference.services;

import com.foodconference.foodconference.dto.ProductDtoRequest;
import com.foodconference.foodconference.dto.ProductDtoResponse;
import com.foodconference.foodconference.models.Distributor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface ProductService {
 ProductDtoResponse addProduct(ProductDtoRequest productDtoRequest, Distributor distributor);

 Page<ProductDtoResponse> getAllProductsByCategory(Long categoryId, PageRequest of);
}
