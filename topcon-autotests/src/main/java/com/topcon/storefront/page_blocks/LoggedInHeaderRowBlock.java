package com.topcon.storefront.page_blocks;

import com.topcon.helpers.UIComponent;
import com.topcon.storefront.page_elements.LoggedInHeaderRowBlockElements;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

@Component
public class LoggedInHeaderRowBlock extends UIComponent {

    @Step("Check that user is logged in.")
    public boolean isUserLoggedIn() {
        return isDisplayed(LoggedInHeaderRowBlockElements.MY_ACCOUNT_DROP_DOWM_XPATH);
    }

    @Step("Click on sign out button.")
    public void clickOnSignOutButton() {
        $(LoggedInHeaderRowBlockElements.SIGN_OUT_BUTTON_XPATH).click();
    }

    @Step("Click on My Account menu(drop-down).")
    public void clickOnMyAccountMenu() {
        $(LoggedInHeaderRowBlockElements.MY_ACCOUNT_DROP_DOWM_XPATH).click();
    }

    @Step("Click on Address Book item in My Account drop-down.")
    public void clickOnAddressBookItemInMyAccount() {
        click(LoggedInHeaderRowBlockElements.MY_ACCOUNT_ADDRESS_BOOK_XPATH);
    }
}
