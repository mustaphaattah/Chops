package com.mtah.model.Order;

import com.mtah.model.BaseEntity;
import com.mtah.model.Chef;
import com.mtah.model.Customer;
import com.mtah.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class Order extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Chef chef;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    private String dateCreated;
    private String dateCompleted;
    private Long total;
    private String specialInstructions;
    private Status status;

}
