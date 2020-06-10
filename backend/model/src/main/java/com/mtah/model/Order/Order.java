package com.mtah.model.Order;

import com.mtah.model.BaseEntity;
import com.mtah.model.Chef;
import com.mtah.model.Customer;
import com.mtah.model.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
@Builder
public class Order extends BaseEntity {

    @ManyToOne
    @JoinColumn(nullable = false)
    private Chef chef;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    private LocalDate dateCreated;
    private LocalDate dateCompleted;

    private double total;
    private String specialInstructions;
    private Status status;

}
