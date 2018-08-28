package com.sarnova.cucumber.definition_steps;

import com.sarnova.pay_fabric.page_blocks.PayFabricLeftBarBlock;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class PayFabricGeneralStepDefs extends AbstractStepDefs {
    @Autowired PayFabricLeftBarBlock payFabricLeftBarBlock;

    @When("^Open Customer Wallets page in Pay Fabric.$")
    public void openCustomerWallets() {
        payFabricLeftBarBlock.clickOnCustomerWalletsItem();
    }

    @When("^Open Daily Activity page in Pay Fabric.$")
    public void openDailyActivity() {
        payFabricLeftBarBlock.clickOnDailyActivityItem();
    }
}
