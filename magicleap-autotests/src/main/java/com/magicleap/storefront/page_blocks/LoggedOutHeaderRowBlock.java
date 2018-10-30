package com.magicleap.storefront.page_blocks;

import com.magicleap.helpers.UIComponent;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.magicleap.storefront.page_block_elements.LoggedOutHeaderRowBlockElements.SIGN_IN_BUTTON_XPATH;

@Component
public class LoggedOutHeaderRowBlock extends UIComponent {

    @Step("Click on Sign in button.")
    public void clickOnSignInButton() {
        $(SIGN_IN_BUTTON_XPATH).click();
    }

    @Step("Check that user is logged out.")
    public boolean isUserLoggedOut() {
        return isDisplayed(SIGN_IN_BUTTON_XPATH);
    }
}
