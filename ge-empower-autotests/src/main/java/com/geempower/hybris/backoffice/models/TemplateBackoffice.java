package com.geempower.hybris.backoffice.models;

import com.geempower.hybris.Cockpit;

public class TemplateBackoffice extends Cockpit {

    public TemplateBackoffice(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String getLoginUrl() {
        return null;
    }
}
