package com.template.hybris.backoffice.models;

import com.template.hybris.Cockpit;

public class TemplateBackoffice extends Cockpit {

    public TemplateBackoffice(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String getLoginUrl() {
        return null;
    }
}
