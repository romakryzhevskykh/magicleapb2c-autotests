package com.magicleap.hybris.backoffice.models;

import com.magicleap.hybris.Cockpit;

public class TemplateBackoffice extends Cockpit {

    public TemplateBackoffice(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String getLoginUrl() {
        return null;
    }
}
