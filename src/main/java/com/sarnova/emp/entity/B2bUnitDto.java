package com.sarnova.emp.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class B2bUnitDto {

    private String id;
    private String name;
    private ShippingAddressDto shippingAddressDto;
    private BillingAddressDto billingAddressDto;
    private CustomerDto customerDto;
}
