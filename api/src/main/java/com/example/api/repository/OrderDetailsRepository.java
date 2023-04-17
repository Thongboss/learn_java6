package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.entity.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long>{

}
