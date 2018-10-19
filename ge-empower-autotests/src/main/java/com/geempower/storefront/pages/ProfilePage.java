package com.geempower.storefront.pages;

import com.geempower.helpers.models.RegionType;
import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;
import java.util.stream.Collectors;

import static com.geempower.helpers.models.RegionType.getRegionTypes;
import static com.geempower.storefront.page_elements.ProfilePageElements.*;

@Component
public class ProfilePage extends StorefrontBasePage {
    private final String pageUri = "my-account/profile";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

    @Step("Get Profile title.")
    public String getProfileTitle() {
        return $(PROFILE_TITLE_XPATH).getText();
    }

    @Step("Get user name from user's profile.")
    public String getUserName() {
        return $(USER_FIRST_NAME_XPATH).getText();
    }

    @Step("Get user last name from user's profile.")
    public String getUserLastName() {
        return $(USER_LAST_NAME_XPATH).getText();
    }

    @Step("Get User Id from user's profile.")
    public String getUserId() {
        return $(USER_ID_XPATH).getText();
    }

    @Step("Get User Role from user's profile.")
    public String getUserRole() {
        return $(USER_ROLE_XPATH).getText().trim();
    }

    @Step("Get Company Name from user's profile.")
    public String getCompanyName() {
        return $(USER_COMPANY_NAME_XPATH).getAttribute("value");
    }

    @Step("Get Email from user's profile.")
    public String getEmail() {
        return $(USER_EMAIL_ADDRESS_XPATH).getText();
    }

    @Step("Get Phone Number from user's profile.")
    public String getPhoneNumber() {
        return $(USER_PHONE_NUMBER_XPATH).getAttribute("value");
    }

    @Step("Get Default Language from user's profile.")
    public String getLanguage() {
        return $(USER_LANGUAGE_XPATH).getText();
    }

    @Step("Get Relationship user's profile.")
    public String getRelationship() {
        return $(USER_RELATIONSHIP_XPATH).getText();
    }

    @Step("Get Role For Each Region in user Profile")
    public HashMap<String, String> getRoleForEachRegion() {
        waitUntilPageIsFullyLoaded();
        HashMap<String, String> rolesForRegions = new HashMap<>();
        rolesForRegions.putAll(getRegionTypes().stream()
                .collect(Collectors.toMap(RegionType::getRegionName,
                        region -> $(USER_ROLE_IN_EACH_REGION_XPATH, region.getRegionName()).getText())));
        return rolesForRegions;
    }

    @Step("Get Unregister Section Title.")
    public String getUnregisterSectionTitle() {
        return $(UNREGISTER_SECTION_TITLE_XPATH).getText();
    }

    @Step("Get Deactivate Action Description.")
    public String getDeactivateActionDescription() {
        return $(DEACTIVATE_ACTION_DESCRIPTION_XPATH).getText();
    }

    @Step("Click On Deactivate My User ID Button.")
    public void clickOnDeactivateMyUserIDButton() {
        click(DEACTIVATE_BUTTON_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Get Confirmation Text From Confirmation Pop-Up.")
    public String getConfirmationTextFromConfirmationPopUp() {
        waitUntilPageIsFullyLoaded();
        String confirmationPopUp = getDriver().getWindowHandle();
        getDriver().switchTo().window(confirmationPopUp);
        return $(CONFIRMATION_TEXT_DEACTIVATE_ACTION_POP_UP_XPATH).getText();
    }

    @Step("Get Confirmation Second Text From Confirmation Pop-Up.")
    public String getConfirmationSecondTextFromConfirmationPopUp() {
        waitUntilPageIsFullyLoaded();
        return $(CONFIRMATION2_TEXT_DEACTIVATE_ACTION_POP_UP_XPATH).getText();
    }

    @Step("Is Deactivate Button Disabled.")
    public boolean isDeactivateButtonDisabled() {
        return Boolean.parseBoolean($(DEACTIVATE_MY_USER_ID_XPATH).getAttribute("disabled"));
    }

    @Step("Confirm Deactivation.")
    public void confirmDeactivation() {
        click(CHECKBOX_DEACTIVATE_ACTION_POP_UP_XPATH);
    }

    @Step("Click On Deactivate My User Id Button.")
    public void clickOnDeactivateMyUserIdButton() {
        click(DEACTIVATE_MY_USER_ID_XPATH);
        waitUntilPageIsFullyLoaded();
    }
}