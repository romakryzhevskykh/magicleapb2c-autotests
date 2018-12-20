package com.geempower.storefront.pages.returns;

import com.geempower.helpers.Utils;
import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

import static com.geempower.storefront.page_elements.returns.ReturnCreation2PageElements.*;

@Component
public class ReturnCreation2Page extends StorefrontBasePage {
    @Autowired
    private Utils utils;

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

    @Step("Select Reason For Request.")
    public void selectReasonForRequest(String reason) {
        waitUntilPageIsFullyLoaded();
        click(FIRST_ROW_REASON_FOR_REQUEST_FIELD_XPATH);
        $$(REASON_FOR_REQUEST_DROP_DOWN_ELEMENTS_XPATH).stream()
                .filter(webElement -> webElement.getText().equals(reason)).findAny().ifPresent(WebElement::click);
    }

    @Step("Select Requested Action.")
    public void selectRequestedAction(String action) {
        waitUntilPageIsFullyLoaded();
        click(FIRST_ROW_REQUESTED_ACTION_FIELD_XPATH);
        waitUntilPageIsFullyLoaded();
        $$(REQUESTED_ACTION_DROP_DOWN_ELEMENTS_XPATH).stream()
                .filter(webElement -> webElement.getText().equals(action)).findAny().ifPresent(WebElement::click);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Set value to the Qty field.")
    public void setQtyValue(String qty) {
        waitUntilPageIsFullyLoaded();
        $(FIRST_QTY_FIELD_XPATH).sendKeys(qty);
    }

    @Step("Click on bottom Next button.")
    public void clickOnNextButton() {
        waitUntilPageIsFullyLoaded();
        click(By.id(BOTTOM_NEXT_BUTTON_ID));
    }

    @Step("Get Reason For Request.")
    public String getReasonForRequest() {
        return $(FIRST_ROW_REASON_FOR_REQUEST_FIELD_XPATH).getText().trim();
    }

    @Step("Get Requested Action.")
    public String getRequestedAction() {
        return $(SELECTED_FIRST_ROW_REQUESTED_ACTION_FIELD_XPATH).getText();
    }

    @Step("Get Catalog No.")
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

    @Step("Set Random Reasons For list of products in Request.")
    public void setRandomReasonsForListOfProductsInRequest(int rowNumber) {
        for (int i = 1; i <= rowNumber; i++) {
            waitUntilPageIsFullyLoaded();
            $(ROW_BY_NUMBER_REASON_FOR_REQUEST_FIELD_XPATH, String.valueOf(i)).click();
            $$(FINAL_REASON_FOR_REQUEST_DROP_DOWN_ELEMENTS_XPATH).stream().findAny().ifPresent(WebElement::click);
        }
    }

    @Step("Set Reasons Type For Request.")
    public void selectRequestTypeForRequest(String type) {
        waitUntilPageIsFullyLoaded();
        $$(REQUEST_TYPE_LIST_XPATH).stream()
                .filter(webElement -> webElement.getText().equals(type)).findAny().ifPresent(WebElement::click);
    }

    @Step("Set Reasons SubType For Request.")
    public void selectRequestSubTypeForRequest(String subType) {
        waitUntilPageIsFullyLoaded();
        $$(REQUEST_SUB_TYPE_LIST_XPATH).stream()
                .filter(webElement -> webElement.getText().equals(subType)).findAny().ifPresent(WebElement::click);
    }

    @Step("Click On Save For Later Button.")
    public void clickOnSaveForLaterButton() {
        click(SAVE_FOR_LATER_BUTTON_XPATH);
    }

    @Step("User hover mouse over top Next button on Return Creation 2 page.")
    public void userHoverMouseOverBottomNextButtonOnReturnCreation2Page() {
        moveToElement($(By.id(BOTTOM_NEXT_BUTTON_ID)));
    }

    @Step("Get Next Button Tool Tip Text 2 Page.")
    public String getNextButtonToolTipText2Page() {
        waitUntilPageIsFullyLoaded();
        return $(NEXT_BUTTON_TOOLTIP_XPATH).getText();
    }

    @Step("Get Save For Later Pop-Up Title.")
    public String getSaveForLaterPopUpTitle() {
        waitUntilPageIsFullyLoaded();
        return $(SAVE_FOR_LATER_POP_UP_TITLE_XPATH).getText();
    }

    @Step("Get Save For Later Pop-up Header.")
    public String getSaveForLaterPopUpHeader() {
        waitUntilPageIsFullyLoaded();
        return $(SAVE_FOR_LATER_POP_UP_HEADER_XPATH).getText();
    }

    @Step("Set Name For New Saved Return List.")
    public String setNameForNewSavedReturnList() {
        waitUntilPageIsFullyLoaded();
        String returnListName = utils.generateUniqueTimestamp();
        $(SAVE_FOR_LATER_POP_UP_LIST_NAME_INPUT_XPATH).clear();
        $(SAVE_FOR_LATER_POP_UP_LIST_NAME_INPUT_XPATH).sendKeys(returnListName);
        return returnListName;
    }

    @Step("Click Save New Return List.")
    public void clickSaveNewReturnList() {
        click(SAVE_FOR_LATER_POP_UP_SAVE_BUTTON_XPATH);
    }
}