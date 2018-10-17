package com.plhb2b.hybris.backoffice.models;

import com.plhb2b.hybris.Cockpit;
import com.plhb2b.hybris.Cockpit;

public class TemplateBackoffice extends Cockpit {

    public TemplateBackoffice(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String getLoginUrl() {
        return null;
    }
}
