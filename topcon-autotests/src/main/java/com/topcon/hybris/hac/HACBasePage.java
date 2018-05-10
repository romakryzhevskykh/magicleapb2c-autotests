package com.topcon.hybris.hac;

import com.topcon.helpers.BasePageObject;
import com.topcon.hybris.hac.models.TopconHAC;
import org.springframework.beans.factory.annotation.Autowired;

public class HACBasePage extends BasePageObject {

    @Autowired
    protected TopconHAC TopconHAC;

    @Override
    public String getPageUrl() {
        return null;
    }
}
