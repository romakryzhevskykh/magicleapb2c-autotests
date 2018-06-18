package com.sarnova.storefront.pages;

import com.sarnova.helpers.user_engine.UserRole;
import com.sarnova.helpers.user_engine.UserTitle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.sarnova.storefront.page_block_elements.EditUserBlockElements.*;

@Component
public class CreateUserPage extends StorefrontBasePage {
    private String pageUrlMethod = "boundtree/en/USD/my-company/organization-management/manage-users/create";

    @Step("Select title: {0}.")
    public void selectTitle(UserTitle userTitle) {
        click(TITLE_ITEM_IN_DROP_DOWN_BY_NAME_XPATH, userTitle.name().toLowerCase());
    }

    @Step("Fill first name field: {0}.")
    public void fillFirstName(String firstName) {
        enterText(firstName, By.id(FIRST_NAME_FIELD_ID));
    }

    @Step("Fill last name field: {0}.")
    public void fillLastName(String lastName) {
        enterText(lastName, By.id(LAST_NAME_FIELD_ID));
    }

    @Step("Fill email field: {0}.")
    public void fillEmail(String email) {
        enterText(email, By.id(EMAIL_FIELD_ID));
    }

    @Step("Fill username field: {0}.")
    public void fillUsername(String username) {
        enterText(username, By.id(USERNAME_FIELD_ID));
    }

    @Step("Select parent unit.")
    public void selectAnyParentUnit() {
        //TODO
    }

    @Step("Click on user role checkbox: {0}.")
    public void selectUserRole(UserRole storefrontUserRole) {
        click(ROLE_CHECKBOX_BY_CODE_XPATH, storefrontUserRole.getRoleCode());
    }

    @Step("Click on title drop-down.")
    public void clickOnTitleDropDown() {
        click(TITLE_DROP_DOWN_XPATH);
    }

    @Step("Click on save button.")
    public void clickOnSaveButton() {
        click(SAVE_BUTTON_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Deselect all user roles.")
    public void deselectAllSelectedUserRoles() {
        $$(ROLE_CHECKBOXES_XPATH).stream().filter(WebElement::isSelected).forEach(WebElement::click);
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}
