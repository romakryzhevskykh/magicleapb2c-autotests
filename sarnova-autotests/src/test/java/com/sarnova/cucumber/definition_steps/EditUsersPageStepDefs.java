package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.user_engine.StorefrontUserRole;
import com.sarnova.helpers.user_engine.UserRole;
import com.sarnova.helpers.user_engine.UserTitle;
import com.sarnova.helpers.user_engine.UsersManager;
import com.sarnova.storefront.pages.EditUserPage;
import cucumber.api.java.en.And;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Random;

public class EditUsersPageStepDefs extends AbstractStepDefs {
    @Autowired EditUserPage editUserPage;
    @Autowired UsersManager usersManager;

    @And("^Select any title on Edit user page.$")
    public void selectAnyTitleOnEditUserPage() {
        editUserPage.clickOnTitleDropDown();
        Random generator = new Random();
        int randomIndex = generator.nextInt(UserTitle.values().length);
        UserTitle randomTitle = UserTitle.values()[randomIndex];
        threadVarsHashMap.put(TestKeyword.EDIT_USER_TITLE, randomTitle);
        editUserPage.selectTitle(randomTitle);
    }

    @And("^Fill First name field with a random text on Edit user page.$")
    public void fillFirstNameFieldWithARandomTextOnEditUserPage() {
        String randomName = RandomStringUtils.randomAlphabetic(10);
        threadVarsHashMap.put(TestKeyword.EDIT_USER_FIRST_NAME, randomName);
        editUserPage.fillFirstName(randomName);
    }

    @And("^Fill Last name field with a random text on Edit user page.$")
    public void fillLastNameFieldWithARandomTextOnEditUserPage() {
        String randomName = RandomStringUtils.randomAlphabetic(10);
        threadVarsHashMap.put(TestKeyword.EDIT_USER_LAST_NAME, randomName);
        editUserPage.fillLastName(randomName);
    }

    @And("^Fill Email field with a random email on Edit user page.$")
    public void fillEmailFieldWithARandomEmailOnEditUserPage() {
        String randomEmail = RandomStringUtils.randomAlphabetic(10) + "@" + RandomStringUtils.randomAlphabetic(5) + ".com";
        threadVarsHashMap.put(TestKeyword.EDIT_USER_EMAIL, randomEmail);
        editUserPage.fillEmail(randomEmail);
    }

    @And("^Select any Parent unit on Edit user page.$")
    public void selectAnyParentUnitOnEditUserPage() {
        //write randomizer for parent unit
        editUserPage.selectAnyParentUnit();
    }

    @And("^Select any user Role on Edit user page.$")
    public void selectAnyUserRoleOnEditUserPage() {
        editUserPage.deselectAllSelectedUserRoles();
        Random generator = new Random();
        int randomIndex = generator.nextInt(StorefrontUserRole.getRoles().length);
        StorefrontUserRole storefrontUserRole = StorefrontUserRole.getRoles()[randomIndex];
        ArrayList<UserRole> storefrontUserRoles = getSelectedUserRoles();
        storefrontUserRoles.add(storefrontUserRole);
        storefrontUserRoles.forEach(userRole -> editUserPage.selectUserRole(userRole));
    }

    @And("^Click on Save button on Edit user page.$")
    public void clickOnSaveButtonOnEditUserPage() {
        editUserPage.clickOnSaveButton();
    }
}
