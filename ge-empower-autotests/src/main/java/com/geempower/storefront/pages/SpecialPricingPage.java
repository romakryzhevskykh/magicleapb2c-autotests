package com.geempower.storefront.pages;

import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.stream.Stream;

import static com.geempower.storefront.page_elements.SpecialPricingElements.*;

@Component
public class SpecialPricingPage extends StorefrontBasePage {
    private final String pageUri = "specialPricing";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

    @Step("Get Special pricing page title.")
    public String getSpecialPricingTitle() {
        return $(ALL_SPECIAL_PRICING_TITLE_XPATH).getText();
    }

    @Step("Get Regional list tab title.")
    public String getRegionalListTabTitle() {
        return $(REGIONAL_LIST_PRICE_TAB_XPATH).getText();
    }

    @Step("User switches to new Regional List tab.")
    public void openRegionalListTab() {
        waitUntilPageIsFullyLoaded();
        click(REGIONAL_LIST_PRICE_TAB_XPATH);
    }

    @Step("User opens Price schedule list.")
    public void openPriceScheduleList() {
        waitUntilPageIsFullyLoaded();
        click(PRICING_LIST_IN_REGIONAL_LIST_PRICE_TAB_OPEN_ICON_XPATH);
    }

    @Step("Get All Price Schedule Documents.")
    public Stream<WebElement> getAllPriceScheduleDocuments() {
        return $$(PRICE_SCHEDULE_LIST_ELEMENTS_XPATH).stream();
    }

    @Step("Check if Regional List tab is displayed.")
    public boolean isRegionalListTabDisplayed() {
        return isDisplayed(REGIONAL_LIST_PRICE_TAB_XPATH);
    }
}
