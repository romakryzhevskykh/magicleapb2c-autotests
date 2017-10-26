package com.template.storefront.pages;

import com.template.storefront.models.TestProject;
import com.template.storefront.models.User;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.template.storefront.page_elements.HomePageElements.*;

@Component
public class HomePage extends Page {

    @Autowired TestProject testProject;

    @Step("Wait until Home page is opened.")
    public void waitForPageLoad() {
        try {
            (new WebDriverWait(getDriver(), 10)).until(ExpectedConditions.visibilityOf($(MY_ACCOUNT_DROPDOWN_XPATH)));
        } catch (TimeoutException ex) {
            System.out.println("[WARNING] " + ex);
        }
    }

    @Step("Move cursor to My account drop-down menu.")
    public void moveCursorToMyAccountDropDown() {
        new Actions(getDriver()).moveToElement($(MY_ACCOUNT_DROPDOWN_XPATH)).perform();
    }

    @Step("Wait until Shipping address book drop-down menu item is visible.")
    public void waitUntilShippingAddressBookItemIsVisible() {
        (new WebDriverWait(getDriver(), 10)).until(ExpectedConditions.visibilityOf($(SHIPPING_ADDRESS_BOOK_DROPDOWN_ITEM_XPATH)));
    }

    @Step("Wait until Sign out drop-down menu item is visible.")
    public void waitUntilSignOutItemIsVisible() {
        (new WebDriverWait(getDriver(), 10)).until(ExpectedConditions.visibilityOf($(SIGN_OUT_DROPDOWN_ITEM_XPATH)));
    }

    @Step("Click on Shipping address book drop-down menu item.")
    public void clickOnShippingAddressBookItem() {
        $(SHIPPING_ADDRESS_BOOK_DROPDOWN_ITEM_XPATH).click();
    }

    @Step("Click on Sign out drop-down menu item.")
    public void clickOnSignOutItem() {
        $(SIGN_OUT_DROPDOWN_ITEM_XPATH).click();
    }

    public void openShippingAddressBook() {
        moveCursorToMyAccountDropDown();
        waitUntilShippingAddressBookItemIsVisible();
        clickOnShippingAddressBookItem();
    }

    @Step("Check that Home page is opened.")
    public boolean isOpened() {
        return getDriver().getCurrentUrl().equals(testProject.getHomeUrl());
    }

    @Step("Open Home page using home page URL.")
    public void open() {
        open(testProject.getHomeUrl());
        waitForPageLoad();
    }

    public void logout(User testUser) {
        System.out.println("LOGOUT: " + getDriver() + "  " + testUser);
        moveCursorToMyAccountDropDown();
        waitUntilSignOutItemIsVisible();
        clickOnSignOutItem();
        testUser.setLoggedIn(false);
    }
}
