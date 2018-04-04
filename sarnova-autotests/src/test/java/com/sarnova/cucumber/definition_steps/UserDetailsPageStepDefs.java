package com.sarnova.cucumber.definition_steps;

import com.sarnova.helpers.user_engine.User;
import com.sarnova.helpers.user_engine.UserRole;
import com.sarnova.helpers.user_engine.UserTitle;
import com.sarnova.helpers.user_engine.UsersManager;
import com.sarnova.storefront.pages.UserDetailsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserDetailsPageStepDefs extends AbstractStepDefs {
    @Autowired UsersManager usersManager;
    @Autowired UserDetailsPage userDetailsPage;

    @Then("Check that User details page is opened.")
    public void checkThatUserDetailsPageIsOpened() {
        User user = usersManager.getUserByUsername(threadVarsHashMap.getString(TestKeyword.EDIT_USER_EMAIL));
        assertTrue(userDetailsPage.isOpened(user));
    }

    @Then("^Check that User title field is equal to set on User details page.$")
    public void checkThatUserTitleFieldIsEqualToSetOnUserDetailsPage() {
        UserTitle userTitle = (UserTitle) threadVarsHashMap.get(TestKeyword.EDIT_USER_TITLE);
        assertEquals(userDetailsPage.getTitle(), userTitle.getTitleText());
    }

    @Then("^Check that User first name field is equal to set on User details page.$")
    public void checkThatUserFirstNameFieldIsEqualToSetOnUserDetailsPage() {
        assertEquals(userDetailsPage.getFirstName(), threadVarsHashMap.getString(TestKeyword.EDIT_USER_FIRST_NAME));
    }

    @Then("^Check that User last name field is equal to set on User details page.$")
    public void checkThatUserLastNameFieldIsEqualToSetOnUserDetailsPage() {
        assertEquals(userDetailsPage.getLastName(), threadVarsHashMap.getString(TestKeyword.EDIT_USER_LAST_NAME));
    }

    @Then("^Check that User email field is equal to set on User details page.$")
    public void checkThatUserEmailFieldIsEqualToSetOnUserDetailsPage() {
        assertEquals(userDetailsPage.getEmail(), threadVarsHashMap.getString(TestKeyword.EDIT_USER_EMAIL));
    }

    @Then("^Check that User roles are equal to set on User details page.$")
    public void checkThatUserRolesFieldIsEqualToSetOnUserDetailsPage() {
        ArrayList<UserRole> setUserRole = getSelectedUserRoles();
        List<UserRole> actualUserRole = userDetailsPage.getRoles();
        System.out.println(setUserRole);
        System.out.println(actualUserRole);
        assertEquals(setUserRole.size(), actualUserRole.size());
        assertTrue(actualUserRole.containsAll(setUserRole));
    }

    @And("^Check that User parent unit field is equal to set on User details page.$")
    public void checkThatUserParentUnitFieldIsEqualToSetOnUserDetailsPage() {

    }
}
