package com.mtah.model.Order;


import com.mtah.model.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem extends Item {

    @ManyToOne
    @JoinColumn(nullable=false)
    private Order order;

    private int quantity;
    private String specialInstructions;
}
