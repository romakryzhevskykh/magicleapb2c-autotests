package com.magicleap.cucumber.definition_steps;

import com.magicleap.helpers.managers.users.UserSessions;
import com.magicleap.storefront.page_blocks.HeaderRowPageBlock;
import com.magicleap.storefront.pages.LoginPage;
import com.magicleap.storefront.pages.QualificationPage;
import com.magicleap.storefront.pages.StartPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class QualificationPageStepDefs extends AbstractStepDefs {

    @Autowired UserSessions userSessions;
    @Autowired StartPage startPage;
    @Autowired LoginPage loginPage;
    @Autowired QualificationPage qualificationPage;

    @And("Click on sign up button.")
    public void clickOnSignUpButton() {
        loginPage.clickOnSignUpButton();
    }

    @And("Check that Qualification page is opened.")
    public void checkThatQualificationPageIsOpened() {
        assertTrue(qualificationPage.isOpened());
    }

}
