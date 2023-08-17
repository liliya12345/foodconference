package com.foodconference.foodconference.repositories;

import com.foodconference.foodconference.models.Client;
import com.foodconference.foodconference.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
