package com.mtah.model;

import com.mtah.model.Menu.Menu;
import com.mtah.model.Order.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Chef extends Person {

    @OneToOne
    private Menu menu;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "chef", cascade = CascadeType.ALL)
    private List<Order> orders;
}
