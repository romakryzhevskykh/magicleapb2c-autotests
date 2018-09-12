package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.managers.OrderManager;
import com.geempower.helpers.models.Order;
import com.geempower.helpers.models.Product;
import com.geempower.storefront.pages.MyCartPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Random;

import static com.geempower.cucumber.definition_steps.TestKeyword.GE_ORDER_NO;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MyCartStepDefs extends AbstractStepDefs {
    @Autowired
    private MyCartPage myCartPage;
    @Autowired
    private OrderManager orderManager;

    private final double delta = 0.00001;

}