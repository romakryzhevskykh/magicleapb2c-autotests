package com.sarnova.storefront.page_blocks;

import com.sarnova.helpers.BasePageObject;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.sarnova.storefront.page_elements.LoggedOutHeaderRowBlockElements.*;

@Component
public class LoggedOutHeaderRowBlock extends BasePageObject {

    @Step("Click on Sign in button.")
    public void clickOnSignInButton() {
        $(SIGN_IN_BUTTON_XPATH).click();
    }

    @Step("Check that user is logged out.")
    public boolean isUserLoggedOut() {
        return isDisplayed($(SIGN_IN_BUTTON_XPATH));
    }
}
