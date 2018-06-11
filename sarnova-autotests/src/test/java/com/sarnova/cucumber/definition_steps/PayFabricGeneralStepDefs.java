package com.sarnova.cucumber.definition_steps;

import com.sarnova.pay_fabric.page_blocks.LeftBarBlock;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class PayFabricGeneralStepDefs extends AbstractStepDefs {
    @Autowired LeftBarBlock leftBarBlock;

    @When("^Open Customer Wallets page in Pay Fabric.$")
    public void openCustomerWallets() {
        leftBarBlock.clickOnCustomerWalletsItem();
    }
}
