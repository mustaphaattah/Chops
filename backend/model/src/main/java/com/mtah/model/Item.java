package com.mtah.model;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public class Item extends NamedEntity {

    @NotNull
    @NotEmpty
    private double price;
}
