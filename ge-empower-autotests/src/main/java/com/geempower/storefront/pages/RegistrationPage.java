package com.geempower.storefront.pages;

import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import static com.geempower.storefront.page_elements.RegistrationPageElements.*;

@Component
public class RegistrationPage extends StorefrontBasePage {

    private final String pageUri = "register/showRegister";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    public String getUserNameValue() {
        return $(USER_NAME_VALUE_XPATH).getText();
    }

    public String getUserLastNameValue() {
        return $(USER_LAST_NAME_VALUE_XPATH).getText();
    }

    public String getUserIdValue() {
        return $(USER_ID_VALUE_XPATH).getText();
    }

    public String getUserEmailValue() {
        return $(USER_EMAIL_VALUE_XPATH).getText();
    }

    public void setCompanyName(String companyName) {
        $(By.id(COMPANY_INPUT_ID)).sendKeys(companyName);
    }

    public void setPhoneNo(String phoneNo) {
        $(By.id(PHONE_INPUT_ID)).sendKeys(phoneNo);
    }

    public void selectRandomRegionFromRegionsList() {
        waitUntilPageIsFullyLoaded();
        click(OPEN_REGIONS_LIST_ICON_XPATH);
        $$(ALL_REGION_VALUES_IN_REGIONS_LIST_XPATH).stream().findAny().ifPresent(WebElement::click);
    }


    public void selectRandomCountryFromCountriesList() {
        waitUntilPageIsFullyLoaded();
        click(OPEN_COUNTRIES_LIST_ICON_XPATH);
        $$(ALL_COUNTRY_VALUES_IN_COUNTRIES_LIST_XPATH).stream().findAny().ifPresent(WebElement::click);
    }

    public void selectAppropriateRelationship(String relationship) {
        waitUntilPageIsFullyLoaded();
        click(OPEN_RELATIONSHIP_LIST_ICON_XPATH);
        waitUntilPageIsFullyLoaded();
        click(RELATIONSHIP_TO_INDUSTRIAL_SOLUTION_VALUE_IN_LIST_XPATH, relationship);
    }

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

    public String getSuccessRegistrationPopUpHeader() {
        waitUntilPageIsFullyLoaded();
        return $(REGISTRATION_SUCCESSFUL_POP_UP_HEADER_XPATH).getText();
    }

    public void clickOnRegisterButton() {
        click(REGISTER_BUTTON_ID);
    }

    public String getDefaultLanguage() {
        return $(By.id(DEFAULT_LANGUAGE_VALUE_ID)).getText();
    }

    public String getRelationshipValue() {
        return $(RELATIONSHIP_TO_INDUSTRIAL_SOLUTION_VALUE_XPATH).getText();
    }
}
