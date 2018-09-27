package com.sarnova.storefront.pages;

import com.sarnova.helpers.models.users.AccountType;
import com.sarnova.helpers.models.users.ProfileRole;
import com.sarnova.helpers.models.users.SecurityQuestion;
import com.sarnova.helpers.models.users.Title;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.sarnova.storefront.page_elements.RegistrationPageElements.*;

@Component
public class RegistrationPage extends StorefrontBasePage {

    private String pageUrlMethod = "register";

    @Step("Fill username field: {0}.")
    public void fillUsernameFieldWithText(String username) {
        enterText(username, By.id(USERNAME_FIELD_ID));
    }

    @Step("Fill password field: {0}.")
    public void fillPasswordFieldWithText(String password) {
        enterText(password, By.id(PASSWORD_FIELD_ID));
    }

    @Step("Fill confirm password field: {0}.")
    public void fillConfirmPasswordFieldWithText(String password) {
        enterText(password, By.id(RECHECK_PASSWORD_FIELD_ID));
    }

    @Step("Select security question from drop-down: {0}.")
    public void selectNewSecurityQuestionFromDropDown(SecurityQuestion securityQuestion) {
        clickOnSecurityQuestionDropDown();
        click(SECURITY_QUESTION_DROP_DOWN_ITEM_BY_VALUE_XPATH, securityQuestion.getIdentificator());
    }

    @Step("Click on Account type drop-down.")
    public void clickOnSecurityQuestionDropDown() {
        click(By.id(SECURITY_QUESTION_DROP_DOWN_ID));
    }

    @Step("Fill security answer field: {0}.")
    public void fillSecurityAnswerFieldWithText(String securityAnswer) {
        enterText(securityAnswer, By.id(SECURITY_ANSWER_FIELD_ID));
    }

    @Step("Fill re-enter answer field: {0}.")
    public void fillReEnterAnswerFieldWithText(String securityAnswer) {
        enterText(securityAnswer, By.id(RE_ENTER_SECURITY_ANSWER_FIELD_ID));
    }

    @Step("Select account type from drop-down: {0}.")
    public void selectAccountTypeFromDropDown(AccountType accountType) {
        clickOnAccountTypeDropDown();
        click(ACCOUNT_TYPE_DROP_DOWN_ITEM_BY_VALUE_XPATH, accountType.getIdentificator());
    }

    @Step("Click on Account type drop-down.")
    public void clickOnAccountTypeDropDown() {
        click(By.id(ACCOUNT_TYPE_DROP_DOWN_ID));
    }

    @Step("Select Title from drop-down: {0}.")
    public void selectTitleFromDropDown(Title title) {
        clickOnTitleDropDown();
        click(TITLE_DROP_DOWN_ITEM_BY_VALUE_XPATH, title.getIdentificator());
    }

    @Step("Click on TITLE drop-down.")
    public void clickOnTitleDropDown() {
        click(By.id(TITLE_DROP_DOWN_ID));
    }

    @Step("Fill first name field: {0}.")
    public void fillFirstNameFieldWithText(String firstName) {
        enterText(firstName, By.id(FIRST_NAME_FIELD_ID));
    }

    @Step("Fill last name field: {0}.")
    public void fillLastNameFieldWithText(String lastName) {
        enterText(lastName, By.id(LAST_NAME_FIELD_ID));
    }

    @Step("Fill account label field: {0}.")
    public void fillAccountLabelFieldWithText(String accountLabel) {
        enterText(accountLabel, By.id(ACCOUNT_LABEL_FIELD_ID));
    }

    @Step("Fill phone field: {0}.")
    public void fillPhoneFieldWithText(String phone) {
        enterText(phone, By.id(PHONE_NUMBER_FIELD_ID));
    }

    @Step("Fill email field: {0}.")
    public void fillEmailFieldWithText(String email) {
        enterText(email, By.id(EMAIL_FIELD_ID));
    }

