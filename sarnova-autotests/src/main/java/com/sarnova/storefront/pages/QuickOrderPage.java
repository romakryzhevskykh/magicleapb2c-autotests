package com.sarnova.storefront.pages;

import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.sarnova.storefront.page_elements.QuickOrderPageElements.*;

@Component
public class QuickOrderPage extends StorefrontBasePage {

    private String pageUrlMethod = "quickOrder";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }

    @Step("Is Add to Supply list button visible?")
    public boolean isAddToSupplyListButtonVisible() {
        return isDisplayed(ADD_TO_SUPPLY_LIST_BUTTONS_XPATH);
    }

    @Step("Is Add to Supply list button enabled?")
    public boolean isAddToSupplyListButtonEnabled() {
        return $(ADD_TO_SUPPLY_LIST_BUTTONS_XPATH).isEnabled();
    }
}
