package com.magicleap.storefront.page_blocks;

import com.magicleap.helpers.UIComponent;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.magicleap.storefront.page_block_elements.LoggedInHeaderRowBlockElements.*;

@Component
public class LoggedInHeaderRowBlock extends UIComponent {

    @Step("Check that user is logged in.")
    public boolean isUserLoggedIn() {
        return isDisplayed(MY_ACCOUNT_DROP_DOWN_XPATH);
    }

    @Step("Click on sign out button.")
    public void clickOnSignOutButton() {
        $(SIGN_OUT_BUTTON_XPATH).click();
    }

    @Step("Click on My Account menu(drop-down).")
    public void clickOnMyAccountMenu() {
        $(MY_ACCOUNT_DROP_DOWN_XPATH).click();
    }

    @Step("Hover on User Account icon.")
    public void hoverOnUserAccountMenu(){
        mouseover(MY_ACCOUNT_DROP_DOWN_XPATH);
    }

    @Step("Click on Address Book item in My Account drop-down.")
    public void clickOnAddressBookItemInMyAccount() {
        click(MY_ACCOUNT_ADDRESS_BOOK_XPATH);
    }

    public void clickOnAccountSettingsItemInMyAccount() {
        click(MY_ACCOUNT_SETTINGS_XPATH);
    }
}
