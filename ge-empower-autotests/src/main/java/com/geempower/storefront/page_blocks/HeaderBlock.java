package com.geempower.storefront.page_blocks;

import com.geempower.helpers.UIComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_block_elements.HeaderBlockElements.*;

@Component
public class HeaderBlock extends UIComponent {

    public boolean isUserLoggedIn() {
        return isDisplayed(PROFILE_DROPDOWN_XPATH);
    }

    @Step("Check that cart count icon is displayed.")
    public boolean counterIconIsDisplayed() {
        waitUntilPageIsFullyLoaded();
        return isDisplayed(CART_COUNT_ICON_XPATH);
    }

    @Step("Click on My Cart button.")
    public void clickOnMyCartIcon() {
        try {
            waitForElementToDisappear(By.id(GREEN_CONFIRMATION_POP_UP_ID));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        click(CART_ICON_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Get Line Items value.")
    public int getLineItemsValue() {
        return Integer.parseInt($(LINE_ITEMS_VALUE_XPATH).getText());
    }

    @Step("Get order Value from checkout pop-up.")
    public String getOrderValueFromCheckoutPopUp() {
        waitUntilPageIsFullyLoaded();
        String orderValue = $(ORDER_VALUE_XPATH).getText();
        return orderValue.substring(0, orderValue.length() - 4);
    }

    @Step("Click on Checkout button.")
    public void clickOnCheckoutButton() {
        click(CHECKOUT_BUTTON_XPATH);
    }

    @Step("Set Product To The Search Product Field.")
    public void setProductToTheSearchProductField(String product) {
        $(PRODUCT_SEARCH_FIELD_XPATH).clear();
        $(PRODUCT_SEARCH_FIELD_XPATH).sendKeys(product);
    }

    @Step("Click On Search Product Icon.")
    public void clickOnSearchProductIcon() {
        click(By.id(PRODUCT_SEARCH_ICON_ID));
    }

    @Step("Is appropriate section available to user.")
    public boolean isSectionAvailableToUser(String sectionName) {
        return isDisplayed(MENU_SECTION_XPATH, sectionName);
    }

    @Step("Is Post Sales Section Available To User.")
    public boolean isPostSalesSectionAvailableToUser() {
        waitUntilPageIsFullyLoaded();
        return isDisplayed(POST_SALES_SECTION_XPATH);
    }

    @Step("Is Returns Section Available To User.")
    public boolean isReturnsSectionAvailableToUser() {
        if (isDisplayed(POST_SALES_SECTION_XPATH)) {
            click(EXPAND_POST_SALES_SECTION_XPATH);
            waitUntilPageIsFullyLoaded();
        }
        return isDisplayed(RETURNS_SECTION_XPATH);
    }

    @Step("Is Rebates Section Available To User.")
    public boolean isRebatesSectionAvailableToUser() {
        if (isDisplayed(POST_SALES_SECTION_XPATH)) {
            click(EXPAND_POST_SALES_SECTION_XPATH);
            waitUntilPageIsFullyLoaded();
        }
        return isDisplayed(REBATES_SECTION_XPATH);
    }

    @Step("Click on Header Section by section name.")
    public void clickOnAppropriateSection(String sectionName) {
        click(MENU_SECTION_XPATH, sectionName);
    }
}