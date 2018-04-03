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

    public boolean orderDetailsHeaderIsDisplayed() {
        return $(ORDER_DETAILS_HEADER_XPATH).isDisplayed() &&
                $(ORDER_DETAILS_HEADER_XPATH).getText().equals("Order Details");
    }

    public boolean jobNameFieldIsDisplayed() {
        return $(By.id(JOB_NAME_FIELD_ID)).isDisplayed();
    }

    public boolean payerFieldIsDisplayed() {
        return $(PAYER_BLOCK_XPATH).isDisplayed();
    }

    public boolean shipmentAddressTitleIsDisplayed() {
        return $(SHIPMENT_ADDRESS_HEADER_XPATH).isDisplayed() &&
                $(SHIPMENT_ADDRESS_HEADER_XPATH).getText().equals("Shipment Address");
    }

    public boolean addressDetailsHeaderIsDisplayed() {
        return $(ADDRESS_DETAILS_HEADER_XPATH).isDisplayed() &&
                $(ADDRESS_DETAILS_HEADER_XPATH).getText().equals("Address Details");
    }

    public boolean manageAddressButtonIsDisplayed() {
        return $(MANAGE_ADDRESS_BUTTON_XPATH).isDisplayed();
    }
}
