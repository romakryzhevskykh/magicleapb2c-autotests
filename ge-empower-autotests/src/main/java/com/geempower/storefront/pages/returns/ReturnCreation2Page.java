package com.geempower.storefront.pages.returns;

import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

import static com.geempower.storefront.page_elements.returns.ReturnCreation2PageElements.*;

@Component
public class ReturnCreation2Page extends StorefrontBasePage {

    private final String pageUri = "returnRequest2";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }


    @Step("Reason for Request title is displayed.")
    public boolean reasonForRequestTitleIsDisplayed() {
        waitUntilPageIsFullyLoaded();
        return isDisplayed(REASON_FOR_REQUEST_ACTIVE_TITLE_XPATH);
    }

    @Step("Select Reason For Request")
    public void selectReasonForRequest(String reason) {
        waitUntilPageIsFullyLoaded();
        click(FIRST_ROW_REASON_FOR_REQUEST_FIELD_XPATH);
        $$(REASON_FOR_REQUEST_DROP_DOWN_ELEMENTS_XPATH).stream()
                .filter(webElement -> webElement.getText().equals(reason)).findAny().ifPresent(WebElement::click);
    }

    @Step("Select Requested Action")
    public void selectRequestedAction(String action) {
        waitUntilPageIsFullyLoaded();
        click(FIRST_ROW_REQUESTED_ACTION_FIELD_XPATH);
        $$(REQUESTED_ACTION_DROP_DOWN_ELEMENTS_XPATH).stream()
                .filter(webElement -> webElement.getText().equals(action)).findAny().ifPresent(WebElement::click);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Set value to the Qty field")
    public void setQtyValue(String qty) {
        waitUntilPageIsFullyLoaded();
        $(FIRST_QTY_FIELD_XPATH).sendKeys(qty);
    }

    @Step("Click on bottom Next button")
    public void clickOnNextButton() {
        waitUntilPageIsFullyLoaded();
        click(By.id(BOTTOM_NEXT_BUTTON_ID));
    }

    @Step("Get Reason For Request")
    public String getReasonForRequest() {
        return $(FIRST_ROW_REASON_FOR_REQUEST_FIELD_XPATH).getText().trim();
    }

    @Step("Get Requested Action")
    public String getRequestedAction() {
        return $(SELECTED_FIRST_ROW_REQUESTED_ACTION_FIELD_XPATH).getText();
    }

    @Step("Get Catalog No")
    public String getCatalogNo() {
        return $(CATALOG_NO_VALUE_XPATH).getText();
    }

    @Step("Get List of Catalog No.")
    public List<String> getAllCatalogNo() {
        waitUntilPageIsFullyLoaded();
        List<String> catalogList = new ArrayList<>();
        $$(CATALOG_NO_VALUE_XPATH).forEach(product -> catalogList.add(product.getText()));
        return catalogList;
    }

    @Step("Set Random Reasons For list of products in Request")
    public void setRandomReasonsForListOfProductsInRequest(int rowNumber) {
        for (int i = 1; i <= rowNumber; i++) {
            waitUntilPageIsFullyLoaded();
            $(ROW_BY_NUMBER_REASON_FOR_REQUEST_FIELD_XPATH, String.valueOf(i)).click();
            $$(FINAL_REASON_FOR_REQUEST_DROP_DOWN_ELEMENTS_XPATH).stream().findAny().ifPresent(WebElement::click);
        }
    }
}