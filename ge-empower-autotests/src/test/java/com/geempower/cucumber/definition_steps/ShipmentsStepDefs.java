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

}
