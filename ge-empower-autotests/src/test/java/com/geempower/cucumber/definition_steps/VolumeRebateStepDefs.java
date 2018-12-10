package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.pages.VolumeRebatePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Stream;

import static org.testng.Assert.assertEquals;
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

    @Then("^(.*) title is displayed on the Volume rebate page.$")
    public void volumeRebateAVRTitleIsDisplayedOnTheVolumeRebatePage(String pageTitle) {
        assertEquals(pageTitle, volumeRebatePage.getPageTitle());
    }

    @Then("^(.*) and (.*) messages are displayed on the Volume rebate page.$")
    public void messagesAreDisplayedOnTheVolumeRebatePage(String settlementPartnerMessage, String infoMessage) {
        List<String> messages = volumeRebatePage.getListOfMessages();
        if (messages.size() > 1) {
            assertTrue(messages.contains(settlementPartnerMessage) &&
                    messages.contains(infoMessage));
        }
        else {
            assertEquals(infoMessage, messages.get(0));
        }
    }
}
