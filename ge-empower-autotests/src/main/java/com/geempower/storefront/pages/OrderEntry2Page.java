package com.geempower.storefront.pages;

import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.time.LocalDateTime;
import java.time.ZoneId;

import static com.geempower.storefront.page_elements.OrderEntry2PageElements.*;

@Component
public class OrderEntry2Page extends StorefrontBasePage {

    private final String pageUri = "checkout";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Step("Click on the bottom Next button on the second Order entry page.")
    public void clickOnTheNextBottomButton() {
        $(SHIPPING_BILLING_BOTTOM_NEXT_BUTTON_XPATH).click();
    }

    @Step("User fills unique Po No on the second Order entry page.")
    public String fillUniquePoNo() {
        waitUntilPageIsFullyLoaded();
        String uniquePoNo = Long.toString(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().getEpochSecond());
        $(By.id(PO_NO_FIELD_ID)).clear();
        $(By.id(PO_NO_FIELD_ID)).sendKeys(uniquePoNo);
        return uniquePoNo;
    }

    @Step("User chooses first shipping address from the addresses list on the second Order entry page.")
    public String chooseAppropriateAddressFromTheShippingAddressList(){
        waitUntilPageIsFullyLoaded();
        $(SHIPPING_ADDRESS_LIST_OPEN_XPATH).click();
        Select addressDropdown = new Select($(SHIPPING_ADDRESS_DROPDOWN_XPATH));
        addressDropdown.selectByIndex(1);
        return addressDropdown.getOptions().get(1).getText();
    }

    @Step("Getting the value from Ship To field on the second Order entry page.")
    public String getShipToValue() {
        return $(SHIP_TO_FIELD_VALUE_XPATH).getText();
    }

    @Step("Getting the Catalog No. from the Product details block.")
    public String getCatalogNoFromTheProductDetailsBlock() {
        waitUntilPageIsFullyLoaded();
        return $(PRODUCT_DETAILS_BLOCK_CATALOG_NO_XPATH).getText();
    }

    @Step("Getting the Description from the Product details block.")
    public String getDescriptionFromTheProductDetailsBlock() {
        return $(PRODUCT_DETAILS_BLOCK_DESCRIPTION_XPATH).getText();
    }

    @Step("Getting the Quantity of product from the Product details block.")
    public int getQuantityFromTheProductDetailsBlock() {
        return Integer.parseInt($(PRODUCT_DETAILS_BLOCK_QUANTITY_XPATH).getText());
    }

    @Step("Getting the Extended price from the Product details block.")
    public double getExtendedPriceFromTheProductDetailsBlock() {
        return Double.parseDouble($(PRODUCT_DETAILS_BLOCK_EXTENDED_PRICE_XPATH).getText());
    }

    @Step("Getting the Currency from the Product details block.")
    public String getCurrencyFromTheProductDetailsBlock() {
        return $(PRODUCT_DETAILS_BLOCK_CURRENCY_XPATH).getText();
    }

    @Step("Getting the Est delivery date from the Product details block.")
    public String getEstDeliveryDateFromTheProductDetailsBlock() {
        return $(PRODUCT_DETAILS_BLOCK_EST_DELIVERY_DATE_XPATH).getText();
    }

    @Step("Getting the Req delivery date from the Product details block.")
    public String getReqDeliveryDateFromTheProductDetailsBlock() {
        return $(PRODUCT_DETAILS_BLOCK_REQ_DELIVERY_DATE_XPATH).getAttribute("value");
    }

}
