package com.geempower.storefront.pages;

import com.geempower.helpers.Utils;
import com.geempower.storefront.StorefrontBasePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountManagementPage extends StorefrontBasePage {

    private final String pageUri = "my-account/manage-accounts";

    @Autowired
    private Utils utils;

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

}