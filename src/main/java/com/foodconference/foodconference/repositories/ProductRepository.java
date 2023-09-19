package com.foodconference.foodconference.repositories;

import com.foodconference.foodconference.models.CategoryProduct;
import com.foodconference.foodconference.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByCategory (CategoryProduct category,Pageable pageable);
}
