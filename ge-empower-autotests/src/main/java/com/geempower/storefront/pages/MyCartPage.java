package com.geempower.storefront.pages;

import com.geempower.helpers.models.Product;
import com.geempower.storefront.StorefrontBasePage;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.MyCartPageElements.*;

@Component
public class MyCartPage extends StorefrontBasePage {

    private final String pageUri = "checkout";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

    @Step("Get My Cart title")
    public String getMyCartTitle() {
        return $(MY_CART_TITLE_XPATH).getText();
    }

    @Step("Are order step icons displayed")
    public boolean areOrderStepIconsDisplayed() {
        return $(BUILD_ORDER_STEP_ICON_XPATH).isDisplayed() &&
                $(SHIPPING_BILLING_INFO_STEP_ICON_XPATH).isDisplayed() &&
                $(ORDER_SUMMARY_STEP_ICON_XPATH).isDisplayed();
    }

    @Step("Is build Order Information input present")
    public boolean isBuildOrderInformationInputPresent() {
        return $(BUILD_ORDER_FORM_WRAPPER_XPATH).isDisplayed() &&
                $(BUILD_ORDER_INFORMATION_INPUT_XPATH).isDisplayed();
    }

    @Step("Is add item button present")
    public boolean isAddItemButtonPresent() {
        return $(ADD_ITEM_BUTTON_XPATH).isDisplayed();
    }

    @Step("Is delete button present")
    public boolean isDeleteItemButtonPresent() {
        return $(DELETE_ITEM_BUTTON_XPATH).isDisplayed();
    }

    @Step("Is Update P&A button displayed")
    public boolean isUpdatePriceAndAvailabilityButtonPresent() {
        return $(UPDATE_PRICE_AND_AVAILABILITY_BUTTON_XPATH).isDisplayed();
    }

    @Step("Is Next bottom button displayed")
    public boolean isNextBottomButtonPresent() {
        return $(BUILD_ORDER_BOTTOM_NEXT_BUTTON_XPATH).isDisplayed();
    }

    @Step("Is Next top button displayed")
    public boolean isNextTopButtonPresent() {
        return $(BUILD_ORDER_TOP_NEXT_BUTTON_XPATH).isDisplayed();
    }

    @Step("Is main order data displayed on the top right")
    public boolean isMainOrderDataDisplayedOnTheTopRight() {
        return $(MAIN_ORDER_DATA_TOP_RIGHT_XPATH).isDisplayed();
    }

    @Step("Is Save item button displayed")
    public boolean isSaveItemsButtonPresent() {
        return $(SAVE_ITEMS_BUTTON_XPATH).isDisplayed();
    }

    @Step("Is Cancel button displayed")
    public boolean isCancelButtonPresent() {
        return $(CANCEL_BUTTON_XPATH).isDisplayed();
    }

    @Step("Cancel the Order by clicking on the Cancel button.")
    public void clickOnCancelButton() {
        $(CANCEL_BUTTON_XPATH).click();
        waitUntilPageIsFullyLoaded();
        $(DISCARD_ORDER_BUTTON_XPATH).click();
    }

    @Step("Click on the Top Next button on the My Cart page")
    public void clickOnTheNextTopButton() {
        $(BUILD_ORDER_TOP_NEXT_BUTTON_XPATH).click();
        waitUntilPageIsFullyLoaded();
    }

    @Step("Get Qty value")
    public String getQtyValue(Product product) {
        return $(QTY_VALUE_INPUT_XPATH, product.getCatalogueNo().toUpperCase()).getAttribute("value");
    }

    @Step("Set Quantity value to qty. field for each product")
    public void setQuantityForProduct(Product product, int randomQuantity) {
        waitUntilPageIsFullyLoaded();
        $(QTY_VALUE_INPUT_XPATH, product.getCatalogueNo().toUpperCase()).clear();
        $(QTY_VALUE_INPUT_XPATH, product.getCatalogueNo().toUpperCase()).sendKeys(Integer.toString(randomQuantity));
    }

    @Step("Select all products by clicking on All checkbox")
    public void clickOnSelectAllCheckbox() {
        waitUntilPageIsFullyLoaded();
        $(ALL_CHECKBOXES_XPATH).click();
    }

    @Step("Clicking on P&A button")
    public void clickOnUpdatePAButton() {
        $(UPDATE_PRICE_AND_AVAILABILITY_BUTTON_XPATH).click();
    }

    @Step("Getting the updated Extended price")
    public String getNewExtendPrice(Product product) {
        waitUntilPageIsFullyLoaded();
        return $(EXTENDED_PRICE_ON_MY_CART_XPATH, product.getCatalogueNo().toUpperCase()).getText();

    }
}