    @Step("Select role from drop-down: {0}.")
    public void selectRoleFromDropDown(ProfileRole role) {
        clickOnRoleDropDown();
        click(PROFILE_ROLE_DROP_DOWN_ITEM_BY_VALUE_XPATH, role.getIdentificator());
    }

    @Step("Click on Role drop-down.")
    public void clickOnRoleDropDown() {
        click(By.id(PROFILE_ROLE_DROP_DOWN_ID));
    }

    @Step("Set SOMEONE TO MAKE PURCHASE checkbox: {0}.")
    public void setSomeoneToMakePurchase(boolean someoneToMakePurchase) {
        if(isSomeoneToMakePurchaseCheckboxSelected() != someoneToMakePurchase) {
            clickOnSomeoneToMakePurchaseCheckbox();
        }
    }

    @Step("Set RECEIVE EMAILS checkbox: {0}.")
    public void setReceiveEmails(boolean receiveEmails) {
        if(isReceiveEmailsCheckboxSelected() != receiveEmails) {
            clickOnReceiveEmailsCheckbox();
        }
    }

    @Step("Click on SOMEONE TO MAKE PURCHASE checkbox.")
    private void clickOnSomeoneToMakePurchaseCheckbox() {
        click(By.id(SOMEONE_TO_MAKE_PURCHASES_CHECKBOX_ID));
    }

    @Step("Click on RECEIVE EMAILS checkbox.")
    private void clickOnReceiveEmailsCheckbox() {
        click(By.id(RECEIVE_EMAILS_CHECKBOX_ID));
    }

    @Step("Is SOMEONE TO MAKE PURCHASE checkbox selected?")
    private boolean isSomeoneToMakePurchaseCheckboxSelected() {
        return $(By.id(SOMEONE_TO_MAKE_PURCHASES_CHECKBOX_ID)).isSelected();
    }

    @Step("Is RECEIVE EMAILS checkbox selected?")
    private boolean isReceiveEmailsCheckboxSelected() {
        return $(By.id(RECEIVE_EMAILS_CHECKBOX_ID)).isSelected();
    }

    @Step("Fill Billing address first name field: {0}")
    public void fillBillingAddressFirstName(String firstName) {

    }

    @Step("Fill Billing address last name field: {0}")
    public void fillBillingAddressLastName(String lastName) {

    }

    @Step("Select Billing address Country drop-down: {0}")
    public void selectBillingAddressCountry(String country) {

    }

    @Step("Fill Billing address address line 1 field: {0}")
    public void fillBillingAddressAddressLine1(String addressLine1) {

    }

    @Step("Fill Billing address town field: {0}")
    public void fillBillingAddressTown(String town) {

    }

    @Step("Select Billing address State drop-down: {0}")
    public void selectBillingAddressState(String state) {

    }

    @Step("Fill Billing address zip field: {0}")
    public void fillBillingAddressZip(String zip) {

    }

    @Step("Fill Billing address phone1 field: {0}")
    public void fillBillingAddressPhone1(String phone1) {

    }

    @Step("Fill Shipping address first name field: {0}")
    public void fillShippingAddressFirstName(String firstName) {

    }

    @Step("Fill Shipping address last name field: {0}")
    public void fillShippingAddressLastName(String lastName) {

    }

    @Step("Select Shipping address Country drop-down: {0}")
    public void selectShippingAddressCountry(String country) {

    }

    @Step("Fill Shipping address address line 1 field: {0}")
    public void fillShippingAddressAddressLine1(String addressLine1) {

    }

    @Step("Fill Shipping address town field: {0}")
    public void fillShippingAddressTown(String town) {

    }

    @Step("Select Shipping address State drop-down: {0}")
    public void selectShippingAddressState(String state) {

    }

    @Step("Fill Shipping address zip field: {0}")
    public void fillShippingAddressZip(String zip) {

    }

    @Step("Fill Shipping address phone1 field: {0}")
    public void fillShippingAddressPhone1(String phone1) {

    }

    @Step("Click on Register button.")
    public void clickOnRegisterButton() {
        click(REGISTER_BUTTON_XPATH);
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}
