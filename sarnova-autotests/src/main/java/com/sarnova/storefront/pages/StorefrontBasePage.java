package com.sarnova.storefront.pages;

import com.sarnova.helpers.BasePageObject;
import com.sarnova.storefront.models.SarnovaStorefront;
import com.sarnova.storefront.page_blocks.HeaderRowPageBlock;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class StorefrontBasePage extends BasePageObject {
    @Autowired SarnovaStorefront storefrontProject;

    @Autowired private HeaderRowPageBlock headerRowPageBlock;

    protected boolean isUserLoggedIn() {
        return headerRowPageBlock.isUserLoggedIn();
    }

    protected boolean isUserLoggedOut() {
        return headerRowPageBlock.isUserLoggedOut();
    }

    public boolean isOpened() {
        return getPageUrl().equals(getCurrentUrl());
    }

    public void open() {
        open(getPageUrl());
    }

    public abstract String getPageUrl();
}
