package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order")
@Builder
public class OrderEntity {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer amount;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "order")
    private List<ShopItemEntity> shopItems;
}
