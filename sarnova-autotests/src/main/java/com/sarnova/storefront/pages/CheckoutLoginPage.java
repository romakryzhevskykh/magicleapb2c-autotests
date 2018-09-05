package com.sarnova.storefront.pages;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.sarnova.storefront.page_elements.CheckoutLoginPageElements.*;

@Component
public class CheckoutLoginPage extends StorefrontBasePage {
    private String pageUrlMethod = "login/checkout";
    @Autowired CheckoutPage checkoutPage;

    @Step("Fill guest email: {0}.")
    public void fillGuestEmail(String email) {
        enterText(email, By.id(GUEST_EMAIL_ID));
    }

    @Step("Fill confirm guest email: {0}.")
    public void fillConfirmGuestEmail(String email) {
        enterText(email, By.id(GUEST_CONFIRM_EMAIL_ID));
    }

    @Step("Click on confirm login button.")
    public void clickOnCheckOutAsAGuest() {
        click(CONFIRM_LOGIN_BUTTON_XPATH);
        checkoutPage.waitUntilShippingAddressPageIsLoaded();
    }

    @Step("Login as a guest with a random email.")
    public void loginAsGuestWithRandomEmail() {
        String email = org.apache.commons.lang3.RandomStringUtils.randomAlphabetic(10) + "@" + org.apache.commons.lang3.RandomStringUtils.randomAlphabetic(5) + ".com";
        fillGuestEmail(email);
        fillConfirmGuestEmail(email);
        clickOnCheckOutAsAGuest();
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }

    @Step("Click on Continue as guest.")
    public void clickOnContinueAsGuest() {
        click(CONTINUE_AS_GUEST_BUTTON_XPATH);
    }
}
