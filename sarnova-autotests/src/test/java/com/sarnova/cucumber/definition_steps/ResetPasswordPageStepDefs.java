package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.user_engine.User;
import com.sarnova.helpers.user_engine.UsersManager;
import com.sarnova.storefront.pages.ResetPasswordPage;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class ResetPasswordPageStepDefs extends AbstractStepDefs {
    @Autowired UsersManager usersManager;
    @Autowired ResetPasswordPage resetPasswordPage;

    @When("^Set new password to New password field on Reset password page.$")
    public void setNewPasswordToNewPasswordField() {
        String newPassword = RandomStringUtils.randomAlphanumeric(10);
        threadVarsHashMap.put(TestKeyword.EDIT_USER_PASSWORD, newPassword);
        resetPasswordPage.fillTextToNewPasswordField(newPassword);
    }

    @When("^Set the same password to Confirm new password field on Reset password page.$")
    public void setTheSamePasswordToConfirmPasswordField() {
        String newPassword = threadVarsHashMap.getString(TestKeyword.EDIT_USER_PASSWORD);
        resetPasswordPage.fillTextToConfirmPasswordField(newPassword);
    }

    @When("^Click on Update password button on Reset password page.$")
    public void clickOnUpdatePasswordButton() {
        resetPasswordPage.clickOnUpdatePasswordButton();
        User user = usersManager.getUserByUsername(threadVarsHashMap.getString(TestKeyword.TEST_USER_USERNAME));
        user.setPassword(threadVarsHashMap.getString(TestKeyword.EDIT_USER_PASSWORD));
    }
}
