package com.geempower.storefront.pages.order;

import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.order.OrderEntry3PageElements.*;

@Component
public class OrderEntry3Page extends StorefrontBasePage {

    private final String pageUri = "checkout";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Step("Check that third step of order creation is opened.")
    public boolean isOrderSummaryStepOpened() {
        waitUntilPageIsFullyLoaded();
        return $(ORDER_SUMMARY_STEP_TITLE_XPATH).isDisplayed();
    }

    @Step("Check that Po No. is equal to chosen Po No.")
    public String getPoNoFromOrderSummary() {
        return $(PO_NUMBER_SUMMARY_XPATH).getText();
    }

    @Step("User clicks on Place order button on the third order entry page.")
    public void clickOnThePlaceOrderButton() {
        waitUntilPageIsFullyLoaded();
        JavascriptExecutor je = (JavascriptExecutor) getDriver();
        WebElement element = $(PLACE_ORDER_BOTTOM_BUTTON_XPATH);
        je.executeScript("arguments[0].scrollIntoView(true);", element);
        $(PLACE_ORDER_BOTTOM_BUTTON_XPATH).click();
    }

    @Step("User submit the Confirmation pop-up.")
    public void submitTermsAndConditions() {
        waitUntilPageIsFullyLoaded();
        $(TERMS_AND_CONDITIONS_CHECKBOX_XPATH).click();
        $(SUBMIT_ORDER_BUTTON_IN_TERMS_POP_UP_XPATH).click();
    }

    @Step("Getting the GE order No. from the 'order successful' pop-up.")
    public String getGEOrderNoFromOrderSuccessPopUp(String title) {
        waitForElementWithAppropriateTextToAppear(By.xpath(ORDER_CONFIRMATION_POP_UP_TITLE_XPATH), title);
        return $(GE_ORDER_NUMBER_ON_THE_CONFIRMATION_POP_UP_XPATH).getText();
    }

    @Step("User close the Confirmation pop-up.")
    public void closeOrderConfirmationPopUp() {
        $(CLOSE_ORDER_CONFIRMATION_POP_UP_XPATH).click();
        waitUntilPageIsFullyLoaded();
    }

    @Step("Getting the Catalog No. from the product details block.")
    public String getCatalogNoFromTheProductDetailsBlock() {
        waitUntilPageIsFullyLoaded();
        return $(PRODUCT_DETAILS_BLOCK_CATALOG_NO_XPATH).getText();
    }

    @Step("Getting the Description from the product details block.")
    public String getDescriptionFromTheProductDetailsBlock() {
        return $(PRODUCT_DETAILS_BLOCK_DESCRIPTION_XPATH).getText();
    }

    @Step("Getting the Quantity of product from the product details block.")
    public int getQuantityFromTheProductDetailsBlock() {
        return Integer.parseInt($(PRODUCT_DETAILS_BLOCK_QUANTITY_XPATH).getText());
    }

    @Step("Getting the Extended price from the product details block.")
    public double getExtendedPriceFromTheProductDetailsBlock() {
        return Double.parseDouble($(PRODUCT_DETAILS_BLOCK_EXTENDED_PRICE_XPATH).getText());
    }

    @Step("Getting the Currency from the product details block.")
    public String getCurrencyFromTheProductDetailsBlock() {
        return $(PRODUCT_DETAILS_BLOCK_CURRENCY_XPATH).getText();
    }

    @Step("Getting the Est delivery date from the product details block.")
    public String getEstDeliveryDateFromTheProductDetailsBlock() {
        return $(PRODUCT_DETAILS_BLOCK_EST_DELIVERY_DATE_XPATH).getText();
    }

    @Step("Getting the Req delivery date from the product details block.")
    public String getReqDeliveryDateFromTheProductDetailsBlock() {
        return $(PRODUCT_DETAILS_BLOCK_REQ_DELIVERY_DATE_XPATH).getText();
    }

    @Step("Check that address detail header is displayed on the OE 3 page.")
    public boolean addressDetailsHeaderIsDisplayed() {
        return isDisplayed(ADDRESS_DETAILS_HEADER_XPATH);
    }

    @Step("Check that shipment address title is displayed on the OE 3 page.")
    public boolean shipmentAddressTitleIsDisplayed() {
        return isDisplayed(SHIPMENT_ADDRESS_TITLE_XPATH);
    }

