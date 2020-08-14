package com.example.demo.repository;

import com.example.demo.entity.ShopItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopItemRepository extends CrudRepository<ShopItemEntity, Integer> {
    List<ShopItemEntity> findAll();
}
