package com.mtah.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@MappedSuperclass
@Data
public class Person extends NamedEntity{

    private String firstName;
    private String lastName;
    private String dateCreated;
    private String lastUpdate;
    @NotNull @NotEmpty
    private String email;
    @NotNull @NotEmpty
    private String password;

}
