package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.ProfilePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProfileStepDefs extends AbstractStepDefs {
    @Autowired
    private ProfilePage profilePage;

}