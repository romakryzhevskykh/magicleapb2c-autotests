package com.sarnova.storefront.page_blocks;

import com.sarnova.helpers.UIComponent;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.sarnova.storefront.page_block_elements.CheckoutPaymentMethodStepBlockElements.*;

@Component
public class CheckoutPaymentMethodStepBlock extends UIComponent {

    private String pageUrlMethod = "multi/payment-method/add";

    @Step("Click on Next button on Checkout Payment method step.")
    public void clickOnNextButton() {
        click(By.id(NEXT_BUTTON_ID));
    }

    @Step("Select Card payment type on Checkout Payment method step.")
    public void selectCardPaymentType() {
        click(By.id(CARD_PAYMENT_CHECKBOX_ID));
    }

    @Step("Is Card payment type checkbox visible?")
    public boolean isCardPaymentTypeVisible() {
        return isDisplayed(By.id(CARD_PAYMENT_CHECKBOX_ID));
    }

    @Step("Select Invoice payment type on Checkout Payment method step.")
    public void selectInvoicePaymentType() {
        click(By.id(INVOICE_PAYMENT_CHECKBOX_ID));
    }

    @Step("Is Invoice payment type checkbox visible?")
    public boolean isInvoicePaymentTypeVisible() {
        return isDisplayed(By.id(INVOICE_PAYMENT_CHECKBOX_ID));
    }

    @Step("Is Card number text field visible?")
    public boolean isCardNumberTextFieldVisible() {
        return isDisplayed(By.id(CARD_ACCOUNT_NUMBER_FIELD_ID));
    }

    @Step("Is Expire month drop-down visible?")
    public boolean isExpireMonthDropDownVisible() {
        return isDisplayed(By.id(CARD_EXPIRY_MONTH_DROP_DOWN_ID));
    }

    @Step("Is Expire year drop-down visible?")
    public boolean isExpireYearDropDownVisible() {
        return isDisplayed(By.id(CARD_EXPIRY_YEAR_DROP_DOWN_ID));
    }

    @Step("Is Name on card text field visible?")
    public boolean isNameOnCardTextFieldVisible() {
        return isDisplayed(By.id(CARD_NAME_ON_CARD_FIELD_ID));
    }

    @Step("Is Card CVV code text field visible?")
    public boolean isCVVCodeTextFieldVisible() {
        return isDisplayed(By.id(CARD_CVV_CODE_FIELD_ID));
    }

    @Step("Is Save card checkbox visible?")
    public boolean isSaveCardCheckboxVisible() {
        return isDisplayed(By.id(CARD_SAVE_PAYMENT_METHOD_CHECKBOX_ID));
    }

    @Step("Is Purchase order number text field visible?")
    public boolean isPurchaseOrderNumberFieldVisible() {
        return isDisplayed(By.id(PURCHASE_ORDER_NUMBER_FIELD_ID));
    }

    @Step("Is Comment text field visible?")
    public boolean isCommentFieldVisible() {
        return isDisplayed(By.id(COMMENT_FIELD_ID));
    }

    @Step("Fill Purchase order number text field with text {0}.")
    public void fillPONWithText(String randomPON) {
        $(By.id(PURCHASE_ORDER_NUMBER_FIELD_ID)).clear();
        $(By.id(PURCHASE_ORDER_NUMBER_FIELD_ID)).sendKeys(randomPON);
    }

    public String getPageUrlMethod() {
        return pageUrlMethod;
    }
}
