package com.topcon.hybris.backoffice;

import com.topcon.helpers.BasePageObject;
import com.topcon.hybris.backoffice.models.TopconBackoffice;
import org.springframework.beans.factory.annotation.Autowired;

public class BackofficeBasePage extends BasePageObject {

    @Autowired
    protected TopconBackoffice templateBackoffice;

    @Override
    public String getPageUrl() {
        return null;
    }
}
