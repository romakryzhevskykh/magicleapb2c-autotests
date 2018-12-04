package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.VolumeRebatePage;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertTrue;

public class VolumeRebateStepDefs extends AbstractStepDefs {

    @Autowired
    private VolumeRebatePage volumeRebatePage;

    @Then("^Volume rebate page is opened.$")
    public void volumeRebatePageIsOpened() {
        assertTrue(volumeRebatePage.isOpened());
    }

    @Then("^Count of AVR is more or equal than count of AVR on the dashboard.$")
    public void countOfAVRIsEqualToCountOfAVROnTheDashboard() {
        int avrsCountOnDashboard = (int) threadVarsHashMap.get(TestKeyword.MINIMAL_COUNT_OF_AVR_ON_DASHBOARD);
        assertTrue(volumeRebatePage.getCountOfAvrs() >= avrsCountOnDashboard);
    }
}
