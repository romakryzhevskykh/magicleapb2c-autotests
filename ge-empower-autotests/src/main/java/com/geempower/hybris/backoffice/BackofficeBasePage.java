package com.geempower.hybris.backoffice;

import com.geempower.helpers.BasePageObject;
import com.geempower.hybris.backoffice.models.TemplateBackoffice;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BackofficeBasePage extends BasePageObject {

    @Autowired
    protected TemplateBackoffice templateBackoffice;

}
