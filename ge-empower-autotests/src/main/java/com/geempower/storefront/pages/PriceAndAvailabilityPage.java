package com.geempower.storefront.pages;

import com.geempower.helpers.models.Product;
import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.stream.Stream;

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

    @Step("Select all checkboxes.")
    public void clickOnAllCheckboxes() {
        waitUntilPageIsFullyLoaded();
        click(ALL_CHECKBOXES_XPATH);
    }

    @Step("Click on Add to Card button.")
    public void clickOnAddToCartButton() {
        $(ADD_TO_CARD_BUTTON_XPATH).click();
        waitUntilPageIsFullyLoaded();
    }

    @Step("Get Qty value.")
    public String getQtyValue(Product product) {
        return $(QUANTITY_INPUT_RELATES_TO_PRODUCT_XPATH, product.getCatalogNo().toUpperCase()).getAttribute("value");
    }

    @Step("Get Description.")
    public String getDescription() {
        waitUntilPageIsFullyLoaded();
        return $(DESCRIPTION_FIELD_XPATH).getText();
    }

    @Step("Get List Price.")
    public String getListPrice() {
        waitUntilPageIsFullyLoaded();
        return $(LIST_PRICE_FIELD_XPATH).getText();
    }

    @Step("Get Final Net Price.")
    public String getFinalNetPrice() {
        waitUntilPageIsFullyLoaded();
        return $(FINAL_NET_PRICE_FIELD_XPATH).getText();
    }

    @Step("Get Availability.")
    public String getAvailability(Product product) {
        waitUntilPageIsFullyLoaded();
        return $(AVAILABILITY_FIELD_XPATH, product.getCatalogNo().toUpperCase()).getText();
    }

    @Step("Set quantity to quantity field.")
    public void setQuantityForProduct(Product product, int quantity) {
        waitUntilPageIsFullyLoaded();
        $(QUANTITY_INPUT_RELATES_TO_PRODUCT_XPATH, product.getCatalogNo().toUpperCase()).clear();
        $(QUANTITY_INPUT_RELATES_TO_PRODUCT_XPATH, product.getCatalogNo().toUpperCase()).sendKeys(Integer.toString(quantity));
    }

    @Step("Click on Update Price and Availability button.")
    public void clickOnUpdatePAButton() {
        waitUntilPageIsFullyLoaded();
        click(UPDATE_PRICE_AND_AVAILABILITY_BUTTON_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Getting final extend price for product.")
    public String getNewExtendPrice(Product product) {
        waitUntilPageIsFullyLoaded();
        return $(EXTENDED_PRICE_XPATH, product.getCatalogNo().toUpperCase()).getText();
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

    @Step("Get Claimback message below Agreement No field.")
    public String getClaimbackMessageBelowAgreementNoField() {
        waitUntilPageIsFullyLoaded();
        return $(CLAIMBACK_MESSAGE_BELOW_AGREEMENT_NO_FIELD_XPATH).getText();
    }

    @Step("Click on product link on P&A Page.")
    public void clickOnProductLinkOnPaPage(String product) {
        waitUntilPageIsFullyLoaded();
        click(PRODUCT_LINK_ON_PA_PAGE_XPATH, product);
    }

    @Step("Click On Country Of Origin Drop Down Field.")
    public String clickOnCountryOfOriginDropDownField() {
        String countryOrigin = "";
        if (isDisplayed(COUNTRY_OF_ORIGIN_DROP_DOWN_ARROW_XPATH)) {
            click(COUNTRY_OF_ORIGIN_DROP_DOWN_ARROW_XPATH);
            WebElement actualCountyOrigin = $$(COUNTRY_OF_ORIGIN_ALL_DROP_DOWN_ITEMS_XPATH).stream()
                    .findAny()
                    .orElseGet(() -> {
                        throw new NullPointerException("No such country of origin");
                    });
            countryOrigin = actualCountyOrigin.getText();
            click(actualCountyOrigin);
        } else if (isDisplayed(COUNTRY_OF_ORIGIN_SINGLE_SOURCE_VALUE_XPATH)) {
            countryOrigin = $(COUNTRY_OF_ORIGIN_SINGLE_SOURCE_VALUE_XPATH).getText();
        }
        return countryOrigin;
    }

    @Step("Is Country Of Origin Sort Column Header Displayed.")
    public boolean isCountryOfOriginSortColumnHeaderDisplayed() {
        return isDisplayed(COUNTRY_OF_ORIGIN_SORT_COLUMN_HEADER_XPATH);
    }

    @Step("Get Warning Message below catalogue no.")
    public String getWarningMessageBelowCatalogNo() {
        return $(P_AND_A_WARNING_MESSAGE_BELOW_CATALOG_NO_XPATH).getText();
    }

    @Step("Get No Data Title In Products Table.")
    public String getNoDataTitleInProductsTable() {
        return $(EMPTY_PRODUCT_TABLE_TITLE_XPATH).getText();
    }

    @Step("Get Catalog Error Message.")
    public String getCatalogErrorMessage() {
        return $(CATALOG_ERROR_MESSAGE_XPATH).getText();
    }

    @Step("Is Error Red Icon Displayed.")
    public boolean isErrorRedIconDisplayed() {
        return isDisplayed(ERROR_RED_ICON_XPATH);
    }

    @Step("Get error message below Agreement No field.")
    public String getErrorMessageBelowAgreementNoField() {
        waitUntilPageIsFullyLoaded();
        return $(ERROR_MESSAGE_BELOW_AGREEMENT_NO_FIELD_XPATH).getText();
    }

    @Step("Clean Qty Field.")
    public void cleanQtyField() {
        waitUntilPageIsFullyLoaded();
        $(QTY_FIELD_XPATH).clear();
        $(QTY_FIELD_XPATH).sendKeys(Keys.ENTER);
    }

    @Step("Get Error Message Below Qty Field.")
    public String getErrorMessageBelowQtyField() {
        waitUntilPageIsFullyLoaded();
        return $(ERROR_MESSAGE_BELOW_QUANTITY_INPUT_XPATH).getText();
    }

    @Step("Set value to the Qty field.")
    public void setQtyValue(String value) {
        $(QTY_FIELD_XPATH).sendKeys(value);
    }
}