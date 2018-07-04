package com.template.storefront.pages;

import com.template.helpers.BasePageObject;
import com.template.storefront.models.CheckoutDataModel;
import com.template.storefront.models.CheckoutModelBuilder;
import com.template.storefront.models.TemplateStorefront;
import com.template.storefront.models.UserModelBuilder;
import com.template.storefront.page_blocks.HeaderRowPageBlock;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import ru.yandex.qatools.allure.annotations.Step;

public abstract class StorefrontBasePage extends BasePageObject {
    @Autowired public TemplateStorefront storefrontProject;
    @Autowired public UserModelBuilder userModelBuilder;
    @Autowired public CheckoutModelBuilder checkoutModelBuilder;
    @Autowired private HeaderRowPageBlock headerRowPageBlock;
    final static Logger logger = Logger.getLogger(StorefrontBasePage.class);

	protected boolean isUserLoggedIn() {
        return headerRowPageBlock.isUserLoggedIn();
    }
    protected boolean isUserLoggedInEsab() {
        return headerRowPageBlock.isUserLoggedEsab();
    }

    protected boolean isUserLoggedOut() {
        return headerRowPageBlock.isUserLoggedOut();
    }

    @Step("Check that Shipping address book page is opened.")
    public boolean isOpened() {
        return getPageUrl().equals(getCurrentUrl());
    }

    public void open() {
        open(getPageUrl());
    }

    public abstract String getPageUrl();
    
    
    
}
