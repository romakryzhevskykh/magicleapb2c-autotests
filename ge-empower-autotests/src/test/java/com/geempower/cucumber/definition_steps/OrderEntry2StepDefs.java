package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.OrderEntry2Page;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderEntry2StepDefs extends AbstractStepDefs{
    @Autowired
    private OrderEntry2Page orderEntry2Page;

    @When("^User fills PO no.$")
    public void userFillsPONo() {
        threadVarsHashMap.put(TestKeyword.PO_NO, orderEntry2Page.fillUniquePoNo());
    }

    @And("^Select Shipment Address.$")
    public void selectShipmentAddress() {
        orderEntry2Page.chooseAppropriateAddressFromTheShippingAddressList();
    }
}
