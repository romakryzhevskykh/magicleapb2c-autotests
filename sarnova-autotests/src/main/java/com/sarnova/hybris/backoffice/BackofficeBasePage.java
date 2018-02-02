package com.sarnova.hybris.backoffice;

import com.sarnova.helpers.BasePageObject;
import com.sarnova.hybris.backoffice.models.SarnovaBackoffice;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BackofficeBasePage extends BasePageObject {

    @Autowired
    protected SarnovaBackoffice sarnovaBackoffice;

}
