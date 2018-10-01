package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.managers.RegionsManager;
import com.geempower.helpers.models.Region;
import com.geempower.storefront.pages.AccountManagementPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.Assert.*;

public class AccountManagementStepDefs extends AbstractStepDefs {
    @Autowired
    private RegionsManager regionsManager;
    @Autowired
    private AccountManagementPage accountManagementPage;

    @Then("^Check that Account management page is opened.$")
    public void checkThatAccountManagementPageIsOpened() {
        assertTrue(accountManagementPage.isOpened());
    }

    @Then("^Is Favorites tab displayed by Default on Account Management page.$")
    public void isFavoritesTabDisplayedByDefaultOnAccountManagementPage() {
        assertTrue(accountManagementPage.isActiveFavoriteTabDisplayed());
    }
}