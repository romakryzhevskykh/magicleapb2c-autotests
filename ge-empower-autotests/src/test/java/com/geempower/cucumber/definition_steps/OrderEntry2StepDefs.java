package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.OrderEntry2Page;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;

public class OrderEntry2StepDefs extends AbstractStepDefs{
    @Autowired
    private OrderEntry2Page orderEntry2Page;

    @When("^User fills PO no.$")
    public void userFillsPONo() {
        threadVarsHashMap.put(TestKeyword.PO_NO, orderEntry2Page.fillUniquePoNo());
    }

    @And("^Select Shipment Address.$")
    public void selectShipmentAddress() {
        threadVarsHashMap.put(TestKeyword.SHIPPING_ADDRESS, orderEntry2Page.chooseAppropriateAddressFromTheShippingAddressList());
    }

    @Then("^Selected Shipment address is equal to Ship to field value.$")
    public void selectedShipmentAddressIsEqualToShipToFieldValue() {
        assertEquals(threadVarsHashMap.get(TestKeyword.SHIPPING_ADDRESS), orderEntry2Page.getShipToValue());
    }

    @When("^User clicks on the Bottom Next button.$")
    public void userClicksOnTheBottomNextButton(){
        orderEntry2Page.clickOnTheNextBottomButton();
    }
}
