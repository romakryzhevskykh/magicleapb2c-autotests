package com.geempower.storefront.pages;

import com.geempower.storefront.StorefrontBasePage;
import org.springframework.stereotype.Component;

@Component
public class AccountManagementPage extends StorefrontBasePage {

    private final String pageUri = "my-account/manage-accounts";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }
}
