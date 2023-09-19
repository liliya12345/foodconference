package com.foodconference.foodconference.services.impl;

import com.foodconference.foodconference.dto.ProductDtoRequest;
import com.foodconference.foodconference.dto.ProductDtoResponse;
import com.foodconference.foodconference.models.CategoryProduct;
import com.foodconference.foodconference.models.Distributor;
import com.foodconference.foodconference.models.Product;
import com.foodconference.foodconference.repositories.CategoryProductRepository;
import com.foodconference.foodconference.repositories.ProductRepository;
import com.foodconference.foodconference.services.ProductService;
import com.foodconference.foodconference.transformers.ProductDtoRequestToProductTransformer;
import com.foodconference.foodconference.transformers.ProductToProductDtoResponseTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductDtoRequestToProductTransformer productDtoRequestToProduct;
    private final ProductRepository productRepository;
    private final ProductToProductDtoResponseTransformer productToProductDtoResponseTransformer;
    private final CategoryProductRepository categoryProductRepository;

    @Override
    public ProductDtoResponse addProduct(ProductDtoRequest productDtoRequest, Distributor distributor) {
        Product product = productDtoRequestToProduct.transform(productDtoRequest);
        product.setDistributor(distributor);
        Product save = productRepository.save(product);
        return productToProductDtoResponseTransformer.transform(save);
    }

    @Override
    public Page<ProductDtoResponse> getAllProductsByCategory(Long categoryId, PageRequest pageRequst) {
        Optional<CategoryProduct> byId = categoryProductRepository.findById(categoryId);
        if (!byId.isPresent()) {
            return null;
        }
        Page<Product> byCategory = productRepository.findByCategory(byId.get(),pageRequst);
        Page<ProductDtoResponse> map = byCategory.map(product -> productToProductDtoResponseTransformer.transform(product));
        return map;
    }
}
