package com.foodconference.foodconference.repositories;

import com.foodconference.foodconference.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
