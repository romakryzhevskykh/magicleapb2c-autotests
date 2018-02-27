package com.geempower.storefront.pages;

import com.geempower.storefront.StorefrontBasePage;
import org.springframework.stereotype.Component;
import static com.geempower.storefront.page_elements.DashboardPageElements.*;

@Component
public class DashboardPage extends StorefrontBasePage {

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl();
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

    public void skipTrainingLevel() {
        click(SKIP_BUTTON_XPATH);
    }

    public String isSelectedAccountIsDisplayed() {
        waitUntilPageIsFullyLoaded();
        return $(ACCOUNT_INFO_XPATH).getText();
    }
}
