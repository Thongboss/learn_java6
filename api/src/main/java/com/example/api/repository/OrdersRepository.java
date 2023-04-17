package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long>{

}
