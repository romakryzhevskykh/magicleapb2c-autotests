package com.topcon.storefront.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.stream.Collectors;

import static com.topcon.storefront.page_elements.CheckoutPageElements.PRODUCTS_IDS_XPATH;
import static com.topcon.storefront.page_elements.CheckoutPageElements.*;

@Component
public class CheckoutPage extends StorefrontBasePage {

    private final String pageUrlMethod = "topcon/en/USD/checkout";

    public List<String> getAllAddedProductsIds() {
        return $$(PRODUCTS_IDS_XPATH).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean successMessageAppeared() {
        return isShown();
    }
    public boolean isShown(){
        return isDisplayed(SUCCESS_ORDER_MESSAGE_XPATH);
    }


    @Step("Set the P.O number.")
    public void fillPONumberFieldWith(String ponumber) {
        $(PO_FIELD_XPATH).clear();
        $(PO_FIELD_XPATH).sendKeys(ponumber);
    }

    public void fillPONumberField(String poNumber) {
        fillPONumberFieldWith(poNumber);
    }

    @Step("Click the Next button")
    public void clickTheNextButton() {
        click(NEXT_PAYMENT_BUTTON_XPATH);
    }

    @Step("Click the Ship To Accounts button")
    public void clickTheShipToAccountsButton(){
        click(SHIP_TO_ACCOUNTS_BUTTON_XPATH);
    }

    @Step("Click the first Use this Address button")
    public void clickTheFirstUseThisAddressButton(){
        click(FIRST_USE_THIS_ADDRESS_BUTTON_XPATH);
    }

    @Step("Choose the First Shipment Method in the Shipping Method section")
    public void chooseTheFirstShippingMethodInTheShippingMethodSection() {
        Select select = new Select($(SHIPPING_METHOD_DROPDOWN_XPATH));
        select.selectByIndex(1);
    }

    @Step("Choose the First Shipping Carrier in the Shipping Carrier section")
    public void chooseTheFirstShippingCarrierInTheShippingCarrierSection(){
        Select select = new Select($(SHIPPING_CARRIER_DROPDOWN_XPATH));
        select.selectByIndex(1);
    }

    @Step("Click the Next button in the Shipping Method section")
    public void clickTheNextButtonInTheShippingMethodSection(){
        click(NEXT_SHIPPING_METHOD_BUTTON_XPATH);
    }

    @Step("Click the confirmation Terms of Use checkbox")
    public void clickTheConfirmationTermsOfUseCheckbox(){
        click(TERMS_OF_USE_CHECKBOX_XPATH);
    }

    @Step("Click the Place Order button")
    public void clickThePlaceOrderButton(){
        click(PLACE_ORDER_BUTTON_XPATH);
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}