package com.geempower.storefront.pages.order;

import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.time.LocalDateTime;
import java.time.ZoneId;

import static com.geempower.storefront.page_elements.order.OrderEntry2PageElements.*;

@Component
public class OrderEntry2Page extends StorefrontBasePage {

    private final String pageUri = "checkout";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Step("Click on the bottom Next button on the second OE 2 page.")
    public void clickOnTheNextBottomButton() {
        waitUntilPageIsFullyLoaded();
        $(SHIPPING_BILLING_BOTTOM_NEXT_BUTTON_XPATH).click();
        waitUntilPageIsFullyLoaded();
        if (isDisplayed(MINIMUM_SHIPMENT_CHARGES_EMEA_MODAL_XPATH)) {
            click(CONTINUE_EMEA_BUTTON_XPATH);
        }
        if (isDisplayed(MINIMUM_SHIPMENT_CHARGES_NA_MODAL_XPATH)) {
            click(CONTINUE_NA_BUTTON_XPATH);
        }
        waitUntilPageIsFullyLoaded();
    }

    @Step("User fills unique Po No on the OE 2 page.")
    public String fillUniquePoNo() {
        waitUntilPageIsFullyLoaded();
        String uniquePoNo = Long.toString(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().getEpochSecond());
        $(By.id(PO_NO_FIELD_ID)).clear();
        $(By.id(PO_NO_FIELD_ID)).sendKeys(uniquePoNo);
        return uniquePoNo;
    }

    @Step("User chooses first shipping address from the addresses list on the OE 2 page.")
    public String chooseAppropriateAddressFromTheShippingAddressList() {
        waitUntilPageIsFullyLoaded();
        $(SHIPPING_ADDRESS_LIST_OPEN_XPATH).click();
        Select addressDropdown = new Select($(SHIPPING_ADDRESS_DROPDOWN_XPATH));
        addressDropdown.selectByIndex(1);
        return addressDropdown.getOptions().get(1).getText();
    }

    @Step("Getting the value from Ship To field on the OE 2 page.")
    public String getShipToValue() {
        return $(SHIP_TO_FIELD_VALUE_XPATH).getText();
    }

    @Step("Getting the Catalog No. from the product details block on the OE 2 page.")
    public String getCatalogNoFromTheProductDetailsBlock() {
        waitUntilPageIsFullyLoaded();
        return $(PRODUCT_DETAILS_BLOCK_CATALOG_NO_XPATH).getText();
    }

    @Step("Getting the Description from the product details block on the OE 2 page.")
    public String getDescriptionFromTheProductDetailsBlock() {
        return $(PRODUCT_DETAILS_BLOCK_DESCRIPTION_XPATH).getText();
    }

    @Step("Getting the Quantity of product from the product details block on the OE 2 page.")
    public int getQuantityFromTheProductDetailsBlock() {
        return Integer.parseInt($(PRODUCT_DETAILS_BLOCK_QUANTITY_XPATH).getText());
    }

    @Step("Getting the Extended price from the product details block on the OE 2 page.")
    public double getExtendedPriceFromTheProductDetailsBlock() {
        return Double.parseDouble($(PRODUCT_DETAILS_BLOCK_EXTENDED_PRICE_XPATH).getText());
    }

    @Step("Getting the Currency from the product details block on the OE 2 page.")
    public String getCurrencyFromTheProductDetailsBlock() {
        return $(PRODUCT_DETAILS_BLOCK_CURRENCY_XPATH).getText();
    }

    @Step("Getting the Est delivery date from the product details block on the OE 2 page.")
    public String getEstDeliveryDateFromTheProductDetailsBlock() {
        return $(PRODUCT_DETAILS_BLOCK_EST_DELIVERY_DATE_XPATH).getText();
    }

    @Step("Getting the Req delivery date from the product details block on the OE 2 page.")
    public String getReqDeliveryDateFromTheProductDetailsBlock() {
        return $(PRODUCT_DETAILS_BLOCK_REQ_DELIVERY_DATE_XPATH).getAttribute("value");
    }

    @Step("Shipping And Billing Step Title Is Displayed on the OE 2 page.")
    public boolean shippingAndBillingStepTitleIsDisplayed() {
        waitForElementToDisappear(By.xpath(SHIPPING_BILLING_TITLE_XPATH));
        return isDisplayed(SHIPPING_BILLING_TITLE_XPATH);
    }

    @Step("order Details Header Is Displayed on the OE 2 page.")
    public boolean orderDetailsHeaderIsDisplayed() {
        waitUntilPageIsFullyLoaded();
        return isDisplayed(ORDER_DETAILS_HEADER_XPATH);
    }

