package com.geempower.storefront.pages.returns;

import com.geempower.helpers.Utils;
import com.geempower.storefront.StorefrontBasePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.time.LocalDateTime;
import java.time.ZoneId;

import static com.geempower.storefront.page_elements.returns.ReturnCreation3PageElements.*;

@Component
public class ReturnCreation3Page extends StorefrontBasePage {

    @Autowired
    private Utils utils;

    private final String pageUri = "returnAdditionalInformation";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }


    @Step("Return Creation 3 page Is Opened.")
    public boolean returnCreation3pageIsOpened() {
        waitUntilPageIsFullyLoaded();
        return isDisplayed(ADDITIONAL_INFORMATION_ACTIVE_TITLE_XPATH);
    }

    @Step("Click on Additional Info Button")
    public void clickOnAdditionalInfoButton() {
        waitUntilPageIsFullyLoaded();
        click(ADDITIONAL_INFORMATION_BUTTON_XPATH);
    }

    @Step("Set color of shrink field")
    public String setColorOfShrinkField() {
        waitUntilPageIsFullyLoaded();
        String uniqueColor = Long.toString(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().getEpochSecond());
        $(COLOR_OF_SHRINK_FIELD_XPATH).sendKeys(uniqueColor);
        return uniqueColor;
    }


    @Step("Set Additional Information Field")
    public String setAdditionalInformationField() {
        waitUntilPageIsFullyLoaded();
        String uniqueAddInfo = Long.toString(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().getEpochSecond());
        $(ADDITIONAL_INFO_FIELD_XPATH).sendKeys(uniqueAddInfo);
        return uniqueAddInfo;
    }

    @Step("Click on Save button")
    public void clickOnSaveButton() {
        waitUntilPageIsFullyLoaded();
        click(SAVE_BUTTON_XPATH);
    }

    @Step("Click on Next button")
    public void clickOnNextButton() {
        waitUntilPageIsFullyLoaded();
        click(BOTTOM_NEXT_BUTTON_XPATH);
    }

    @Step("Get Reason For Request Value")
    public String getReasonForRequest() {
        return $(REASON_FOR_REQUEST_VALUE_XPATH).getText();
    }

    @Step("Get Requested Action")
    public String getRequestedAction() {
        return $(REQUESTED_ACTION_VALUE_XPATH).getText();
    }

    @Step("Get Catalog No")
    public String getCatalogNo() {
        return $(CATALOG_NO_VALUE_XPATH).getText();
    }

    @Step("Get Alert Text For Non Returnable Products")
    public String getAlertTextForNonReturnableProducts() {
        return $(MESSAGE_FOR_NON_RETURNABLE_PRODUCTS_XPATH).getText();
    }

    @Step("Check If Exclamation Mark Displayed")
    public boolean checkIfExclamationMarkDisplayed(String flag) {
        return isDisplayed(EXCLAMATION_MARK_FOR_NON_RETURNABLE_PRODUCT_XPATH, flag);
    }

    @Step("Get Disable Attribute Of Next Button")
    public String getDisableAttributeOfNextButton() {
        return $(BOTTOM_NEXT_BUTTON_XPATH).getAttribute("disabled");
    }

    @Step("Delete All Non Returnable Products")
    public void deleteAllNonReturnableProducts() {
        $$(ALL_NON_RETURNABLE_PRODUCTS_REMOVE_ICON_XPATH).forEach(product -> {
            product.click();
            waitUntilPageIsFullyLoaded();
        });
    }

    @Step("Store Actual Product To The Thread Vars")
    public String storeActualProductToTheThreadVars() {
        waitUntilPageIsFullyLoaded();
        return $(ALL_CATALOG_NUMBERS_TEXT_XPATH).getText();
    }

    @Step("Store Actual Reason for request To The Thread Vars")
    public String storeActualReasonForRequestToTheThreadVars() {
        waitUntilPageIsFullyLoaded();
        return $(ALL_REASONS_FOR_REQUEST_XPATH).getText();
    }

    @Step("Store Actual Requested action To The Thread Vars")
    public String storeActualRequestedActionToTheThreadVars() {
        waitUntilPageIsFullyLoaded();
        return $(ALL_REQUESTED_ACTION_XPATH).getText();
    }

    public void uploadAdditionalInfoFile(String fileName) {
        waitUntilPageIsFullyLoaded();
        utils.uploadFileByName(fileName, ADDITIONAL_INFO_PATH_INPUT_XPATH);
    }
}