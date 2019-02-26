package com.geempower.storefront.pages;

import com.geempower.helpers.Utils;
import com.geempower.helpers.models.Product;
import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.MyCartPageElements.*;

@Component
public class MyCartPage extends StorefrontBasePage {
    @Autowired
    private Utils utils;

    private final String pageUri = "checkout";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

    @Step("Get My Cart title.")
    public String getMyCartTitle() {
        return $(MY_CART_TITLE_XPATH).getText();
    }

    @Step("Are order step icons displayed.")
    public boolean areOrderStepIconsDisplayed() {
        return $(BUILD_ORDER_STEP_ICON_XPATH).isDisplayed() &&
                $(SHIPPING_BILLING_INFO_STEP_ICON_XPATH).isDisplayed() &&
                $(ORDER_SUMMARY_STEP_ICON_XPATH).isDisplayed();
    }

    @Step("Is build order Information input present.")
    public boolean isBuildOrderInformationInputPresent() {
        return $(BUILD_ORDER_FORM_WRAPPER_XPATH).isDisplayed() &&
                $(By.id(BUILD_ORDER_INFORMATION_INPUT_ID)).isDisplayed();
    }

    @Step("Is add item button present.")
    public boolean isAddItemButtonPresent() {
        return $(ADD_ITEM_BUTTON_XPATH).isDisplayed();
    }

    @Step("Is delete button present.")
    public boolean isDeleteItemButtonPresent() {
        return $(DELETE_ITEM_BUTTON_XPATH).isDisplayed();
    }

    @Step("Is Update P&A button displayed.")
    public boolean isUpdatePriceAndAvailabilityButtonPresent() {
        waitUntilPageIsFullyLoaded();
        return $(UPDATE_PRICE_AND_AVAILABILITY_BUTTON_XPATH).isDisplayed();
    }

    @Step("Is Next bottom button displayed.")
    public boolean isNextBottomButtonPresent() {
        waitUntilPageIsFullyLoaded();
        return $(BUILD_ORDER_BOTTOM_NEXT_BUTTON_XPATH).isDisplayed();
    }

    @Step("Is Next top button displayed.")
    public boolean isNextTopButtonPresent() {
        return $(BUILD_ORDER_TOP_NEXT_BUTTON_XPATH).isDisplayed();
    }

    @Step("Is main order data displayed on the top right.")
    public boolean isMainOrderDataDisplayedOnTheTopRight() {
        return $(MAIN_ORDER_DATA_TOP_RIGHT_XPATH).isDisplayed();
    }

    @Step("Is Save item button displayed.")
    public boolean isSaveItemsButtonPresent() {
        return $(SAVE_ITEMS_BUTTON_XPATH).isDisplayed();
    }

    @Step("Is Cancel button displayed.")
    public boolean isCancelButtonPresent() {
        return $(CANCEL_BUTTON_XPATH).isDisplayed();
    }

    @Step("Cancel the order by clicking on the Cancel button.")
    public void clickOnCancelButton() {
        click(CANCEL_BUTTON_XPATH);
        waitUntilPageIsFullyLoaded();
        click(DISCARD_ORDER_BUTTON_XPATH);
    }

