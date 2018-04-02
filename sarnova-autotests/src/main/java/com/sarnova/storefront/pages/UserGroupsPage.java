package com.sarnova.storefront.pages;

import org.springframework.stereotype.Component;

@Component
public class UserGroupsPage extends StorefrontBasePage {

    private String pageUrlMethod = "boundtree/en/USD/my-account/organization-management/manage-usergroups/";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}
