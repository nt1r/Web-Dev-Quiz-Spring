package com.example.demo.util;

import com.example.demo.domain.ShopItemDomain;
import com.example.demo.entity.ShopItemEntity;

import java.util.ArrayList;
import java.util.List;

public class Convertor {
    private Convertor() {
    }

    public static ShopItemEntity convertShopItemDomain2ShopItemEntity(ShopItemDomain shopItemDomain) {
        return ShopItemEntity.builder()
                .name(shopItemDomain.getName())
                .price(shopItemDomain.getPrice())
                .unit(shopItemDomain.getUnit())
                .url(shopItemDomain.getUrl())
                .build();
    }

    public static ShopItemDomain convertShopItemEntity2ShopItemDomain(ShopItemEntity shopItemEntity) {
        return new ShopItemDomain(
                shopItemEntity.getName(),
                shopItemEntity.getPrice(),
                shopItemEntity.getUnit(),
                shopItemEntity.getUrl()
                );
    }

    public static List<ShopItemDomain> convertShopItemEntity2ShopItemDomain(List<ShopItemEntity> shopItemEntityList) {
        List<ShopItemDomain> shopItemDomainList = new ArrayList<>();
        for (ShopItemEntity shopItemEntity: shopItemEntityList) {
            shopItemDomainList.add(convertShopItemEntity2ShopItemDomain(shopItemEntity));
        }
        return shopItemDomainList;
    }
}
