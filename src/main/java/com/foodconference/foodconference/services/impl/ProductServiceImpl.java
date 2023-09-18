package com.foodconference.foodconference.services.impl;

import com.foodconference.foodconference.dto.ProductDtoRequest;
import com.foodconference.foodconference.dto.ProductDtoResponse;
import com.foodconference.foodconference.models.Product;
import com.foodconference.foodconference.repositories.ProductRepository;
import com.foodconference.foodconference.services.ProductService;
import com.foodconference.foodconference.transformers.ProductDtoRequestToProductTransformer;
import com.foodconference.foodconference.transformers.ProductToProductDtoResponseTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductDtoRequestToProductTransformer productDtoRequestToProduct;
    private final ProductRepository productRepository;
    private final ProductToProductDtoResponseTransformer productToProductDtoResponseTransformer;

    @Override
    public ProductDtoResponse addProduct(ProductDtoRequest productDtoRequest) {
        Product product = productDtoRequestToProduct.transform(productDtoRequest);
        Product save = productRepository.save(product);
        return productToProductDtoResponseTransformer.transform(save);
    }
}
