package com.sarnova.storefront.pages;

import com.sarnova.helpers.models.users.AccountType;
import com.sarnova.helpers.models.users.ProfileRole;
import com.sarnova.helpers.models.users.SecurityQuestion;
import com.sarnova.helpers.models.users.Title;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

@Component
public class RegistrationPage extends StorefrontBasePage {

    private String pageUrlMethod = "register";

    @Step("Fill username field: {0}.")
    public void fillUsernameFieldWithText(String username) {

    }

    @Step("Fill password field: {0}.")
    public void fillPasswordFieldWithText(String password) {

    }

    @Step("Fill confirm password field: {0}.")
    public void fillConfirmPasswordFieldWithText(String password) {

    }

    @Step("Select security question from drop-down: {0}.")
    public void selectNewSequrityQuestionFromDropDown(SecurityQuestion securityQuestion) {

    }

    @Step("Fill security answer field: {0}.")
    public void fillSecurityAnswerFieldWithText(String sequrityAnswer) {

    }

    @Step("Fill re-enter answer field: {0}.")
    public void fillReEnterAnswerFieldWithText(String securityAnswer) {

    }

    @Step("Select account type from drop-down: {0}.")
    public void selectAccountTypeFromDropDown(AccountType accountType) {

    }

    @Step("Select Title from drop-down: {0}.")
    public void selectTitleFromDropDown(Title title) {

    }

    @Step("Fill first name field: {0}.")
    public void fillFirstnameFieldWithText(String firstName) {

    }

    @Step("Fill last name field: {0}.")
    public void fillLastNameFieldWithText(String lastName) {

    }

    @Step("Fill account label field: {0}.")
    public void fillAccountLabelFieldWithText(String accountLabel) {

    }

    @Step("Fill phone field: {0}.")
    public void fillPhoneFieldWithText(String phone) {

    }

    @Step("Fill email field: {0}.")
    public void fillEmailFieldWithText(String email) {

    }

    @Step("Select role from drop-down: {0}.")
    public void selectRoleFromDropDown(ProfileRole role) {

    }

    @Step("Set SOMEONE TO MAKE PURCHASE checkbox: {0}.")
    public void setSomeoneToMakePurchase(boolean someoneToMakePurchase) {

    }

    @Step("Set RECEIVE EMAILS checkbox: {0}.")
    public void setReceiveEmails(boolean receiveEmails) {

    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}
