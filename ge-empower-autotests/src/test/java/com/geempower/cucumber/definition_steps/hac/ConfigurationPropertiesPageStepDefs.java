package com.geempower.cucumber.definition_steps.hac;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.hybris.hac.pages.ConfigurationPropertiesPage;
import cucumber.api.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

public class ConfigurationPropertiesPageStepDefs extends AbstractStepDefs {
    @Autowired
    private ConfigurationPropertiesPage configurationPropertiesPage;

    @And("^Search configuration property by name (.*).$")
    public void searchConfigurationPropertyByName(String propertyName){
        configurationPropertiesPage.searchPropertyByPropertyName(propertyName);
    }

    @And("^Set new property value (.*).$")
    public void setNewPropertyValue(String propertyValue){
        configurationPropertiesPage.setNewPropertyValue(propertyValue);
    }
}
