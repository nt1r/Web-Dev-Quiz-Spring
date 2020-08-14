package com.example.demo.util;

import com.example.demo.domain.ShopItemDomain;
import com.example.demo.entity.ShopItemEntity;

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
}
