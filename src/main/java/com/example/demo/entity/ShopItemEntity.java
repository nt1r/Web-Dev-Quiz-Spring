package com.example.demo.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item")
@Builder
public class ShopItemEntity {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Integer price;

    private String unit;

    private String url;

    @ManyToOne
    private OrderEntity order;
}
