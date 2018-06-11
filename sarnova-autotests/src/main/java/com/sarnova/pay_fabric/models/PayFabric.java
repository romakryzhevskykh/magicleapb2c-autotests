package com.sarnova.pay_fabric.models;

import com.sarnova.hybris.Cockpit;
import com.sarnova.pay_fabric.pages.PayFabricLoginPage;
import org.springframework.beans.factory.annotation.Autowired;

public class PayFabric extends Cockpit {

    @Autowired PayFabricLoginPage payFabricLoginPage;

    public PayFabric(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String getLoginUrl() {
        return payFabricLoginPage.getPageUrl();
    }
}
