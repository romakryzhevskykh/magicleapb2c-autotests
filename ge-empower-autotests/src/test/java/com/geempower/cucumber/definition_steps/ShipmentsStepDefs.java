package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.Utils;
import com.geempower.storefront.pages.ShipmentsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ShipmentsStepDefs extends AbstractStepDefs {
    @Autowired
    private ShipmentsPage shipmentsPage;
    @Autowired
    private Utils utils;

    @When("^(.*) title is displayed on Shipments page.$")
    public void checkShipmentsTitle(String shipmentTitle) {
        assertEquals(shipmentsPage.getShipmentsTitle(), shipmentTitle);
    }

    @And("^Color boxes are displayed on Shipments page.$")
    public void colorBoxesIsDisplayed() {
        assertTrue(shipmentsPage.colorBoxesIsDisplayed());
    }

    @And("^Shipment table header is displayed on Shipments page.$")
    public void shipmentsTableHeaderIsDisplayed() {
        assertTrue(shipmentsPage.shipmentsTableHeaderIsDisplayed());
    }

    @When("^Click on Download button on Shipments page.$")
    public void clickOnDownloadButtonOnShipmentsPage() {
        shipmentsPage.clickOnDownloadButton();
    }

    @Then("^(.*) filter is displayed by default.$")
    public void lastShipmentsFilterIsDisplayedByDefault(String filterValue) {
        assertEquals(filterValue, shipmentsPage.getChosenFilterValue());
    }

    @Then("^Sum of all shipments in status boxes are equal to (\\d+).$")
    public void sumOfAllShipmentsInStatusBoxesAreEqualTo(int expectedCountOfShipments) {
        assertTrue(shipmentsPage.getCountOfShipmentsFromStatusBoxes() == expectedCountOfShipments);
    }

    @Then("^All (\\d+) shipments are available on the Shipments page.$")
    public void allShipmentsAreAvailableOnTheShipmentsPage(int expectedCountOfShipments) {
        assertTrue(shipmentsPage.getActualCountOfShipmentsFromTable() == expectedCountOfShipments);
    }

    @When("^User opens lastNFilters dropdown.$")
    public void userOpensLastNFiltersDropdown() {
        shipmentsPage.openLastNShipmentsFilterDropdown();
    }

    @And("^Select Last (.*) shipments filter.$")
    public void selectLastShipmentsFilter(String countOfShipments) {
        shipmentsPage.selectCountOfShipmentsFilter(countOfShipments);
    }

    @Then("^Sum of all shipments in status boxes is more than (\\d+) and less or equals to (\\d+).$")
    public void sumOfAllShipmentsInStatusBoxesIsInTheCorrectBoundary(int min, int max) {
        int actualSumInStatusBoxes = shipmentsPage.getCountOfShipmentsFromStatusBoxes();
        threadVarsHashMap.put(TestKeyword.AVAILABLE_COUNT_OF_SHIPMENTS, actualSumInStatusBoxes);
        assertTrue(actualSumInStatusBoxes > min && actualSumInStatusBoxes <= max);
    }

    @Then("^Appropriate count of shipments is available on the Shipments page.$")
    public void appropriateCountOfShipmentsIsAvailableOnTheShipmentsPage() {
        assertTrue(shipmentsPage.getActualCountOfShipmentsFromTable() == (int) threadVarsHashMap.get(TestKeyword.AVAILABLE_COUNT_OF_SHIPMENTS));
    }

    @Then("^Paging for shipment dashboard is displayed.$")
    public void pagingForShipmentDashboardIsDisplayed() {
        assertTrue(shipmentsPage.isPagingDisplayed());
    }

    @Then("^Ship date is from week range.$")
    public void shipDateIsFromWeekRange() throws ParseException {
        String currentDate = utils.getCurrentDate();
        shipmentsPage.getDateForEachShipment().forEach(date -> {
            try {
                assertTrue(utils.getDifferenceBetweenTwoDays(currentDate, date.getText()) <= 8);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
    }
}
