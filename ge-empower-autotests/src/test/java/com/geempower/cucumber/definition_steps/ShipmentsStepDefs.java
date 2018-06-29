package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.ShipmentsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ShipmentsStepDefs extends AbstractStepDefs {
    @Autowired
    private ShipmentsPage shipmentsPage;

    @When("^(.*) title is displayed on Shipments page.$")
    public void checkShipmentsTitle(String shipmentTitle) {
        assertEquals(shipmentsPage.getShipmentsTitle(), shipmentTitle);
    }

    @And("^Color boxes are displayed on Shipments page.$")
    public void colorBoxesIsDisplayed() {
        assertTrue(shipmentsPage.colorBoxesIsDisplayed());
    }

    @And("^Shipment table header is displayed on Shipments page.$")
    public void shipmentsTableHeaderIsDisplayed() {
        assertTrue(shipmentsPage.shipmentsTableHeaderIsDisplayed());
    }

    @When("^Click on Download button on Shipments page.$")
    public void clickOnDownloadButtonOnShipmentsPage() {
        shipmentsPage.clickOnDownloadButton();
    }
}
