package com.geempower.hybris.backoffice.models;

import com.geempower.hybris.Cockpit;
import com.geempower.hybris.backoffice.pages.BackofficeLoginPage;
import org.springframework.beans.factory.annotation.Autowired;

public class TemplateBackoffice extends Cockpit {

    public TemplateBackoffice(String baseUrl) {
        this.baseUrl = baseUrl;
    }
    @Autowired
    private BackofficeLoginPage backofficeLoginPage;

    @Override
    public String getLoginUrl() {
        return backofficeLoginPage.getPageUrl();
    }
}
