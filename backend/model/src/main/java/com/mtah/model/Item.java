package com.mtah.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@MappedSuperclass
public class Item extends NamedEntity {

    @NotNull
    @NotEmpty
    private double price;
}
