package com.geempower.storefront.pages;

import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.geempower.storefront.page_elements.VolumeRebatePageElements.*;

@Component
public class VolumeRebatePage extends StorefrontBasePage {

    private final String pageUri = "annualVolumeRebate";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

    @Step("Get Count Of Avrs.")
    public int getCountOfAvrs() {
        waitUntilPageIsFullyLoaded();
        return $$(AVR_LIST_XPATH).size();
    }

    @Step("Get Page Title.")
    public String getPageTitle() {
        waitUntilPageIsFullyLoaded();
        return $(VOLUME_REBATE_PAGE_TITLE_XPATH).getText();
    }

    @Step("Get List Of Messages on the Volume rebate page.")
    public List<String> getListOfMessages() {
        return $$(LIST_OF_SETTLEMENT_PARTNER_AND_INFO_ERROR_MESSAGES_XPATH).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    @Step("Get Year Switcher Value.")
    public int getYearSwitcherValue() {
        return Integer.valueOf($(CURRENT_YEAR_SWITCHER_VALUE_XPATH).getText());
    }

    @Step("Get Currency Label.")
    public String getCurrencyLabel() {
        return $(CURRENCY_LABEL_XPATH).getText();
    }

    @Step("Get Current Payout Title.")
    public String getCurrentPayoutTitle() {
        return $(CURRENT_PAYOUT_LABEL_XPATH).getText();
    }

    @Step("Get See Details Label.")
    public String getSeeDetailsLabel() {
        return $(SEE_DETAILS_BELOW_VALUE_XPATH).getText();
    }

    @Step("Get Avr Id for all the available AVRs.")
    public List<String> getAvrsId() {
        List<String> avrIds = new ArrayList<>();
        for (int i = 1; i <= getCountOfAvrs(); i++) {
            avrIds.add($(APPROPRIATE_AVR_ID_XPATH, String.valueOf(i)).getText());
        }
        return avrIds;
    }

    @Step("Get Avr Type Description Without Percentage.")
    public String getAvrTypeDescriptionWithoutPercentage(int avrNumber) {
        String fullAvrTypeDescription = $(APPROPRIATE_AVR_TYPE_XPATH, String.valueOf(avrNumber)).getText();
        if (fullAvrTypeDescription.contains("%)")) {
            return fullAvrTypeDescription.split(" \\(")[0];
        } else
            return fullAvrTypeDescription;
    }

    @Step("Is Graph Displayed for appropriate avr.")
    public boolean isGraphDisplayed(int avrNumber) {
        return isDisplayed(GRAPH_FOR_APPROPRIATE_AVR_XPATH, String.valueOf(avrNumber));
    }

    @Step("Expand appropriate Avr.")
    public void expandAvr(int avrNumber) {
        waitUntilPageIsFullyLoaded();
        if ($(IS_AVR_EXPANDED_FLAG_XPATH, String.valueOf(avrNumber)).getAttribute("aria-expanded").equals("false")) {
            click(OPEN_APPROPRIATE_AVR_ICON_XPATH, String.valueOf(avrNumber));
        }
    }

    @Step("Get Next Target Value for appropriate Avr.")
    public String getNextTargetValue(int avrNumber) {
        String nextTargetValue = $(APPROPRIATE_NEXT_TARGET_VALUE_XPATH, String.valueOf(avrNumber)).getText();
        if (nextTargetValue.contains("Next Target")) {
            return "Next Target";
        } else {
            return nextTargetValue;
        }
    }

    @Step("Get Current Volume Label For Each Avr.")
    public String getCurrentVolumeLabelForEachAvr(int avrNumber) {
        return $(APPROPRIATE_AVR_CURRENT_VOLUME_LABEL_XPATH, String.valueOf(avrNumber)).getText();
    }

    @Step("Get Current Payout Label For Each Avr.")
    public String getCurrentPayoutLabelForEachAvr(int avrNumber) {
        return $(APPROPRIATE_AVR_CURRENT_PAYOUT_LABEL_XPATH, String.valueOf(avrNumber)).getText();
    }

    @Step("Get Target Reached Label For Each Avr.")
    public String getTargetReachedLabelForEachAvr(int avrNumber) {
        return $(APPROPRIATE_AVR_TARGET_REACHED_LABEL_XPATH, String.valueOf(avrNumber)).getText();
    }

    @Step("Get Payout Or Rebate Label For Each Avr.")
    public String getPayoutOrRebateLabelForEachAvr(int avrNumber) {
        return $(PAYOUT_OR_CURRENT_REBATE_LABEL_XPATH, String.valueOf(avrNumber)).getText();
    }

    @Step("Is Target Applicable.")
    public boolean isTargetApplicable(int avrNumber) {
        return !$(TARGET_REACHED_VALUE_XPATH, String.valueOf(avrNumber)).getText().equals("Not Applicable");
    }

    @Step("Get Diff To Next Target Label.")
    public String getDiffToNextTargetLabel(int avrNumber) {
        return $(DIFF_TO_NEXT_TARGET_LABEL_XPATH, String.valueOf(avrNumber)).getText();
    }

    @Step("Get Next Target Label.")
    public String getNextTargetLabel(int avrNumber) {
        return $(NEXT_TARGET_LABEL_XPATH, String.valueOf(avrNumber)).getText();
    }

    @Step("Calculator Is Displayed.")
    public boolean calculatorIsDisplayed(int avrNumber) {
        return isDisplayed(APPROPRIATE_AVR_CALCULATOR_XPATH, String.valueOf(avrNumber));
    }

    @Step("Get Customer Projection Label.")
    public String getCustomerProjectionLabel(int avrNumber) {
        return $(CALCULATOR_CUSTOMER_PROJECTION_LABEL_XPATH, String.valueOf(avrNumber)).getText();
    }

    @Step("Get Projection Payout Label.")
    public String getProjectionPayoutLabel(int avrNumber) {
        return $(CALCULATOR_PROJECTION_PAYOUT_LABEL_XPATH, String.valueOf(avrNumber)).getText();
    }

    @Step("Get Data Targets.")
    public String[] getDataTargets(int avrNumber) {
        String dataTarget = $(CALCULATOR_CUSTOMER_PROJECTION_FIELD_XPATH, String.valueOf(avrNumber)).getAttribute("data-target");
        return dataTarget.split(",");
    }

    @Step("Get Data Discounts.")
    public String[] getDataDiscounts(int avrNumber) {
        String dataDiscount = $(CALCULATOR_CUSTOMER_PROJECTION_FIELD_XPATH, String.valueOf(avrNumber)).getAttribute("data-discount");
        return dataDiscount.split(",");
    }

    public String getGuaranteedPercentage(int avrNumber) {
        return $(CALCULATOR_CUSTOMER_PROJECTION_FIELD_XPATH, String.valueOf(avrNumber)).getAttribute("data-guaranteed-rate");
    }

    @Step("Set Customer Projection Value.")
    public void setCustomerProjectionValue(int avrNumber, long customerProjectionValue) {
        $(CALCULATOR_CUSTOMER_PROJECTION_FIELD_XPATH, String.valueOf(avrNumber)).clear();
        $(CALCULATOR_CUSTOMER_PROJECTION_FIELD_XPATH, String.valueOf(avrNumber)).sendKeys(String.valueOf(customerProjectionValue));
    }

    @Step("Get Calculated Payout Value.")
    public float getCalculatedPayoutValue(int avrNumber) {
        return Float.parseFloat($(CALCULATOR_PROJECTION_PAYOUT_FIELD_XPATH, String.valueOf(avrNumber)).getAttribute("value").replace(",", ""));
    }

    @Step("Save Projection Payout.")
    public void saveProjectionPayout(int avrNumber) {
        waitUntilPageIsFullyLoaded();
        click(SAVE_PROJECTION_PAYOUT_ICON_XPATH, String.valueOf(avrNumber));
    }

    @Step("Get Customer Projection Value.")
    public float getCustomerProjectionValue(int avrNumber) {
        waitUntilPageIsFullyLoaded();
        return Float.parseFloat($(CALCULATOR_CUSTOMER_PROJECTION_FIELD_XPATH, String.valueOf(avrNumber)).getAttribute("value").replaceAll(",", ""));
    }

    @Step("Get Current Payout For Avr.")
    public long getCurrentPayoutForAvr(int avrNumber) {
        return Long.parseLong($(APPROPRIATE_AVR_CURRENT_PAYOUT_VALUE_XPATH, String.valueOf(avrNumber)).getText().replaceAll(",", ""));
    }
}
