package com.geempower.storefront.pages;

import com.geempower.helpers.models.Product;
import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.stream.Stream;

import static com.geempower.storefront.page_elements.MyCartPageElements.GREEN_CONFIRMATION_POP_UP_ID;
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
        waitUntilPageIsFullyLoaded();
        click(ALL_CHECKBOXES_XPATH);
    }

    @Step("Click on Add to Card button")
    public void clickOnAddToCartButton() {
        $(ADD_TO_CARD_BUTTON_XPATH).click();
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
    public int getLineItemsValue() {
        return Integer.parseInt($(LINE_ITEMS_VALUE_XPATH).getText());
    }

    @Step("Set quantity to quantity field")
    public void setQuantityForProduct(Product product, int quantity) {
        $(QUANTITY_INPUT_XPATH, product.getCatalogueNo().toUpperCase()).clear();
        $(QUANTITY_INPUT_XPATH, product.getCatalogueNo().toUpperCase()).sendKeys(Integer.toString(quantity));
    }

    @Step("Click on Update Price and Availability button")
    public void clickOnUpdatePAButton() {
        click(UPDATE_PRICE_AND_AVAILABILITY_BUTTON_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Getting final extend price for product")
    public String getNewExtendPrice(Product product) {
        waitUntilPageIsFullyLoaded();
        return $(EXTENDED_PRICE_XPATH, product.getCatalogueNo().toUpperCase()).getText();
    }

    @Step("Get order Value from checkout pop-up")
    public String getOrderValueFromCheckoutPopUp() {
        waitUntilPageIsFullyLoaded();
        String orderValue = $(ORDER_VALUE_XPATH).getText();
        return orderValue.substring(0, orderValue.length() - 4);
    }

    @Step("Check that cart count icon is displayed")
    public boolean counterIconIsDisplayed() {
        waitUntilPageIsFullyLoaded();
        return isDisplayed(CART_COUNT_ICON_XPATH);
    }

    @Step("Click on My Cart button")
    public void clickOnMyCartIcon() {
        waitForElementToDisappear(By.id(GREEN_CONFIRMATION_POP_UP_ID));
        $(CART_ICON_XPATH).click();
        waitUntilPageIsFullyLoaded();
    }

    @Step("Click on Checkout button")
    public void clickOnCheckoutButton() {
        $(CHECKOUT_BUTTON_XPATH).click();
    }

    @Step("Check that all the product are shown on the P&A page.")
    public boolean areAllProductsPresent(String product) {
        return getDriver().getPageSource().contains(product);
    }

    @Step("Get count of error message on the P&A page.")
    public int getCountOfProductErrorMessages() {
        return $$(PRODUCT_ERROR_MESSAGES_XPATH).size();
    }

    @Step("Set Appropriate agreement No To All Products.")
    public void userSelectAgreementNoForAllTheProduct(String agreementNo) {
        click(SEARCH_AGREEMENT_NO_ICON_XPATH);
        waitForElementWithAppropriateTextToAppear(By.xpath(SPECIAL_PRICING_POP_UP_TITLE_XPATH), "Special Pricing Lookup");
        searchAppropriateAgreementNoViaSearchFieldOnSpecialPricingLookupPopUp(agreementNo);
        click(APPLY_TO_ALL_BUTTON_SPECIAL_PRICING_POP_UP_XPATH);
        waitUntilPageIsFullyLoaded();
        click(By.id(UPDATE_PRICE_AND_AVAILABILITY_BUTTON_ID));
        waitUntilPageIsFullyLoaded();
    }

    @Step("Search Appropriate Agreement Via Search Field On Special Pricing Lookup Pop Up.")
    private void searchAppropriateAgreementNoViaSearchFieldOnSpecialPricingLookupPopUp(String agreementNo) {
        waitUntilPageIsFullyLoaded();
        $(SEARCH_AGREEMENT_NO_INPUT_XPATH).clear();
        $(SEARCH_AGREEMENT_NO_INPUT_XPATH).sendKeys(agreementNo);
        click(SEARCH_AGREEMENT_NO_ICON_SPECIAL_PRICING_POP_UP_XPATH);
        waitUntilPageIsFullyLoaded();
        click(FIRST_AGREEMENT_ON_THE_SPECIAL_PRICING_POP_UP_XPATH);
    }

    @Step("Get Agreement No For The Product.")
    public Stream<WebElement> getAgreementNoForTheProduct() {
        return $$(AGREEMENT_NO_VALUES_FOR_ALL_PRODUCTS_XPATH).stream();
    }

    @Step("Add new items.")
    public void addNewItem(String catalogueNo) {
        click(ADD_ITEM_BUTTON_XPATH);
        $(ADD_ITEM_POP_UP_FIRST_PRODUCT_FIELD_XPATH).clear();
        $(ADD_ITEM_POP_UP_FIRST_PRODUCT_FIELD_XPATH).sendKeys(catalogueNo);
        click(ADD_ITEM_POP_UP_ADD_PRODUCT_BUTTON_XPATH);
    }

    @Step("Get Claimback message below SPA No field.")
    public String getClaimbackMessageBelowSpaNoField() {
        return $(CLAIMBACK_MESSAGE_BELOW_AGREEMENT_NO_FIELD_XPATH).getText();
    }

    @Step("Click on product link on P&A Page.")
    public void clickOnProductLinkOnPaPage(List<String> products) {
        waitUntilPageIsFullyLoaded();
        click(PRODUCT_LINK_ON_PA_PAGE_XPATH, String.valueOf(products));
    }
}