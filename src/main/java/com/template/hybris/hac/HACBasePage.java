package com.template.hybris.hac;

import com.template.helpers.page.BasePageObject;
import com.template.hybris.hac.models.TemplateHAC;
import org.springframework.beans.factory.annotation.Autowired;

public class HACBasePage extends BasePageObject {

    @Autowired
    protected TemplateHAC templateHAC;

    @Override
    public String getPageUrl() {
        return null;
    }
}
