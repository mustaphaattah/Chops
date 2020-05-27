package com.mtah.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order extends BaseEntity{

    private Chef chef;
    private Customer customer;
    private String dateCreated;
    private String dateCompleted;
    /* TODO:
        Add orderItems field once class is created
     */
    private Long total;
    private String specialInstructions;

}
