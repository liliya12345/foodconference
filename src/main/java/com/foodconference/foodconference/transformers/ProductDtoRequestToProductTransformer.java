package com.foodconference.foodconference.transformers;

import com.foodconference.foodconference.dto.ProductDtoRequest;
import com.foodconference.foodconference.models.Price;
import com.foodconference.foodconference.models.Product;
import com.foodconference.foodconference.repositories.CategoryProductRepository;
import com.foodconference.foodconference.repositories.DistributorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductDtoRequestToProductTransformer extends Transformer<Product, ProductDtoRequest> {
    private final CategoryProductRepository categoryProductRepository;
    private final DistributorRepository distributorRepository;

    @Override
    public Product transform(ProductDtoRequest productDtoRequest) {
        Product product = new Product();
        product.setId(productDtoRequest.getId());
        product.setName(productDtoRequest.getName());
        product.setCategory(categoryProductRepository.findById(productDtoRequest.getCategoryId()).orElse(null));
        product.setDescription(productDtoRequest.getDescription());
        Price price = new Price();
        price.setActive(true);
        price.setPrice(productDtoRequest.getPrice());
        price.setStartTime(LocalDateTime.now());
        price.setProduct(product);
        List<Price> priceList = product.getPriceList();
        priceList.add(price);
        product.setPriceList(priceList);
        product.setUnitMeasure(productDtoRequest.getUnitMeasure());
        return product;


    }
}
