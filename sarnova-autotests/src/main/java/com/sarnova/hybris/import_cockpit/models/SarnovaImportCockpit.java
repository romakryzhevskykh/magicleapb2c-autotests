package com.sarnova.hybris.import_cockpit.models;

import com.sarnova.hybris.Cockpit;
import com.sarnova.hybris.import_cockpit.pages.LoginPage;
import org.springframework.beans.factory.annotation.Autowired;

public class SarnovaImportCockpit extends Cockpit {

    @Autowired LoginPage loginPage;

    public SarnovaImportCockpit(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String getLoginUrl() {
        return loginPage.getPageUrl();
    }
}
