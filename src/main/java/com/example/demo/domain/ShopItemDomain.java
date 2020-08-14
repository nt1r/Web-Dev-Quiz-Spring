package com.example.demo.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopItemDomain {
    @NotNull
    private String name;

    @NotNull
    private Integer price;

    @NotNull
    private String unit;

    @NotNull
    private String url;
}
