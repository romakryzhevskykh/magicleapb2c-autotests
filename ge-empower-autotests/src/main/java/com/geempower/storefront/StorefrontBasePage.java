package com.geempower.storefront;

import com.geempower.helpers.BasePageObject;
import com.geempower.storefront.models.EmpowerStorefront;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class StorefrontBasePage extends BasePageObject {
    @Autowired
    protected EmpowerStorefront storefrontProject;

    public boolean isOpened() {
        return getPageUrl().equals(getCurrentUrl());
    }

    public void open() {
        open(getPageUrl());
    }

    public abstract String getPageUrl();
}
