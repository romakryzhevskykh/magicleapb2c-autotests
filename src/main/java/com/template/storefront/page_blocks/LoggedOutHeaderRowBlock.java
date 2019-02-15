package com.template.storefront.page_blocks;

import com.template.helpers.page.UIComponent;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.concurrent.TimeUnit;

import static com.template.storefront.page_block_elements.LoggedOutHeaderRowBlockElements.SIGN_IN_BUTTON_XPATH;

@Component
public class LoggedOutHeaderRowBlock extends UIComponent {

    @Step("Click on Sign in button.")
    public void clickOnSignInButton() {
        $(SIGN_IN_BUTTON_XPATH).click();
    }

    @Step("Check that user is logged out.")
    public boolean isUserLoggedOut() {
        return withTimeOutOf(5, TimeUnit.SECONDS).isPresent(SIGN_IN_BUTTON_XPATH)
                && $(SIGN_IN_BUTTON_XPATH).isDisplayed();
    }
}
