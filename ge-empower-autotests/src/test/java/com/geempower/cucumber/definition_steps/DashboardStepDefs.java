package com.geempower.cucumber.definition_steps;

import com.geempower.storefront.page_blocks.PriceAndAvailabilityBlock;
import com.geempower.storefront.pages.DashboardPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DashboardStepDefs extends AbstractStepDefs {
    @Autowired
    private DashboardPage dashboardPage;
    @Autowired
    private PriceAndAvailabilityBlock priceAndAvailabilityBlock;

    @And("^Order Status widget is displayed.$")
    public void orderStatusWidgetIsDisplayed() {
        assertTrue(dashboardPage.orderStatusWidgetIsDisplayed());
    }

    @And("^Featured Updates widget is displayed.$")
    public void featuredUpdatesWidgetIsDisplayed() {
        assertTrue(dashboardPage.featuredUpdatesWidgetIsDisplayed());
    }

    @And("^Order Search widget is displayed.$")
    public void orderSearchWidgetIsDisplayed() {
        assertTrue(dashboardPage.orderSearchWidgetIsDisplayed());
    }

    @And("^Price and Availability widget is displayed.$")
    public void priceAndAvailabilityWidgetIsDisplayed() {
        assertTrue(dashboardPage.priceAndAvailabilityWidgetIsDisplayed());
    }

    @And("^Recent Orders widget is displayed.$")
    public void recentOrdersWidgetIsDisplayed() {
        assertTrue(dashboardPage.recentOrdersWidgetIsDisplayed());
    }

    @Then("^Recent Lists widget is displayed.$")
    public void recentListWidgetIsDisplayed() {
        assertTrue(dashboardPage.recentListWidgetIsDisplayed());
    }

    @When("^Click on Skip button.$")
    public void clickOnSkipButton() {
        dashboardPage.skipTrainingLevel();
    }

    @When("^Close cookies pop-up.$")
    public void clickOnCloseCookieButton() {
        dashboardPage.closeCookiesPopUp();
        dashboardPage.waitUntilPageIsFullyLoaded();
    }

    @Then("^Check that Dashboard page is opened.")
    public void isDashboardPageOpened() {
        assertTrue(dashboardPage.isOpened());
    }

    @Then("^Chosen account is displayed in account box on Dashboard page.$")
    public void chosenAccountIsDisplayedInAccountsBoxOnDashboardPage() {
        String chosenAccount = threadVarsHashMap.getString(TestKeyword.CHOSEN_ACCOUNT);
        assertTrue(dashboardPage.isSelectedAccountIsDisplayed().contains(chosenAccount));
    }

    @And("^Click on P&A button.$")
    public void clickOnPAButton() {
        priceAndAvailabilityBlock.clickOnCheckPAButton();
    }

    @When("^User set catalogueNo to Copy & Paste field.$")
    public void userSetCatalogueNoToCopyPasteField() {
        threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        String catalogueNo = getSelectedProducts().keySet().stream().findAny().get().getCatalogueNo();
        priceAndAvailabilityBlock.setCatalogueNoToTheCopyAndPasteField(catalogueNo);
    }

    @When("^User set chosen catalogueNo to the Product Number field.$")
    public void userSetCatalogueNoToProductField() {
        threadVarsHashMap.get(TestKeyword.SELECTED_PRODUCTS);
        String catalogueNo = getSelectedProducts().keySet().stream().findAny().get().getCatalogueNo();
        priceAndAvailabilityBlock.setCatalogueNoToProductField(catalogueNo);
    }

    @When("^User set (.*) to Product Number field.$")
    public void userSetCatalogueNoToProductField(String catalogNo) {
        priceAndAvailabilityBlock.setCatalogueNoToProductField(catalogNo);
    }

    @And("^Select address from address field.$")
    public void selectAddressFromAddressField() {
        threadVarsHashMap.put(TestKeyword.LA_SHIP_ADDRESS, dashboardPage.selectAddressFromAddressField());
    }

    @And("^Click on Submit button.$")
    public void clickOnSubmitButton() {
        dashboardPage.clickOnSubmitButton();
    }

    @Then("^User is able to use GE site.$")
    public void userIsAbleToUseGESite() {
        dashboardPage.open();
        assertTrue(dashboardPage.isOpened());
    }

    @When("^User add list of (.*) products to the Copy&Paste block.$")
    public void userAddProductsToTheCopyPasteBlock(List<String> products) {
        priceAndAvailabilityBlock.addItemsToTheCopyPasteBlock(products);
    }

    @When("^Admin clicks on the feedback button.$")
    public void adminClicksOnTheFeedbackButton() {
        dashboardPage.clickOnTheFeedbackButton();
    }

    @Then("^(.*) title is displayed in the feedback pop-up.$")
    public void helpUsImproveTitleIsDisplayedInTheFeedbackPopUp(String feedbackTitle) {
        assertEquals(feedbackTitle, dashboardPage.getFeedbackPopUpTitle());
    }

    @Then("^(.*) labels are present in the feedback pop-up.$")
    public void greatOkConfusingFrustratingLabelsArePresentInTheFeedbackPopUp(List<String> emojies) {
        emojies.forEach(emoji -> assertTrue(dashboardPage.isEmojiDisplayedInTheFeedbackPopUp(emoji)));

    }

    @Then("^Include screenshot checkbox is checked by default.$")
    public void includeScreenshotCheckboxIsCheckedByDefault() {
        assertTrue(dashboardPage.isCheckboxIncludeScreenshotSelected());
    }

    @When("^Admin sets (.*) to the feedback input.$")
    public void adminSetsTestTextToTheFeedbackInput(String text) {
        dashboardPage.setTextToTheFeedbackInput(text);
    }

    @And("^Clicks on the Submit button.$")
    public void clicksOnTheSubmitButton() {
        dashboardPage.submitFeedback();
    }

    @Then("^(.*) text is displayed in successful pop-up.$")
    public void isCorrectTextIsDisplayedInSuccessfulPopUp(String successfulFeedbackText) {
        assertEquals(successfulFeedbackText, dashboardPage.getResultTextFromFeedbackPopUp());
    }

    @And("^Admin clicks on OK button in the successful feedback pop-up.$")
    public void adminClicksOnOKButtonInTheSuccessfulFeedbackPopUp() {
        dashboardPage.clickOkOnTheFeedbackPopUp();
    }
}