package com.mtah.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address extends BaseEntity{
    private String postalCode;
    private String city;
    private String province;
    private String line1;
    private String line2;
}
