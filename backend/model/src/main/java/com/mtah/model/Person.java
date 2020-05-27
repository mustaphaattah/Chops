package com.mtah.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@MappedSuperclass
@Data
public class Person extends NamedEntity{

    private String dateCreated;
    private String lastUpdate;
    @NotNull @NotEmpty
    private String username;
    @NotNull @NotEmpty
    private String email;
    @NotNull @NotEmpty
    private String password;
    @NotNull @NotEmpty
    private String profileId;

}
