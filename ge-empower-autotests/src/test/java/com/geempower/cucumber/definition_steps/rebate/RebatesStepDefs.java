package com.geempower.cucumber.definition_steps.rebate;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.cucumber.definition_steps.TestKeyword;
import com.geempower.helpers.managers.RebateManager;
import com.geempower.helpers.models.Rebate;
import com.geempower.storefront.pages.rebate.RebatesPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.*;

public class RebatesStepDefs extends AbstractStepDefs {
    @Autowired
    private RebatesPage rebatesPage;
    @Autowired
    private RebateManager rebateManager;

}
