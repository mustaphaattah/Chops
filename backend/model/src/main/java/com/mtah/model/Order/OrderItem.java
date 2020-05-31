package com.mtah.model.Order;


import lombok.AllArgsConstructor;
import com.mtah.model.Item;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem extends Item {

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    private int quantity;
    private String specialInstructions;
}
