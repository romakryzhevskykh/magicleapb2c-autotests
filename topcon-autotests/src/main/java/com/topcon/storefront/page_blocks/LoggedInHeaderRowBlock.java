package com.topcon.storefront.page_blocks;

import com.topcon.helpers.UIComponent;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.topcon.storefront.page_elements.LoggedInHeaderRowBlockElements.*;

@Component
public class LoggedInHeaderRowBlock extends UIComponent {

    @Step("Check that user is logged in.")
    public boolean isUserLoggedIn() {
        return isDisplayed(MY_ACCOUNT_DROP_DOWM_XPATH);
    }

    @Step("Click on sign out button.")
    public void clickOnSignOutButton() {
        click(SIGN_OUT_BUTTON_XPATH);
    }

    @Step("Click on My Account menu(drop-down).")
    public void clickOnMyAccountMenu() {
        click(MY_ACCOUNT_DROP_DOWM_XPATH);
    }

    @Step("Click on Address Book item in My Account drop-down.")
    public void clickOnAddressBookItemInMyAccount() {
        click(MY_ACCOUNT_ADDRESS_BOOK_XPATH);
    }
}
