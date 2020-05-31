package com.mtah.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@MappedSuperclass
public class Person extends BaseEntity {

    private String firstName;
    private String lastName;
    private LocalDate dateCreated;
    private LocalDate lastUpdate;

    @NotNull @NotEmpty
    private String username;

    @NotNull @NotEmpty
    private String email;

    @NotNull @NotEmpty
    private String password;

    @Embedded
    private Address address;

}
