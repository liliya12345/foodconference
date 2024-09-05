package com.foodconference.foodconference.repositories;

import com.foodconference.foodconference.models.CategoryProduct;
import com.foodconference.foodconference.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByCategory (CategoryProduct category,Pageable pageable);
}
