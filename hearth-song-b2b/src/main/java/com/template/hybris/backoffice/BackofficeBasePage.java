package com.template.hybris.backoffice;

import com.template.helpers.BasePageObject;
import com.template.hybris.backoffice.models.TemplateBackoffice;
import org.springframework.beans.factory.annotation.Autowired;

public class BackofficeBasePage extends BasePageObject {

    @Autowired
    protected TemplateBackoffice templateBackoffice;

    @Override
    public String getPageUrl() {
        return null;
    }
}
