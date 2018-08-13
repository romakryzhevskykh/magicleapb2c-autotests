package com.geempower.hybris.hac.pages;

import com.geempower.helpers.user_engine.UserSession;
import com.geempower.hybris.hac.HACBasePage;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.hybris.hac.page_elements.HacLoginPageElements.*;

@Component
public class HacLoginPage extends HACBasePage {

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

    @Override
    public String getPageUrl() {
        return templateHAC.getBaseUrl().concat("-" + templateHAC.getHacActiveNode() + "/login.jsp");
    }

    @Step("Login to HAC.")
    public void loginToHac(UserSession userSession) {
        fillUsername(userSession.getUsername());
        fillPassword(userSession.getPassword());
        clickOnLoginButton();
        userSession.setCookies(getDriver().manage().getCookies());
    }

    @Step("Fill Username field on Login Page with {0}.")
    private void fillUsername(String username) {
        waitUntilPageIsFullyLoaded();
        $(LOGIN_FIELD_XPATH).clear();
        $(LOGIN_FIELD_XPATH).sendKeys(username);
    }

    @Step("Fill Password field on Login Page with {0}.")
    private void fillPassword(String password) {
        waitUntilPageIsFullyLoaded();
        $(PASSWORD_FIELD_XPATH).clear();
        $(PASSWORD_FIELD_XPATH).sendKeys(password);
    }

    @Step("Click on Sign In button.")
    private void clickOnLoginButton() {
        click(LOGIN_BUTTON_XPATH);
    }
}
