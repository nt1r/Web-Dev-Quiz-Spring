package com.example.demo.service;

import com.example.demo.domain.ShopItemDomain;
import com.example.demo.entity.ShopItemEntity;
import com.example.demo.repository.ShopItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.util.Convertor.convertShopItemDomain2ShopItemEntity;
import static com.example.demo.util.Convertor.convertShopItemEntity2ShopItemDomain;

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

    public List<ShopItemDomain> getItemList() {
        List<ShopItemEntity> shopItemEntityList = shopItemRepository.findAll();
        return convertShopItemEntity2ShopItemDomain(shopItemEntityList);
    }
}
