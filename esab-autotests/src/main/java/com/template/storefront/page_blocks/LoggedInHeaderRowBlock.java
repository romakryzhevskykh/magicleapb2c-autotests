package com.template.storefront.page_blocks;

import com.template.helpers.BasePageObject;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.template.storefront.page_elements.LoggedInHeaderRowBlockElements.MY_ACCOUNT_ADDRESS_BOOK_XPATH;
import static com.template.storefront.page_elements.LoggedInHeaderRowBlockElements.MY_ACCOUNT_DROP_DOWM_XPATH;
import static com.template.storefront.page_elements.LoggedInHeaderRowBlockElements.SIGN_OUT_BUTTON_XPATH;

@Component
public class LoggedInHeaderRowBlock extends BasePageObject {

    @Step("Check that user is logged in.")
    public boolean isUserLoggedIn() {
        return isDisplayed(MY_ACCOUNT_DROP_DOWM_XPATH);
    }

    @Step("Click on sign out button.")
    public void clickOnSignOutButton() {
        $(SIGN_OUT_BUTTON_XPATH).click();
    }

    @Step("Click on My Account menu(drop-down).")
    public void clickOnMyAccountMenu() {
        $(MY_ACCOUNT_DROP_DOWM_XPATH).click();
    }

    @Step("Click on Address Book item in My Account drop-down.")
    public void clickOnAddressBookItemInMyAccount() {
        $(MY_ACCOUNT_ADDRESS_BOOK_XPATH).click();
    }
}
