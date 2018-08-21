package com.geempower.cucumber.definition_steps.hac;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.hybris.hac.pages.HacMainPage;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class HacMainPageStepDefs extends AbstractStepDefs {
    @Autowired
    private HacMainPage hacMainPage;

    @When("^Admin opens configuration section.$")
    public void openConfigurationSection(){
        hacMainPage.openConfigurationSection();
    }
}
