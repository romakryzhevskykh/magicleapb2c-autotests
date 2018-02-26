package com.geempower.hybris.hac;

import com.geempower.helpers.BasePageObject;
import com.geempower.hybris.hac.models.TemplateHAC;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class HACBasePage extends BasePageObject {

    @Autowired
    protected TemplateHAC templateHAC;

}