    @Step("Job Name Field Is Displayed on the OE 2 page.")
    public boolean jobNameFieldIsDisplayed() {
        return isDisplayed(By.id(JOB_NAME_FIELD_ID));
    }

    @Step("Payer Title Is Displayed on the OE 2 page.")
    public boolean payerTitleIsDisplayed() {
        return isDisplayed(PAYER_TITLE_XPATH);
    }

    @Step("Shipment Address Title Is Displayed on the OE 2 page.")
    public boolean shipmentAddressTitleIsDisplayed() {
        return isDisplayed(SHIPMENT_ADDRESS_TITLE_XPATH);
    }

    @Step("Address Details Header Is Displayed on the OE 2 page.")
    public boolean addressDetailsHeaderIsDisplayed() {
        return isDisplayed(ADDRESS_DETAILS_HEADER_XPATH);
    }

    @Step("Manage Address Button Is Displayed on the OE 2 page.")
    public boolean manageAddressButtonIsDisplayed() {
        return isDisplayed(MANAGE_ADDRESS_BUTTON_XPATH);
    }

    @Step("Shipment Details Header Is Displayed on the OE 2 page.")
    public boolean shipmentDetailsHeaderIsDisplayed() {
        return isDisplayed(SHIPPING_DETAILS_HEADER_XPATH);
    }

    @Step("Shipment Payment Method Title Is Displayed on the OE 2 page.")
    public boolean shipPaymentMethodTitleIsDisplayed() {
        return isDisplayed(SHIP_PAYMENT_METHOD_TITLE_XPATH);
    }

    @Step("Shipment Note Title Is Displayed on the OE 2 page.")
    public boolean shippingNoteTitleIsDisplayed() {
        return isDisplayed(SHIPPING_NOTE_TITLE_XPATH);
    }

    @Step("Shipment Method Title Is Displayed on the OE 2 page.")
    public boolean shipMethodTitleIsDisplayed() {
        return isDisplayed(SHIP_METHOD_TITLE_XPATH);
    }

    @Step("Requested Delivery Date Title Is Displayed on the OE 2 page.")
    public boolean requestedDeliveryDateTitleIsDisplayed() {
        return isDisplayed(REQUESTED_DELIVERY_DATE_TITLE_XPATH);
    }

    @Step("Partially Delivery Title Is Displayed on the OE 2 page.")
    public boolean partiallyDeliveryTitleTitleIsDisplayed() {
        return isDisplayed(PARTIAL_DELIVERY_TITLE_XPATH);
    }

    @Step("Before Delivery Date Title Is Displayed on the OE 2 page.")
    public boolean requestedDeliveryTitleTitleIsDisplayed() {
        return isDisplayed(BEFORE_DELIVERY_DATE_TITLE_XPATH);
    }

    @Step("Getting Payer Address on the OE 2 page.")
    public String getPayerAddress() {
        return $(PAYER_BLOCK_VALUE_XPATH).getText();
    }

    @Step("Getting Shipment Address on the OE 2 page.")
    public String getShipmentAddress() {
        return $(SHIPPING_ADDRESS_BLOCK_VALUE_XPATH).getText();
    }

    @Step("Selects Carrier from drop-down at the OE 2 page.")
    public void selectCarrierFromDropDown() {
        click(CARRIER_FIELD_XPATH);
        click(CARRIER_FIRST_DROP_DOWN_ITEM_XPATH);
    }

    @Step("Fill Carrier Accont No.")
    public void fillCarrierAccountNo() {
        String uniqueCarrierAccountNo = Long.toString(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().getEpochSecond());
        $(By.id(CARRIER_ACCOUNT_NO_FIELD_ID)).sendKeys(uniqueCarrierAccountNo);
    }

    @Step("Click on Add More Items Button.")
    public void clickOnAddMoreItemsButton() {
        click(ADD_MORE_ITEMS_BUTTON_XPATH);
    }

    @Step("Get Claimback Message In Blue Block on 2 OE page.")
    public String getClaimbackMessageInBlueBlockOn2OEPage() {
        return $(CLAIMBACK_MESSAGE_IN_BLUE_BLOCK_XPATH).getText();
    }

    @Step("Is Claimback Icon In Extnd Price Cell OE 2 Page Displayed.")
    public boolean isClaimbackIconInExtndPriceCellOE2PageDisplayed() {
        return isDisplayed(CLAIMBACK_ICON_IN_EXTND_PRICE_CELL_2_OE_PAGE_XPATH);
    }

    @Step("Click on Product Link on OE 2 Page.")
    public void clickOnProductLinkOnOE2Page(String products) {
        waitUntilPageIsFullyLoaded();
        click(PRODUCT_LINK_2_OE_PAGE_XPATH, products);
    }
}
