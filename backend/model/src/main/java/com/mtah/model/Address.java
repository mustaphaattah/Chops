package com.mtah.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address extends BaseEntity{

    @NotEmpty(message = "Postal Code is required")
    @Pattern(regexp = "^[A-Z][0-9][A-Z] [0-9][A-Z][0-9]$", message = "Postal Code must match format: A1A 1A1")
    private String postalCode;

    @NotEmpty(message = "City is required")
    private String city;

    @NotEmpty(message = "Province is required")
    private String province;

    @NotEmpty(message = "Address is required")
    private String line1;
    private String line2;

}
