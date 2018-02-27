package com.geempower.storefront.pages;

import com.geempower.storefront.StorefrontBasePage;
import org.springframework.stereotype.Component;

import static com.geempower.storefront.page_elements.DashboardPageElements.*;

@Component
public class DashboardPage extends StorefrontBasePage {

    private final String pageUri = "";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl();
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

    public boolean orderStatusWidgetIsDisplayed() {
        return isDisplayed(ORDER_STATUS_WIDGET_XPATH);
    }

    public boolean featuredUpdatesWidgetIsDisplayed() {
        return isDisplayed(FEATURED_UPDATES_WIDGET_XPATH);
    }

    public boolean orderSearchWidgetIsDisplayed() {
        return isDisplayed(ORDER_SEARCH_WIDGET_XPATH);
    }

    public boolean priceAndAvailabilityWidgetIsDisplayed() {
        return isDisplayed(PRICE_AND_AVAILABILITY_WIDGET_XPATH);
    }

    public boolean recentOrdersWidgetIsDisplayed() {
        return isDisplayed(RECENT_ORDERS_WIDGET_XPATH);
    }

    public boolean recentListWidgetIsDisplayed() {
        return isDisplayed(RECENT_LIST_WIDGET_XPATH);
    }

    public void skipTrainingLevel() {
        click(SKIP_BUTTON_XPATH);
    }

    public String isSelectedAccountIsDisplayed() {
        waitUntilPageIsFullyLoaded();
        return $(ACCOUNT_INFO_XPATH).getText();

    }
}
