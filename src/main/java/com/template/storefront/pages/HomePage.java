package com.template.storefront.pages;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.template.storefront.models.TestProject;
import com.template.storefront.models.User;
import ru.yandex.qatools.allure.annotations.Step;

import static com.template.storefront.page_elements.HomePageElements.*;

@Component
public class HomePage extends Page {

    @Autowired TestProject testProject;

    @Step("Wait until Home page is opened.")
    public void waitForPageLoad() {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf($(MY_ACCOUNT_DROPDOWN_XPATH)));
    }

    @Step("Move cursor to My account drop-down menu.")
    public void moveCursorToMyAccountDropDown() {
        new Actions(driver).moveToElement($(MY_ACCOUNT_DROPDOWN_XPATH)).perform();
    }

    @Step("Wait until Shipping address book drop-down menu item is visible.")
    public void waitUntilShippingAddressBookItemIsVisible() {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf($(SHIPPING_ADDRESS_BOOK_DROPDOWN_ITEM_XPATH)));
    }

    @Step("Wait until Sign out drop-down menu item is visible.")
    public void waitUntilSignOutItemIsVisible() {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf($(SIGN_OUT_DROPDOWN_ITEM_XPATH)));
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
        return driver.getCurrentUrl().equals(testProject.getHomeUrl());
    }

    @Step("Open Home page using home page URL.")
    public void open() {
        open(testProject.getHomeUrl());
    }

    public void logout(User testUser) {
        moveCursorToMyAccountDropDown();
        waitUntilSignOutItemIsVisible();
        clickOnSignOutItem();
        testUser.setLoggedIn(false);
    }
}
