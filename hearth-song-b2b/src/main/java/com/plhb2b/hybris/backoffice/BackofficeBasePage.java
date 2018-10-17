package com.plhb2b.hybris.backoffice;

import com.plhb2b.helpers.BasePageObject;
import com.plhb2b.hybris.backoffice.models.TemplateBackoffice;
import org.springframework.beans.factory.annotation.Autowired;

public class BackofficeBasePage extends BasePageObject {

    @Autowired
    protected TemplateBackoffice templateBackoffice;

    @Override
    public String getPageUrl() {
        return null;
    }
}
