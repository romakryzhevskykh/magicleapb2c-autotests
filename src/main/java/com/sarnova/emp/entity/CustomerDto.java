package com.sarnova.emp.entity;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDto {

    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;
    private ShippingAddressDto shippingAddressDto;
    private BillingAddressDto billingAddressDto;
    private B2bUnitDto b2bUnitDto;
}
