package com.sarnova.storefront.page_blocks;

import com.sarnova.helpers.BasePageObject;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.sarnova.storefront.page_elements.LoggedInHeaderRowBlockElements.MY_ACCOUNT_DROP_DOWM_XPATH;
import static com.sarnova.storefront.page_elements.LoggedInHeaderRowBlockElements.SIGN_OUT_BUTTON_XPATH;

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
}
