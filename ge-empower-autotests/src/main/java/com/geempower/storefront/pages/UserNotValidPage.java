package com.geempower.storefront.pages;

import com.geempower.storefront.StorefrontBasePage;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.UserNotValidPageElements.*;

@Component
public class UserNotValidPage extends StorefrontBasePage {
    private final String pageUri = "register/userNotValid";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

    @Step("Get userNotValid page title.")
    public String getTitle() {
        waitUntilPageIsFullyLoaded();
        return $(USER_NOT_VALID_TITLE_XPATH).getText();
    }

    @Step("Get Hello message on the userNotValid page.")
    public String getHelloMessage() {
        return $(HELLO_USER_MESSAGE_2).getText() + $(HELLO_USER_MESSAGE_3).getText();
    }

}
