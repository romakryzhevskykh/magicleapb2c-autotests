package com.sarnova.hybris.hac;

import com.sarnova.helpers.BasePageObject;
import com.sarnova.hybris.hac.models.SarnovaHAC;
import org.springframework.beans.factory.annotation.Autowired;

public class HACBasePage extends BasePageObject {

    @Autowired
    protected SarnovaHAC sarnovaHAC;

}
