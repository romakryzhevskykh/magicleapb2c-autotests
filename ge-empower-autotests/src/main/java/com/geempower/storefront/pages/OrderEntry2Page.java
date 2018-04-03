package com.geempower.storefront.pages;

import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.OrderEntry2PageElements.*;

@Component
public class OrderEntry2Page extends StorefrontBasePage {

    private final String pageUri = "checkout";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Step("Shipping And Billing Step Title Is Displayed")
    public boolean shippingAndBillingStepTitleIsDisplayed() {
        return isDisplayed(SHIPPING_BILLING_TITLE_XPATH);
    }

    @Step("Order Details Header Is Displayed")
    public boolean orderDetailsHeaderIsDisplayed() {
        return isDisplayed(ORDER_DETAILS_HEADER_XPATH);

    }
    @Step("Job Name Field Is Displayed")
    public boolean jobNameFieldIsDisplayed() {
        return isDisplayed(By.id(JOB_NAME_FIELD_ID));
    }
    @Step("Payer Title Is Displayed")
    public boolean payerTitleIsDisplayed() {
        return isDisplayed(PAYER_TITLE_XPATH);
    }
    @Step("Shipment Address Title Is Displayed")
    public boolean shipmentAddressTitleIsDisplayed() {
        return isDisplayed(SHIPMENT_ADDRESS_TITLE_XPATH);
    }
    @Step("Address Details Header Is Displayed")
    public boolean addressDetailsHeaderIsDisplayed() {
        return isDisplayed(ADDRESS_DETAILS_HEADER_XPATH);
    }
    @Step("Manage Address Button Is Displayed")
    public boolean manageAddressButtonIsDisplayed() {
        return isDisplayed(MANAGE_ADDRESS_BUTTON_XPATH);
    }
    @Step("Shipment Details Header Is Displayed")
    public boolean shipmentDetailsHeaderIsDisplayed() {
        return isDisplayed(SHIPPING_DETAILS_HEADER_XPATH);
    }

    @Step("Shipment Payment Method Title Is Displayed")
    public boolean shipPaymentMethodTitleIsDisplayed() {
        return isDisplayed(SHIP_PAYMENT_METHOD_TITLE_XPATH);
    }
    @Step("Shipment Note Title Is Displayed")
    public boolean shippingNoteTitleIsDisplayed() {
        return isDisplayed(SHIPPING_NOTE_TITLE_XPATH);
    }
    @Step("Shipment Method Title Is Displayed")
    public boolean shipMethodTitleIsDisplayed() {
        return isDisplayed(SHIP_METHOD_TITLE_XPATH);
    }
    @Step("Requested Delivery Date Title Is Displayed")
    public boolean requestedDeliveryDateTitleIsDisplayed() {
        return isDisplayed(REQUESTED_DELIVERY_DATE_TITLE_XPATH);
    }
    @Step("Partially Delivery Title Is Displayed")
    public boolean partiallyDeliveryTitleTitleIsDisplayed() {
        return isDisplayed(PARTIAL_DELIVERY_TITLE_XPATH);
    }
    @Step("Before Delivery Date Title Is Displayed")
    public boolean requestedDeliveryTitleTitleIsDisplayed() {
        return isDisplayed(BEFORE_DELIVERY_DATE_TITLE_XPATH);
    }
}