    @Step("Getting the Shipment address from the Shipment details block on the OE 3 page.")
    public String getShipmentAddressData() {
        return $(SHIPMENT_ADDRESS_DATA_XPATH).getText();
    }

    @Step("Check that shipment details header is displayed on the OE 3 page.")
    public boolean shipmentDetailsHeaderIsDisplayed() {
        return isDisplayed(SHIPPING_DETAILS_HEADER_XPATH);
    }

    @Step("Check that shipment payment method is displayed on the OE 3 page.")
    public boolean shipPaymentMethodTitleIsDisplayed() {
        return isDisplayed(SHIP_PAYMENT_METHOD_TITLE_XPATH);
    }

    @Step("Check that shipping note is displayed on the OE 3 page.")
    public boolean shippingNoteTitleIsDisplayed() {
        return isDisplayed(SHIPPING_NOTE_TITLE_XPATH);
    }

    @Step("Check that shipping method is displayed on the OE 3 page.")
    public boolean shipMethodTitleIsDisplayed() {
        return isDisplayed(SHIP_METHOD_TITLE_XPATH);
    }

    @Step("Check that Requested delivery date is displayed on the OE 3 page.")
    public boolean requestedDeliveryDateTitleIsDisplayed() {
        return isDisplayed(REQUESTED_DELIVERY_DATE_TITLE_XPATH);
    }

    @Step("Check that Partially shipment accepted is displayed on the OE 3 page.")
    public boolean partiallyShipmentAcceptedTitleIsDisplayed() {
        return isDisplayed(PARTIAL_SHIPMENT_ACCEPTED_TITLE_XPATH);
    }

    @Step("Check that Accept early delivery is displayed on the OE 3 page.")
    public boolean acceptEarlyDeliveryTitleIsDisplayed() {
        return isDisplayed(ACCEPT_EARLY_DELIVERY_TITLE_XPATH);
    }

    @Step("Check that order summary is displayed on the OE 3 page.")
    public boolean orderSummaryTitleIsDisplayed() {
        return isDisplayed(ORDER_SUMMARY_TITLE_XPATH);
    }

    @Step("Check that order note is displayed on the OE 3 page.")
    public boolean orderNoteTitleIsDisplayed() {
        return isDisplayed(ORDER_NOTE_TITLE_XPATH);
    }

    @Step("Check that PO No. is displayed on the OE 3 page.")
    public boolean poNoTitleIsDisplayed() {
        return isDisplayed(PO_NO_TITLE_XPATH);
    }

    @Step("Check that Job name is displayed on the OE 3 page.")
    public boolean jobNameTitleIsDisplayed() {
        return isDisplayed(JOB_NAME_TITLE_XPATH);
    }

    @Step("Check that Payer is displayed on the OE 3 page.")
    public boolean payerTitleIsDisplayed() {
        return isDisplayed(PAYER_TITLE_XPATH);
    }

    @Step("Check that Payer info is not empty on the OE 3 page.")
    public boolean payerInfoIsEmpty() {
        return $(PAYER_DATA_XPATH).getText().isEmpty();
    }

    @Step("Getting Payer Address on the OE 3 page.")
    public String getPayerAddress() {
        return $(PAYER_BLOCK_VALUE_XPATH).getText();
    }

    @Step("Getting Shipment Address on the OE 3 page.")
    public String getShipmentAddress() {
        return $(SHIPPING_ADDRESS_BLOCK_VALUE_XPATH).getText();
    }

    @Step("Get Claimback Message In Blue Block on 3 OE page.")
    public String getClaimbackMessageInBlueBlockOnOE3Page() {
        return $(CLAIMBACK_MESSAGE_IN_BLUE_BLOCK__3_OE_PAGE_XPATH).getText();
    }

    @Step("Is Claimback Icon In Extnd Price Cell OE 3 page Displayed.")
    public boolean isClaimbackIconInExtndPriceCellOE3PageDisplayed() {
        waitUntilPageIsFullyLoaded();
        return isDisplayed(CLAIMBACK_ICON_IN_EXTND_PRICE_CELL_3_OE_PAGE_XPATH);
    }

    @Step("Click on Product Link on OE 3 Page.")
    public void clickOnProductLinkOnOE3Page(String products) {
        waitUntilPageIsFullyLoaded();
        click(PRODUCT_LINK_3_OE_PAGE_XPATH, products);
    }

}
