package com.mtah.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public class Person extends NamedEntity{


}
