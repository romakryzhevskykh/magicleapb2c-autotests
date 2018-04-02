package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.user_engine.StorefrontUserRoles;
import com.sarnova.helpers.user_engine.UserTitle;
import com.sarnova.storefront.pages.UsersPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Random;

public class UsersManagementPageStepDefs extends AbstractStepDefs {
    @Autowired UsersPage usersPage;

    @Given("^Open Users Management page.$")
    public void openUserManagementPage() {
        usersPage.open();
    }

    @When("^Click on Add new user on Users page.$")
    public void clickOnAddNewUserOnUsersPage() {
        usersPage.clickOnAddNewUser();
    }

    @And("^Select any title on Edit user page.$")
    public void selectAnyTitleOnEditUserPage() {
        usersPage.clickOnTitleDropDown();
        Random generator = new Random();
        int randomIndex = generator.nextInt(UserTitle.values().length);
        UserTitle randomTitle = UserTitle.values()[randomIndex];
        threadVarsHashMap.put(TestKeyword.EDIT_USER_TITLE, randomTitle);
        usersPage.selectTitleOnEditUserPage(randomTitle);
    }

    @And("^Fill First name field with a random text on Edit user page.$")
    public void fillFirstNameFieldWithARandomTextOnEditUserPage() {
        String randomName = RandomStringUtils.randomAlphabetic(10);
        threadVarsHashMap.put(TestKeyword.EDIT_USER_FIRST_NAME, randomName);
        usersPage.fillFirstNameOnEditUserPage(randomName);
    }

    @And("^Fill Last name field with a random text on Edit user page.$")
    public void fillLastNameFieldWithARandomTextOnEditUserPage() {
        String randomName = RandomStringUtils.randomAlphabetic(10);
        threadVarsHashMap.put(TestKeyword.EDIT_USER_LAST_NAME, randomName);
        usersPage.fillLastNameOnEditUserPage(randomName);
    }

    @And("^Fill Email field with a random email on Edit user page.$")
    public void fillEmailFieldWithARandomEmailOnEditUserPage() {
        String randomEmail = RandomStringUtils.randomAlphabetic(10) + "@" + RandomStringUtils.randomAlphabetic(5) + ".com";
        threadVarsHashMap.put(TestKeyword.EDIT_USER_EMAIL, randomEmail);
        usersPage.fillEmailOnEditUserPage(randomEmail);
    }

    @And("^Select any Parent unit on Edit user page.$")
    public void selectAnyParentUnitOnEditUserPage() {
        //write randomizer for parent unit
        usersPage.selectAnyParentUnitOnEditUserPage();
    }

    @And("^Select any user Role on Edit user page.$")
    public void selectAnyUserRoleOnEditUserPage() {
        usersPage.deselectAllSelectedUserRolesOnEditUserPage();
        Random generator = new Random();
        int randomIndex = generator.nextInt(StorefrontUserRoles.values().length);
        StorefrontUserRoles storefrontUserRole = StorefrontUserRoles.values()[randomIndex];
        ArrayList<StorefrontUserRoles> storefrontUserRoles = getSelectedUserRoles();
        storefrontUserRoles.add(storefrontUserRole);
        storefrontUserRoles.forEach(userRole -> usersPage.selectUserRoleOnEditUserPage(userRole));
    }

    @And("^Click on Save button on Edit user page.$")
    public void clickOnSaveButtonOnEditUserPage() {
        usersPage.clickOnSaveButtonOnEditUserPage();
    }
}
