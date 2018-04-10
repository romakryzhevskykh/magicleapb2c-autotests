package com.topcon.storefront.page_blocks;

import com.topcon.helpers.UIComponent;
import com.topcon.storefront.page_elements.LoggedOutHeaderRowBlockElements;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

@Component
public class LoggedOutHeaderRowBlock extends UIComponent {

    @Step("Click on Sign in button.")
    public void clickOnSignInButton() {
        $(LoggedOutHeaderRowBlockElements.SIGN_IN_BUTTON_XPATH).click();
    }

    @Step("Check that user is logged out.")
    public boolean isUserLoggedOut() {
        return isDisplayed(LoggedOutHeaderRowBlockElements.SIGN_IN_BUTTON_XPATH);
    }
}
