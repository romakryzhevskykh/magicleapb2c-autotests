package com.plhb2b.hybris.hac;

import com.plhb2b.helpers.BasePageObject;
import com.plhb2b.hybris.hac.models.TemplateHAC;
import org.springframework.beans.factory.annotation.Autowired;

public class HACBasePage extends BasePageObject {

    @Autowired
    protected TemplateHAC templateHAC;

    @Override
    public String getPageUrl() {
        return null;
    }
}
