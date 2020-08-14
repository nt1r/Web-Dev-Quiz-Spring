package com.example.demo.repository;

import com.example.demo.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {
    List<OrderEntity> findAll();
}
