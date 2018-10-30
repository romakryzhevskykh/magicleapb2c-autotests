package com.magicleap.hybris.hac;

import com.magicleap.helpers.BasePageObject;
import com.magicleap.hybris.hac.models.TemplateHAC;
import org.springframework.beans.factory.annotation.Autowired;

public class HACBasePage extends BasePageObject {

    @Autowired
    protected TemplateHAC templateHAC;

    @Override
    public String getPageUrl() {
        return null;
    }
}
