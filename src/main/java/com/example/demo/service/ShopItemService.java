package com.example.demo.service;

import com.example.demo.domain.ShopItemDomain;
import com.example.demo.entity.ShopItemEntity;
import com.example.demo.repository.ShopItemRepository;
import org.springframework.stereotype.Service;

import static com.example.demo.util.Convertor.convertShopItemDomain2ShopItemEntity;

@Service
public class ShopItemService {

    private final ShopItemRepository shopItemRepository;

    public ShopItemService(ShopItemRepository shopItemRepository) {
        this.shopItemRepository = shopItemRepository;
    }

    public void addOneItem(ShopItemDomain shopItemDomain) {
        ShopItemEntity shopItemEntity = convertShopItemDomain2ShopItemEntity(shopItemDomain);
        shopItemRepository.save(shopItemEntity);
    }
}
