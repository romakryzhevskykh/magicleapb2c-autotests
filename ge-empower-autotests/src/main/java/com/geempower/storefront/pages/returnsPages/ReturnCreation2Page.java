package com.geempower.storefront.pages.returnsPages;

import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;


import static com.geempower.storefront.page_elements.returnsCreationPageElements.ReturnCreation2PageElements.*;

@Component
public class ReturnCreation2Page extends StorefrontBasePage {

    private final String pageUri = "returnRequest2";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }


    @Step("Return Creation 2 page Is Displayed.")
    public boolean returnCreation2pageIsDisplayed() {
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
}
