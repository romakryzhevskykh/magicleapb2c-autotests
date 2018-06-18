package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.RandomUtils;
import com.sarnova.helpers.user_engine.*;
import com.sarnova.storefront.pages.CreateUserPage;
import cucumber.api.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;


public class CreateUsersPageStepDefs extends AbstractStepDefs {
    @Autowired CreateUserPage createUserPage;
    @Autowired UsersManager usersManager;
    @Autowired RandomUtils randomUtils;

    @And("^Select any title on Create user page.$")
    public void selectAnyTitleOnEditUserPage() {
        createUserPage.clickOnTitleDropDown();
        UserTitle randomTitle = UserTitle.getRandom();
        threadVarsHashMap.put(TestKeyword.EDIT_USER_TITLE, randomTitle);
        createUserPage.selectTitle(randomTitle);
    }

    @And("^Fill First name field with a random text on Create user page.$")
    public void fillFirstNameFieldWithARandomTextOnEditUserPage() {
        String randomName = randomUtils.randomName();
        threadVarsHashMap.put(TestKeyword.EDIT_USER_FIRST_NAME, randomName);
        createUserPage.fillFirstName(randomName);
    }

    @And("^Fill Last name field with a random text on Create user page.$")
    public void fillLastNameFieldWithARandomTextOnEditUserPage() {
        String randomName = randomUtils.randomName();
        threadVarsHashMap.put(TestKeyword.EDIT_USER_LAST_NAME, randomName);
        createUserPage.fillLastName(randomName);
    }

    @And("^Fill Email field with a random email on Create user page.$")
    public void fillEmailFieldWithARandomEmailOnEditUserPage() {
        String randomEmail = randomUtils.randomEmail();
        threadVarsHashMap.put(TestKeyword.EDIT_USER_EMAIL, randomEmail);
        createUserPage.fillEmail(randomEmail);
    }

    @And("^Fill Username field with a random email on Create user page.$")
    public void fillUsernameFieldWithARandomEmailOnEditUserPage() {
        String randomUsername = randomUtils.randomName();
        threadVarsHashMap.put(TestKeyword.EDIT_USER_USERNAME, randomUsername);
        createUserPage.fillUsername(randomUsername);
    }

    @And("^Select any Parent unit on Create user page.$")
    public void selectAnyParentUnitOnEditUserPage() {
        //write randomizer for parent unit
        createUserPage.selectAnyParentUnit();
    }

    @And("^Select any user Role on Create user page.$")
    public void selectAnyUserRoleOnEditUserPage() {
        createUserPage.deselectAllSelectedUserRoles();
        StorefrontUserRole storefrontUserRole = StorefrontUserRole.getRandom();
        ArrayList<UserRole> storefrontUserRoles = getSelectedUserRoles();
        storefrontUserRoles.add(storefrontUserRole);
        storefrontUserRoles.forEach(userRole -> createUserPage.selectUserRole(userRole));
    }

    @And("^Click on Save button on Create user page.$")
    public void clickOnSaveButtonOnEditUserPage() {
        createUserPage.clickOnSaveButton();
        if (!createUserPage.isOpened()) {
            usersManager.createTestInstance(threadVarsHashMap.getString(TestKeyword.EDIT_USER_USERNAME),
                    "",
                    userSessions.getActiveUserSession().getUser().getUserCockpit(),
                    getSelectedUserRoles());
            User user = usersManager.getUserByUsername(threadVarsHashMap.getString(TestKeyword.EDIT_USER_USERNAME));
            user.setEmail(threadVarsHashMap.getString(TestKeyword.EDIT_USER_EMAIL));
//            user.setUserTitle((UserTitle) threadVarsHashMap.get(TestKeyword.EDIT_USER_TITLE));
            user.setFirstName(threadVarsHashMap.getString(TestKeyword.EDIT_USER_FIRST_NAME));
            user.setLastName(threadVarsHashMap.getString(TestKeyword.EDIT_USER_LAST_NAME));

            threadVarsHashMap.put(TestKeyword.TEST_USER_USERNAME, user.getUsername());
        }
    }
}
