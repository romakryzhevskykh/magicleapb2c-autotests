package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.user_engine.*;
import com.sarnova.storefront.pages.EditUserPage;
import cucumber.api.java.en.And;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Random;

public class EditUsersPageStepDefs extends AbstractStepDefs {
    @Autowired EditUserPage editUserPage;
    @Autowired UsersManager usersManager;

    @And("^Open Test user edit page.$")
    public void openTestUserEditPage() {
        String username = threadVarsHashMap.getString(TestKeyword.TEST_USER_USERNAME);
        User user = usersManager.getUserByUsername(username);
        editUserPage.open(user);
    }

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
        threadVarsHashMap.put(TestKeyword.EDIT_USER_USERNAME, randomEmail);
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
        StorefrontUserRole storefrontUserRole = StorefrontUserRole.getRandom();
        ArrayList<UserRole> storefrontUserRoles = getSelectedUserRoles();
        storefrontUserRoles.add(storefrontUserRole);
        storefrontUserRoles.forEach(userRole -> editUserPage.selectUserRole(userRole));
    }

    @And("^Click on Save button on Edit user page.$")
    public void clickOnSaveButtonOnEditUserPage() {
        User user = usersManager.getUserByUsername(threadVarsHashMap.getString(TestKeyword.TEST_USER_USERNAME));
        editUserPage.clickOnSaveButton();
        if (!editUserPage.isOpened(user)) {
            user.setUserTitle((UserTitle) threadVarsHashMap.get(TestKeyword.EDIT_USER_TITLE));
            user.setUsername(threadVarsHashMap.getString(TestKeyword.EDIT_USER_USERNAME));
            user.setEmail(threadVarsHashMap.getString(TestKeyword.EDIT_USER_EMAIL));
            user.setFirstName(threadVarsHashMap.getString(TestKeyword.EDIT_USER_FIRST_NAME));
            user.setLastName(threadVarsHashMap.getString(TestKeyword.EDIT_USER_LAST_NAME));
            user.getUserRoles().clear();
            user.getUserRoles().addAll(getSelectedUserRoles());
            threadVarsHashMap.put(TestKeyword.TEST_USER_USERNAME, threadVarsHashMap.getString(TestKeyword.EDIT_USER_USERNAME));
        }
    }
}
