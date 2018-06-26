package com.geempower.storefront.page_blocks;

import com.geempower.helpers.UIComponent;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_block_elements.HeaderBlockElements.*;

@Component
public class HeaderBlock extends UIComponent {

    public boolean isUserLoggedIn() {
        return isDisplayed(PROFILE_DROPDOWN_XPATH);
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

    @Step("Get Line Items value")
    public int getLineItemsValue() {
        return Integer.parseInt($(LINE_ITEMS_VALUE_XPATH).getText());
    }

    @Step("Get order Value from checkout pop-up")
    public String getOrderValueFromCheckoutPopUp() {
        waitUntilPageIsFullyLoaded();
        String orderValue = $(ORDER_VALUE_XPATH).getText();
        return orderValue.substring(0, orderValue.length() - 4);
    }

    @Step("Click on Checkout button")
    public void clickOnCheckoutButton() {
        $(CHECKOUT_BUTTON_XPATH).click();
    }

    @Step("Set Product To The Search Product Field.")
    public void setProductToTheSearchProductField(String product) {
        $(PRODUCT_SEARCH_FIELD_XPATH).clear();
        $(PRODUCT_SEARCH_FIELD_XPATH).sendKeys(product);
    }

    @Step
    public void clickOnSearchProductIcon() {
        click(By.id(PRODUCT_SEARCH_ICON_ID));
    }
}
