package com.mtah.model;

import com.mtah.model.Menu.Menu;
import com.mtah.model.Order.Order;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
public class Chef extends Person {

    @OneToOne
    private Menu menu;

    @OneToMany(mappedBy = "chef")
    private Set<Order> ordersReceived;
}
