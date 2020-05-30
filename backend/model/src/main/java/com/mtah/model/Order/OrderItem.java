package com.mtah.model.Order;

import com.mtah.model.Menu.MenuItem;
import com.mtah.model.NamedEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.jar.Attributes;

@Entity
@Data
@AllArgsConstructor
public class OrderItem extends NamedEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    private int quantity;
    private String specialInstructions;
}
