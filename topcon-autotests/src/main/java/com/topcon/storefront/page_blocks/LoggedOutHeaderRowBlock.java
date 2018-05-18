package com.topcon.storefront.page_blocks;

import com.topcon.helpers.UIComponent;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.topcon.storefront.page_elements.LoggedOutHeaderRowBlockElements.*;

@Component
public class LoggedOutHeaderRowBlock extends UIComponent {

    @Step("Click on Sign in button.")
    public void clickOnSignInButton() {
        click(SIGN_IN_BUTTON_XPATH);
    }

    @Step("Check that user is logged out.")
    public boolean isUserLoggedOut() {
        return isDisplayed(SIGN_IN_BUTTON_XPATH);
    }
}
