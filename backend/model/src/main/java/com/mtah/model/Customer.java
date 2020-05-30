package com.mtah.model;

import com.mtah.model.Order.Order;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;


@Entity
@Data
@AllArgsConstructor
public class Customer extends Person{
    /* TODO:
    *   have a favorites list of chefs
    */

    @OneToMany(mappedBy = "customer")
    private Set<Order> ordersMade;
}
