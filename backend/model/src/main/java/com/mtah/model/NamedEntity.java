package com.mtah.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@MappedSuperclass
@Data
public class NamedEntity extends BaseEntity{

    @NotNull @NotEmpty
    private String username;
    @NotNull @NotEmpty
    private String profileId;
}
