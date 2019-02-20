package com.sarnova.emp.stepdef.hac;

import com.sarnova.emp.service.fixture.ImpexFixtureService;
import com.sarnova.emp.service.hac.AuthorizationService;
import com.sarnova.emp.dataprovider.DataProvider;
import com.sarnova.emp.entity.B2bUnitDto;
import com.sarnova.emp.entity.BillingAddressDto;
import com.sarnova.emp.entity.ShippingAddressDto;
import com.sarnova.emp.entity.CustomerDto;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Random;

public class HacStepdefs {

    @Autowired
    private ImpexFixtureService impexFixtureService;
    @Autowired
    private AuthorizationService authorizationService;
    @Autowired
    private DataProvider<CustomerDto> customerDataProvider;

    @Given("^Login to hac site with user (.*) and password (.*)$")
    public void loginToHacSiteWithUserAndPassword(String user, String password) {
        authorizationService.login(user, password);
    }

    @Given("^Customer registers via impex$")
    public void customerRegistersViaImpex() {
        CustomerDto createdCustomer = impexFixtureService.registerCustomer(getDefaultCustomerDto());
        customerDataProvider.setItem(createdCustomer);
    }

    private String generateUserName() {
        return "automationuser" + randomNumber() + (new Date()).getTime();
    }

    private int randomNumber() {
        return new Random().nextInt(10000);
    }

    private CustomerDto getDefaultCustomerDto() {
        B2bUnitDto b2bUnitDto = B2bUnitDto.builder()
                .id("AU" + randomNumber())
                .build();
        ShippingAddressDto shippingAddress = ShippingAddressDto.builder()
                .addressId("Shipping" + randomNumber())
                .build();
        BillingAddressDto billingAddress = BillingAddressDto.builder()
                .addressId("Billing" + randomNumber())
                .build();

        CustomerDto customerToBeCreated = CustomerDto.builder()
                .userName(generateUserName())
                .b2bUnitDto(b2bUnitDto)
                .shippingAddressDto(shippingAddress)
                .billingAddressDto(billingAddress)
                .build();
        return customerToBeCreated;
    }

}
