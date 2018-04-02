package com.sarnova.storefront.page_blocks;

import com.sarnova.helpers.UIComponent;
import com.sarnova.helpers.user_engine.StorefrontUserRoles;
import com.sarnova.helpers.user_engine.UserTitle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.sarnova.storefront.page_block_elements.EditUserBlockElements.*;

@Component
public class EditUserBlock extends UIComponent {

    @Step("Select title: {0}.")
    public void selectTitle(UserTitle userTitle) {
        click(TITLE_ITEM_IN_DROP_DOWN_BY_NAME_XPATH, userTitle.name().toLowerCase());
    }

    @Step("Fill first name field: {0}.")
    public void fillFirstNameOnEditUserPage(String firstName) {
        $(By.id(FIRST_NAME_FIELD_ID)).clear();
        $(By.id(FIRST_NAME_FIELD_ID)).sendKeys(firstName);
    }

    @Step("Fill last name field: {0}.")
    public void fillLastNameOnEditUserPage(String lastName) {
        $(By.id(LAST_NAME_FIELD_ID)).clear();
        $(By.id(LAST_NAME_FIELD_ID)).sendKeys(lastName);
    }

    @Step("Fill email field: {0}.")
    public void fillEmailOnEditUserPage(String email) {
        $(By.id(EMAIL_FIELD_ID)).clear();
        $(By.id(EMAIL_FIELD_ID)).sendKeys(email);
    }

    @Step("Select parent unit.")
    public void selectAnyParentUnitOnEditUserPage() {
        //TODO
    }

    @Step("Click on user role checkbox: {0}.")
    public void selectUserRoleOnEditUserPage(StorefrontUserRoles storefrontUserRole) {
        click(ROLE_CHECKBOX_BY_CODE_XPATH, storefrontUserRole.getRoleCode());
    }

    @Step("Click on title drop-down.")
    public void clickOnTitleDropDown() {
        click(TITLE_DROP_DOWN_XPATH);
    }

    @Step("Click on save button.")
    public void clickOnSaveButtonOnEditUserPage() {
        click(SAVE_BUTTON_XPATH);
    }

    @Step("Deselect all user roles.")
    public void deselectAllSelectedUserRolesOnEditUserPage() {
        $$(ROLE_CHECKBOXES_XPATH).stream().filter(WebElement::isSelected).forEach(WebElement::click);
    }
}
