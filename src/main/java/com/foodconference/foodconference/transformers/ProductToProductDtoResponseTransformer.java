package com.foodconference.foodconference.transformers;

import com.foodconference.foodconference.dto.ProductDtoResponse;
import com.foodconference.foodconference.models.Price;
import com.foodconference.foodconference.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductToProductDtoResponseTransformer extends Transformer<ProductDtoResponse, Product> {
    private final CategoryProductToCategoryProductDtoResponseTransformer categoryProductToCategoryProductDtoResponseTransformer;

    @Override
    public ProductDtoResponse transform(Product product) {
        ProductDtoResponse productDtoResponse = new ProductDtoResponse();
        productDtoResponse.setId(product.getId());
        productDtoResponse.setDescription(product.getDescription());
        productDtoResponse.setName(product.getName());
        Price price1 = product.getPriceList().stream().filter(price -> price.getActive()).findFirst().orElse(null);
        productDtoResponse.setPrice(price1.getPrice());
        productDtoResponse.setCategoryProductsDtoResponse(categoryProductToCategoryProductDtoResponseTransformer.transform(product.getCategory()));
        productDtoResponse.setUnitMeasure(product.getUnitMeasure());
        return productDtoResponse;
    }
}
