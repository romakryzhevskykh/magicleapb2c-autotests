package com.geempower.storefront.pages;

import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.ShipmentsPageElements.*;

@Component
public class ShipmentsPage extends StorefrontBasePage {

    @Autowired
    private ShipmentsPage shipmentsPage;

    private final String pageUri = "aftership/dashboard";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().contains(getPageUrl());
    }

    @Step("Get Shipment title")
    public String getShipmentsTitle() {
        return $(By.xpath(SHIPMENTS_TITLE_XPATH)).getText().trim();
    }

    @Step("Color boxes are displayed")
    public boolean colorBoxesIsDisplayed() {
        return isDisplayed(COLOR_BOXES_XPATH);
    }

    @Step("Shipments table displayed")
    public boolean shipmentsTableHeaderIsDisplayed() {
        return isDisplayed(SHIPMENTS_TABLE_FILTERS_XPATH);
    }

    public boolean helpButtonIsDisplayed() {
        return isDisplayed(HELP_BUTTON_XPATH);
    }

    public boolean feedbackButtonIsDisplayed() {
        return isDisplayed(FEEDBACK_BUTTON_XPATH);
    }
}
