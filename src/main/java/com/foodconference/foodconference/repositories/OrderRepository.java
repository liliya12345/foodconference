package com.foodconference.foodconference.repositories;

import com.foodconference.foodconference.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
