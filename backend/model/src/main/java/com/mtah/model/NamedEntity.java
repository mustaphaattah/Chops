package com.mtah.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class NamedEntity extends BaseEntity{

    @NotNull @NotEmpty
    private String name;
}
