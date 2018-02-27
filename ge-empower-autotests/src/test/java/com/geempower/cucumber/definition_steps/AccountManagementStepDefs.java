package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.managers.RegionsManager;
import com.geempower.helpers.models.Region;
import com.geempower.storefront.pages.AccountManagementPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountManagementStepDefs extends AbstractStepDefs {
    @Autowired RegionsManager regionsManager;
    @Autowired AccountManagementPage accountManagementPage;


    @When("^Choose (.*) region.$")
    public void chooseRegion(String regionName) {
        Region chosenRegion = regionsManager.getRegionByName(regionName);
        accountManagementPage.selectAppropriateRegionFromRegionList(chosenRegion);
        threadVarsHashMap.put(TestKeyword.CHOSEN_REGION, chosenRegion);
    }

    @And("^Close Account management page.$")
    public void clickOnCancelButton() {
        accountManagementPage.clickOnCancelButton();
    }

    @And("^Search random account for chosen region.$")
    public void searchForChosenRegionAccount() {
        Region chosenRegion = (Region) threadVarsHashMap.get(TestKeyword.CHOSEN_REGION);
        String accountName = chosenRegion.getAccounts().stream().findAny().orElseGet(() -> {
            throw new NullPointerException("No Accounts in the selected region");
        });
        threadVarsHashMap.put(TestKeyword.CHOSEN_ACCOUNT, accountName);
        accountManagementPage.searchAccountForChosenRegion(accountName);
    }

    @And("^Click on chosen account.$")
    public void selectChosenAccount(){
        accountManagementPage.selectFirstAccount();
    }
}
