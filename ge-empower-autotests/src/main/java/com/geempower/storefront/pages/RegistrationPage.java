package com.geempower.storefront.pages;

import com.geempower.helpers.Utils;
import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.RegistrationPageElements.*;

@Component
public class RegistrationPage extends StorefrontBasePage {
    @Autowired
    private Utils utils;

    private final String pageUri = "register/showregister";

    @Override
    public boolean isOpened() {
        waitUntilPageIsFullyLoaded();
        return getCurrentUrl().equals(getPageUrl());
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Step("Get User Name Value.")
    public String getUserNameValue() {
        return $(USER_NAME_VALUE_XPATH).getText();
    }

    @Step("Get User Last Name Value.")
    public String getUserLastNameValue() {
        return $(USER_LAST_NAME_VALUE_XPATH).getText();
    }

    @Step("Get User ID Value.")
    public String getUserIdValue() {
        return $(USER_ID_VALUE_XPATH).getText();
    }

    @Step("Get User Email Value.")
    public String getUserEmailValue() {
        return $(USER_EMAIL_VALUE_XPATH).getText();
    }

    @Step("Set company name.")
    public void setCompanyName(String companyName) {
        waitUntilPageIsFullyLoaded();
        $(By.id(COMPANY_INPUT_ID)).sendKeys(companyName);
    }

    @Step("Set Phone No.")
    public void setPhoneNo(String phoneNo) {
        waitUntilPageIsFullyLoaded();
        $(By.id(PHONE_INPUT_ID)).sendKeys(phoneNo);
    }

    @Step("Select Random Region From Regions List.")
    public void selectRandomRegionFromRegionsList() {
        waitUntilPageIsFullyLoaded();
        click(OPEN_REGIONS_LIST_ICON_XPATH);
        $$(ALL_REGION_VALUES_IN_REGIONS_LIST_XPATH).stream().findAny().ifPresent(WebElement::click);
    }

    @Step("Select Random Country From Countries List.")
    public void selectRandomCountryFromCountriesList() {
        waitUntilPageIsFullyLoaded();
        click(OPEN_COUNTRIES_LIST_ICON_XPATH);
        $$(ALL_COUNTRY_VALUES_IN_COUNTRIES_LIST_XPATH).stream().findAny().ifPresent(WebElement::click);
    }

    @Step("Select Appropriate Relationship.")
    public void selectAppropriateRelationship(String relationship) {
        waitUntilPageIsFullyLoaded();
        click(OPEN_RELATIONSHIP_LIST_ICON_XPATH);
        waitUntilPageIsFullyLoaded();
        click(RELATIONSHIP_TO_INDUSTRIAL_SOLUTION_VALUE_IN_LIST_XPATH, relationship);
    }

    @Step("Select Random User Role From Roles List.")
    public String selectRandomUserRoleFromRolesList() {
        StringBuilder userRole = new StringBuilder();
        waitUntilPageIsFullyLoaded();
        click(OPEN_ROLES_LIST_ICON_XPATH);
        $$(ALL_ROLE_VALUES_IN_ROLES_LIST_XPATH).stream().findAny().ifPresent(role -> {
            userRole.append(role.getText());
            role.click();
        });
        return String.valueOf(userRole);
    }

    @Step("Get Success Registration Pop-Up Header.")
    public String getSuccessRegistrationPopUpHeader() {
        waitUntilPageIsFullyLoaded();
        return $(REGISTRATION_SUCCESSFUL_POP_UP_HEADER_XPATH).getText();
    }

    @Step("Click On Register Button.")
    public void clickOnRegisterButton() {
        waitUntilPageIsFullyLoaded();
        utils.pageScrollDown();
        click(By.id(REGISTER_BUTTON_ID));
    }

    @Step("Get Default Language.")
    public String getDefaultLanguage() {
        waitUntilPageIsFullyLoaded();
        return $(By.id(DEFAULT_LANGUAGE_VALUE_ID)).getText();
    }

    @Step("Get Relationship Value.")
    public String getRelationshipValue() {
        waitUntilPageIsFullyLoaded();
        return $(By.id(RELATIONSHIP_TO_INDUSTRIAL_SOLUTION_VALUE_ID)).getText();
    }

    @Step("Close Success Registration Pop-Up.")
    public void closeSuccessRegistrationPopUp() {
        waitUntilPageIsFullyLoaded();
        click(CLOSE_SUCCESS_REGISTRATION_POP_UP_XPATH);
    }

    @Step("Select Appropriate User Role.")
    public void selectAppropriateUserRole(String userRole) {
        waitUntilPageIsFullyLoaded();
        click(OPEN_ROLES_LIST_ICON_XPATH);
        waitUntilPageIsFullyLoaded();
        click(APPROPRIATE_USER_ROLE_VALUE_IN_ROLES_LIST_XPATH, userRole);
    }

    @Step("Check if Account information section displayed on the Registration page.")
    public boolean isAccountInformationSectionDisplayed() {
        waitUntilPageIsFullyLoaded();
        return isDisplayed(ACCOUNT_INFORMATION_SECTION_XPATH);
    }

    @Step("Get chosen region value.")
    public String getChosenRegion() {
        return $(By.id(CHOSEN_REGION_VALUE_ID)).getText();
    }

}
