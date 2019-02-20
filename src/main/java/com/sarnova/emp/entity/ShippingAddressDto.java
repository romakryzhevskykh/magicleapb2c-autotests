package com.sarnova.emp.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShippingAddressDto {

    private String addressId;
    private String firstName;
    private String lastName;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String country;
    private String state;
    private String postalCode;
    private String phone;
}
