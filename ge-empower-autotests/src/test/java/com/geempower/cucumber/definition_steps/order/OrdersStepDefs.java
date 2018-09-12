package com.geempower.cucumber.definition_steps.order;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.helpers.Utils;
import com.geempower.helpers.managers.OrderManager;
import com.geempower.storefront.pages.order.OrdersPage;

import org.springframework.beans.factory.annotation.Autowired;


public class OrdersStepDefs extends AbstractStepDefs {
    @Autowired
    private OrdersPage ordersPage;
    @Autowired
    private Utils utils;

    @Autowired
    private OrderManager orderManager;

}