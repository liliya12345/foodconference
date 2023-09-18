package com.foodconference.foodconference.repositories;

import com.foodconference.foodconference.models.CategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryProductRepository extends JpaRepository<CategoryProduct, Long> {

    Optional<CategoryProduct> findByCategoryName(String categoryName);
}
