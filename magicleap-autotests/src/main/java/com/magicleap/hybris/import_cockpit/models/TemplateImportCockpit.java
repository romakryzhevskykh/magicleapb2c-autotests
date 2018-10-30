package com.magicleap.hybris.import_cockpit.models;

import com.magicleap.hybris.Cockpit;

public class TemplateImportCockpit extends Cockpit {

    public TemplateImportCockpit(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String getLoginUrl() {
        return null;
    }
}
