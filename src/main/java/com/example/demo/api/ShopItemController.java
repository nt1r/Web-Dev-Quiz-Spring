package com.example.demo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopItemController {
    @GetMapping("/")
    public void getMethod() {

    }
}
