package com.sarnova.storefront.pages;

import com.sarnova.helpers.user_engine.StorefrontUserRoles;
import com.sarnova.helpers.user_engine.UserTitle;
import com.sarnova.storefront.page_blocks.EditUserBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.sarnova.storefront.page_elements.UsersManagementPageElements.*;

@Component
public class UsersPage extends StorefrontBasePage {
    @Autowired EditUserBlock editUserBlock;

    private String pageUrlMethod = "boundtree/en/USD/my-company/organization-management/manage-users/";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }

    @Step("Click on Add new user button.")
    public void clickOnAddNewUser() {
        click(ADD_NEW_USER_BUTTON_XPATH);
    }

    public void selectTitleOnEditUserPage(UserTitle userTitle) {
        editUserBlock.selectTitle(userTitle);
    }

    public void fillFirstNameOnEditUserPage(String firstName) {
        editUserBlock.fillFirstNameOnEditUserPage(firstName);
    }

    public void fillLastNameOnEditUserPage(String lastName) {
        editUserBlock.fillLastNameOnEditUserPage(lastName);
    }

    public void fillEmailOnEditUserPage(String email) {
        editUserBlock.fillEmailOnEditUserPage(email);
    }

    public void selectAnyParentUnitOnEditUserPage() {
        editUserBlock.selectAnyParentUnitOnEditUserPage();
    }

    public void selectUserRoleOnEditUserPage(StorefrontUserRoles storefrontUserRole) {
        editUserBlock.selectUserRoleOnEditUserPage(storefrontUserRole);
    }

    public void clickOnTitleDropDown() {
        editUserBlock.clickOnTitleDropDown();
    }

    public void clickOnSaveButtonOnEditUserPage() {
        editUserBlock.clickOnSaveButtonOnEditUserPage();
    }

    public void deselectAllSelectedUserRolesOnEditUserPage() {
        editUserBlock.deselectAllSelectedUserRolesOnEditUserPage();
    }
}
