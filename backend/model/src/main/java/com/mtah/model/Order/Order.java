package com.mtah.model.Order;

import com.mtah.model.BaseEntity;
import com.mtah.model.Chef;
import com.mtah.model.Customer;
import com.mtah.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order extends BaseEntity {

    private Chef chef;
    private Customer customer;
    private String dateCreated;
    private String dateCompleted;
    /* TODO:
        Add orderItems field once class is created
     */
    private Long total;
    private String specialInstructions;
    private Status status;

}