    @Step("Click on the Top Next button on the My Cart page.")
    public void clickOnTheNextTopButton() {
        waitUntilPageIsFullyLoaded();
        click(BUILD_ORDER_TOP_NEXT_BUTTON_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Get Qty value.")
    public String getQtyValue(Product product) {
        return $(QTY_VALUE_INPUT_XPATH, product.getCatalogNo().toUpperCase()).getAttribute("value");
    }

    public int getQtyValue(String catalogNo) {
        return Integer.parseInt($(QTY_VALUE_INPUT_XPATH, catalogNo.toUpperCase()).getAttribute("value"));
    }

    @Step("Set Quantity value to qty. field for each product.")
    public void setQuantityForProduct(Product product, int randomQuantity) {
        waitUntilPageIsFullyLoaded();
        $(QTY_VALUE_INPUT_XPATH, product.getCatalogNo().toUpperCase()).clear();
        $(QTY_VALUE_INPUT_XPATH, product.getCatalogNo().toUpperCase()).sendKeys(Integer.toString(randomQuantity));
    }

    @Step("Select all products by clicking on All checkbox.")
    public void clickOnSelectAllCheckbox() {
        waitUntilPageIsFullyLoaded();
        click(ALL_CHECKBOXES_XPATH);
    }

    @Step("Clicking on P&A button.")
    public void clickOnUpdatePAButton() {
        $(UPDATE_PRICE_AND_AVAILABILITY_BUTTON_XPATH).click();
    }

    @Step("Getting the updated Extended price.")
    public String getNewExtendPrice(Product product) {
        waitUntilPageIsFullyLoaded();
        return $(EXTENDED_PRICE_ON_MY_CART_XPATH, product.getCatalogNo().toUpperCase()).getText();
    }

    @Step("Get Claimback Message Below Agreement No Field On My Cart Page.")
    public String getClaimbackMessageBelowAgreementNoFieldOnMyCartPage() {
        return $(CLAIMBACK_MESSAGE_BELOW_AGREEMENT_NO_FIELD_ON_MY_CART_PAGE_XPATH).getText();
    }

    @Step("Click On Product Link On My Cart Page.")
    public void clickOnProductLinkOnMyCartPage(String products) {
        waitUntilPageIsFullyLoaded();
        click(PRODUCT_LINK_ON_MY_CART_PAGE_XPATH, products);
    }

    @Step("Correct Catalog No Is Displayed On My Cart Page.")
    public String correctCatalogNoIsDisplayedOnMyCartPage() {
        return $(CATALOG_NO_ON_MY_CART_PAGE_XPATH).getText();
    }

    @Step("Get Country Of Origin Value On My Cart Page.")
    public String getCountryOfOriginValueOnMyCartPage() {
        String countryOriginMyCartPage = "";
        if (isDisplayed(COUNTRY_OF_ORIGIN_DROP_DOWN_FIELD_ON_MY_CART_PAGE_XPATH)) {
            countryOriginMyCartPage = $(COUNTRY_OF_ORIGIN_DROP_DOWN_FIELD_ON_MY_CART_PAGE_XPATH).getText();
        } else if (isDisplayed(COUNTRY_OF_ORIGIN_SINGLE_SOURCE_VALUE_ON_MY_CART_PAGE_XPATH)) {
            countryOriginMyCartPage = $(COUNTRY_OF_ORIGIN_SINGLE_SOURCE_VALUE_ON_MY_CART_PAGE_XPATH).getText();
        }
        return countryOriginMyCartPage;
    }

    @Step("Get count of products on the My Cart page.")
    public int getCountOfProducts() {
        waitUntilPageIsFullyLoaded();
        return $$(LIST_OF_PRODUCTS_XPATH).size();
    }

    @Step("Get Actual Items Count Label.")
    public String getActualItemsCountLabel() {
        waitUntilPageIsFullyLoaded();
        return $(N_ITEMS_LABEL_XPATH).getText();
    }

    @Step("Get Build Order Header.")
    public String getBuildOrderHeader() {
        return $(BUILD_ORDER_HEADER_XPATH).getText();
    }

    @Step("Get Build Order Placeholder.")
    public String getBuildOrderPlaceholder() {
        return $(By.id(BUILD_ORDER_INFORMATION_INPUT_ID)).getAttribute("placeholder");
    }

    @Step("Set Random Build Order Note.")
    public String setRandomBuildOrderNote() {
        String randomOrderNote = utils.generateUniqueTimestamp();
        enterText(randomOrderNote, By.id(BUILD_ORDER_INFORMATION_INPUT_ID));
        return randomOrderNote;
    }

    @Step("Click On Add Item Button.")
    public void clickOnAddItemButton() {
        waitUntilPageIsFullyLoaded();
        click(ADD_ITEM_BUTTON_XPATH);
    }

    @Step("Add Product To The New Item Pop-Up.")
    public void addProductToTheNewItemPopUp(String catalogNo) {
        waitUntilPageIsFullyLoaded();
        enterText(catalogNo, NEW_ITEM_POP_UP_PRODUCT_FIRST_FIELD_XPATH);
    }

    @Step("Confirm Add Item Action.")
    public void confirmAddItemAction() {
        waitUntilPageIsFullyLoaded();
        click(CONFIRM_ADD_ITEM_ACTION_BUTTON_XPATH);
    }

    @Step("Click On Save Cart Button.")
    public void clickOnSaveCartButton() {
        waitUntilPageIsFullyLoaded();
        click(SAVE_ITEMS_BUTTON_XPATH);
    }

    @Step("Get Save To Cart Pop-Up Title.")
    public String getSaveToCartPopUpTitle() {
        waitUntilPageIsFullyLoaded();
        WebDriverWait wait = new WebDriverWait(getDriver(), 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SAVE_TO_CART_POP_UP_TITLE_XPATH)));
        WebElement title = $(SAVE_TO_CART_POP_UP_TITLE_XPATH);
        return title.getText();
    }

    @Step("Set Random Cart Name To The Cart Name Input.")
    public String setRandomCartNameToTheCartNameInput() {
        String randomCartName = utils.generateUniqueTimestamp();
        waitUntilPageIsFullyLoaded();
        enterText(randomCartName, SAVE_TO_CART_POP_UP_CART_NAME_INPUT_XPATH);
        return randomCartName;
    }

    @Step("Click On Save New Cart Button.")
    public void clickOnSaveNewCartButton() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SAVE_TO_CART_POP_UP_CREATE_NEW_LIST_BUTTON_XPATH)));
        WebElement button = $(SAVE_TO_CART_POP_UP_CREATE_NEW_LIST_BUTTON_XPATH);
        button.click();
        waitUntilPageIsFullyLoaded();
    }

    @Step("Get Build Order Note Value.")
    public String getBuildOrderNoteValue() {
        waitUntilPageIsFullyLoaded();
        return $(By.id(BUILD_ORDER_INFORMATION_INPUT_ID)).getText();
    }

    @Step("Get First Product Catalog No.")
    public String getFirstProductCatalogNo() {
        return $(FIRST_PRODUCT_CATALOG_NO_XPATH).getText();
    }
}