package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.Utils;
import com.geempower.helpers.models.AVRTarget;
import com.geempower.helpers.models.AVRType;
import com.geempower.storefront.pages.VolumeRebatePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class VolumeRebateStepDefs extends AbstractStepDefs {

    @Autowired
    private VolumeRebatePage volumeRebatePage;
    @Autowired
    private Utils utils;

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
            assertTrue(settlementPartnerMessage.contains(messages.get(0)) &&
                    (messages.get(1).contains(infoMessage)));
        } else {
            assertTrue(messages.get(0).contains(infoMessage));
        }
    }

    @Then("^Year switcher is present with current year.$")
    public void yearSwitcherIsPresentWithCurrentYear() {
        assertEquals(utils.getCurrentYear(), volumeRebatePage.getYearSwitcherValue());
    }

    @Then("^(.*) currency is displayed on the Volume Rebate page.$")
    public void valuesInEURIsDisplayedOnTheVolumeRebatePage(String currencyLabel) {
        assertEquals(currencyLabel, volumeRebatePage.getCurrencyLabel());
    }

    @Then("^(.*) and (.*) titles are displayed on the Volume Rebate page.$")
    public void currentPayoutAndSeeDetailsBelowTitlesAreDisplayedOnTheVolumeRebatePage(String currentPayoutTitle, String detailsPart) {
        assertTrue(volumeRebatePage.getCurrentPayoutTitle().contains(currentPayoutTitle));
        assertEquals(detailsPart, volumeRebatePage.getSeeDetailsLabel());
    }

    @Then("^Volume rebate ID is displayed for each avr.$")
    public void volumeRebateIDIsDisplayedForEachAvr() {
        volumeRebatePage.getAvrsId().stream().forEach(avrId -> {
            assertTrue(avrId.startsWith("Volume Rebate: 00300") && avrId.contains("|"));
        });
    }

    @Then("^AVR type description is correct for each avr.$")
    public void avrTypeDescriptionIsCorrectForEachAvr() {
        for (int i = 1; i <= volumeRebatePage.getCountOfAvrs(); i++) {
            assertTrue(AVRType.getAVRTypes().stream().map(AVRType::getAvrTypeDescription).collect(Collectors.toList()).contains(volumeRebatePage.getAvrTypeDescriptionWithoutPercentage(i)));
        }
    }

    @Then("^Graph is displayed for each avr.$")
    public void graphIsDisplayedForEachAvr() {
        for (int i = 1; i <= volumeRebatePage.getCountOfAvrs(); i++) {
            assertTrue(volumeRebatePage.isGraphDisplayed(i));
        }
    }

    @Then("^Next target label is correct for each avr.$")
    public void nextTargetLabelIsCorrectForEachAvr() {
        for (int i = 1; i <= volumeRebatePage.getCountOfAvrs(); i++) {
            assertTrue(AVRTarget.getAVRTargets().stream().map(AVRTarget::getAvrTargetDescription).collect(Collectors.toList()).contains(volumeRebatePage.getNextTargetValue(i)));
        }
    }

    @When("^User expands each AVR on the Volume Rebate page.$")
    public void userExpandsEachAVROnTheVolumeRebatePage() {
        for (int i = 1; i <= volumeRebatePage.getCountOfAvrs(); i++) {
            volumeRebatePage.expandAvr(i);
        }
    }

    @Then("^(.*) current volume is displayed for each AVR.$")
    public void currentVolumeIsDisplayedForEachAVR(String currentVolumeLabel) {
        for (int i = 1; i <= volumeRebatePage.getCountOfAvrs(); i++) {
            assertEquals(currentVolumeLabel, volumeRebatePage.getCurrentVolumeLabelForEachAvr(i));
        }
    }

    @Then("^(.*) current payout is displayed for each AVR.$")
    public void currentPayoutIsDisplayedForEachAVR(String currentPayoutLabel) {
        for (int i = 1; i <= volumeRebatePage.getCountOfAvrs(); i++) {
            assertEquals(currentPayoutLabel, volumeRebatePage.getCurrentPayoutLabelForEachAvr(i));
        }
    }

    @Then("^(.*) target reached label is displayed for each AVR.$")
    public void targetReachedLabelIsDisplayedForEachAVR(String targetReachedLabel) {
        for (int i = 1; i <= volumeRebatePage.getCountOfAvrs(); i++) {
            assertEquals(targetReachedLabel, volumeRebatePage.getTargetReachedLabelForEachAvr(i));
        }
    }

    @Then("^(.*) or (.*) is displayed for each AVR.$")
    public void payoutOrCurrentRebateIsDisplayedForEachAVR(String payout, String currentRebate) {
        for (int i = 1; i <= volumeRebatePage.getCountOfAvrs(); i++) {
            assertTrue(volumeRebatePage.getPayoutOrRebateLabelForEachAvr(i).equals(payout) ||
                    volumeRebatePage.getPayoutOrRebateLabelForEachAvr(i).contains(currentRebate));
        }
    }

    @Then("^(.*) is displayed for AVR if Target is applicable.$")
    public void diffToNextTargetIsDisplayedForAVRIfTargetIsApplicable(String diffTONextTargetLabel) {
        for (int i = 1; i <= volumeRebatePage.getCountOfAvrs(); i++) {
            if (volumeRebatePage.isTargetApplicable(i)) {
                assertEquals(diffTONextTargetLabel, volumeRebatePage.getDiffToNextTargetLabel(i));
            }
        }
    }

    @Then("^(.*) is displayed if Target applicable.$")
    public void nextTargetIsDisplayedIfTargetApplicable(String nextTargetLabel) {
        for (int i = 1; i <= volumeRebatePage.getCountOfAvrs(); i++) {
            if (volumeRebatePage.isTargetApplicable(i)) {
                assertEquals(nextTargetLabel, volumeRebatePage.getNextTargetLabel(i));
            }
        }
    }

    @Then("^Calculator with (.*) and (.*) is displayed if Target is applicable.$")
    public void calculatorWithCustomerProjectionAndProjectionPayoutIsDisplayed(String customerProjection, String projectionPayout) {
        for (int i = 1; i <= volumeRebatePage.getCountOfAvrs(); i++) {
            if (volumeRebatePage.isTargetApplicable(i)) {
                assertTrue(volumeRebatePage.calculatorIsDisplayed(i));
                assertEquals(customerProjection, volumeRebatePage.getCustomerProjectionLabel(i));
                assertEquals(projectionPayout, volumeRebatePage.getProjectionPayoutLabel(i));
            }
        }
    }

    @Then("^Projection Payout is calculated correctly on the fly and user can save this value.$")
    public void projectionPayoutIsCalculatedOnTheFly() {
        for (int i = 1; i <= volumeRebatePage.getCountOfAvrs(); i++) {
            if (volumeRebatePage.isTargetApplicable(i)) {
                String[] dataTargets = volumeRebatePage.getDataTargets(i);
                String[] dataDiscounts = volumeRebatePage.getDataDiscounts(i);
                long customerProjectionValue = 0;
                float expectedProjectionPayout = 0;
                for (int j = 0; j < dataTargets.length; j++) {
                    customerProjectionValue = Long.parseLong(dataTargets[j]) + 1;
                    float dataDiscount = Float.parseFloat(dataDiscounts[j]);
                    volumeRebatePage.setCustomerProjectionValue(i, customerProjectionValue);
                    expectedProjectionPayout = (customerProjectionValue * dataDiscount) / 100;
                    assertEquals(expectedProjectionPayout, volumeRebatePage.getCalculatedPayoutValue(i), 0.01);
                }
                volumeRebatePage.saveProjectionPayout(i);
                utils.refreshCurrentPage();
                volumeRebatePage.expandAvr(i);
                assertEquals((float) customerProjectionValue, volumeRebatePage.getCustomerProjectionValue(i));
                assertEquals(expectedProjectionPayout, volumeRebatePage.getCalculatedPayoutValue(i), 0.01);
            }
        }
    }

    @Then("^Current payout sum equals to sum of current payout for each avr except (.*) type.$")
    public void currentPayoutSumEqualsToSumOfCurrentPayoutForEachAvrExceptMarketingType(String marketingType) {
        long currentPayoutSum = 0;
        for (int i = 1; i <= volumeRebatePage.getCountOfAvrs(); i++) {
            volumeRebatePage.expandAvr(i);
            if (!volumeRebatePage.getAvrTypeDescriptionWithoutPercentage(i).contains(marketingType)) {
                currentPayoutSum += volumeRebatePage.getCurrentPayoutForAvr(i);
            }
        }
        assertEquals(currentPayoutSum, Long.parseLong(volumeRebatePage.getCurrentPayoutTitle().replace("Current Payout: ", "").replace(",", "")));
    }
}
