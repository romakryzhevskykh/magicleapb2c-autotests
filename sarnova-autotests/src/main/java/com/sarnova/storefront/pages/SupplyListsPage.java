package com.sarnova.storefront.pages;

import com.sarnova.helpers.managers.SupplyListsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SupplyListsPage extends StorefrontBasePage {
    @Autowired private SupplyListsManager supplyListsManager;

    private final String pageUrlMethod = "/boundtree/en/USD/my-account/supply-lists";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(pageUrlMethod);
    }
}
