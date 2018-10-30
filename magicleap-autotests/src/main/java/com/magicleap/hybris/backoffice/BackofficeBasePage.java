package com.magicleap.hybris.backoffice;

import com.magicleap.helpers.BasePageObject;
import com.magicleap.hybris.backoffice.models.TemplateBackoffice;
import org.springframework.beans.factory.annotation.Autowired;

public class BackofficeBasePage extends BasePageObject {

    @Autowired
    protected TemplateBackoffice templateBackoffice;

    @Override
    public String getPageUrl() {
        return null;
    }
}
