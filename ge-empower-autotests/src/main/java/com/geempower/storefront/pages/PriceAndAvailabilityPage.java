package com.geempower.storefront.pages;

import com.geempower.helpers.models.Product;
import com.geempower.storefront.StorefrontBasePage;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.PriceAndAvailabilityPageElements.*;

@Component
public class PriceAndAvailabilityPage extends StorefrontBasePage {
    private final String pageUri = "check-price-availability";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

    @Step("Select all checkboxes")
    public void clickOnAllCheckboxes() {
        click(ALL_CHECKBOXES_XPATH);
    }

    @Step("Click on Add to Card button")
    public void clickOnAddToCartButton() {
        click(ADD_TO_CARD_BUTTON_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Get Qty value")
    public String getQtyValue(Product product) {
        return $(QUANTITY_INPUT_XPATH, product.getCatalogueNo().toUpperCase()).getAttribute("value");
    }

    @Step("Get Description")
    public String getDescription() {
        return $(DESCRIPTION_FIELD_XPATH).getText();
    }

    @Step("Get List Price")
    public String getListPrice() {
        return $(LIST_PRICE_FIELD_XPATH).getText();
    }

    @Step("Get Final Net Price")
    public String getFinalNetPrice() {
        return $(FINAL_NET_PRICE_FIELD_XPATH).getText();
    }

    @Step("Get Availability")
    public String getAvailability(Product product) {
        return $(AVAILABILITY_FIELD_XPATH, product.getCatalogueNo().toUpperCase()).getText();
    }

    @Step("Get Line Items value")
    public String getLineItemsValue() {
        return $(LINE_ITEMS_VALUE_XPATH).getText();
    }

    @Step("Set quantity to quantity field")
    public void setQuantityForProduct(Product product, int quantity) {
        $(QUANTITY_INPUT_XPATH, product.getCatalogueNo().toUpperCase()).clear();
        $(QUANTITY_INPUT_XPATH, product.getCatalogueNo().toUpperCase()).sendKeys(Integer.toString(quantity));
    }

    @Step("Click on Update Price and Availability button")
    public void clickOnUpdatePAButton() {
        click(UPDATE_PRICE_AND_AVAILABILITY_BUTTON_XPATH);
    }

    @Step("Getting final extend price for product")
    public String getNewExtendPrice(Product product) {
        waitUntilPageIsFullyLoaded();
        return $(EXTENDED_PRICE_XPATH, product.getCatalogueNo().toUpperCase()).getText();
    }

    @Step("Get Order Value from checkout pop-up")
    public String getOrderValueFromCheckoutPopUp() {
        String orderValue = $(ORDER_VALUE_XPATH).getText();
        return orderValue.substring(0, orderValue.length() - 4);
    }

    @Step("Check that cart count icon is displayed")
    public boolean counterIconIsDisplayed() {
        return isDisplayed(CART_COUNT_ICON_XPATH);
    }

    @Step("Click on My Cart button")
    public void clickOnMyCartIcon() {
        $(CART_ICON_XPATH).click();
        waitUntilPageIsFullyLoaded();
    }

    @Step("Click on Checkout button")
    public void clickOnCheckoutButton() {
        $(CHECKOUT_BUTTON_XPATH).click();
    }
}
