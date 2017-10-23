package com.template.storefront.pages;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.template.storefront.models.TestProject;
import com.template.storefront.models.User;

import static com.template.storefront.page_elements.HomePageElements.*;

@Component
public class HomePage extends Page {

    @Autowired TestProject testProject;

    public void waitForPageLoad() {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf($(MY_ACCOUNT_DROPDOWN_XPATH)));
    }

    public void moveCursorToMyAccountDropDown() {
        new Actions(driver).moveToElement($(MY_ACCOUNT_DROPDOWN_XPATH)).perform();
    }

    public void waitUntilShippingAddressBookItemIsVisible() {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf($(SHIPPING_ADDRESS_BOOK_DROPDOWN_ITEM_XPATH)));
    }

    public void waitUntilSignOutItemIsVisible() {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf($(SIGN_OUT_DROPDOWN_ITEM_XPATH)));
    }

    public void clickOnShippingAddressBookItem() {
        $(SHIPPING_ADDRESS_BOOK_DROPDOWN_ITEM_XPATH).click();
    }

    public void clickOnSignOutItem() {
        $(SIGN_OUT_DROPDOWN_ITEM_XPATH).click();
    }

    public void openShippingAddressBook() {
        moveCursorToMyAccountDropDown();
        waitUntilShippingAddressBookItemIsVisible();
        clickOnShippingAddressBookItem();
    }

    public boolean isOpened() {
        return driver.getCurrentUrl().equals(testProject.getHomeUrl());
    }

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
