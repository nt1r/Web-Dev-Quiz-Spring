package com.example.demo.api;

import com.example.demo.domain.ShopItemDomain;
import com.example.demo.service.ShopItemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ShopItemController {
    private final ShopItemService shopItemService;

    private final ObjectMapper objectMapper;

    public ShopItemController(ShopItemService shopItemService) {
        this.objectMapper = new ObjectMapper();
        this.shopItemService = shopItemService;
    }

    @PostMapping("/item")
    public void postOneItem(@RequestBody @Valid ShopItemDomain shopItem) {
        shopItemService.addOneItem(shopItem);
    }

    @GetMapping("/item/list")
    public void getItemList() {

    }
}
