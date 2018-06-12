package com.sarnova.storefront.pages;

import com.sarnova.helpers.user_engine.User;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.sarnova.storefront.page_elements.ResetPasswordPageElements.*;

@Component
public class ResetPasswordPage extends StorefrontBasePage {
    private final String pageUrlMethod = "my-company/organization-management/manage-users/resetpassword?user=%s";

    public void open(User user) {
        open(String.format(getPageUrl(), user.getUsername()));
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }

    @Step("Click on Update password button.")
    public void clickOnUpdatePasswordButton() {
        click(UPDATE_PASSWORD_BUTTON_XPATH);
    }

    @Step("Fill New password field with text: {0}.")
    public void fillTextToNewPasswordField(String newPassword) {
        $(By.id(NEW_PASSWORD_FIELD_ID)).sendKeys(newPassword);
    }

    @Step("Fill Confirm password field with text: {0}.")
    public void fillTextToConfirmPasswordField(String newPassword) {
        $(By.id(CONFIRM_PASSWORD_FIELD_ID)).sendKeys(newPassword);
    }
}
