package com.foodconference.foodconference.repositories;

import com.foodconference.foodconference.models.Client;
import com.foodconference.foodconference.models.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourierRepository extends JpaRepository<Courier, Long> {
}
