package com.geempower.storefront.pages;

import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static com.geempower.storefront.page_elements.ShipmentsPageElements.*;

@Component
public class ShipmentsPage extends StorefrontBasePage {

    private final String pageUri = "aftership/dashboard";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

    @Step("Get Shipment title")
    public String getShipmentsTitle() {
        return $(SHIPMENTS_TITLE_XPATH).getText();
    }

    @Step("Color boxes are displayed")
    public boolean colorBoxesIsDisplayed() {
        return isDisplayed(COLOR_BOXES_XPATH);
    }

    @Step("Shipments table displayed")
    public boolean shipmentsTableHeaderIsDisplayed() {
        return isDisplayed(SHIPMENTS_TABLE_FILTERS_XPATH);
    }

    @Step("Click on Download button")
    public void clickOnDownloadButton() {
        click(DOWNLOAD_BUTTON_XPATH);
    }

    @Step("Get Chosen Filter by date value.")
    public String getChosenFilterValue() {
        return $(ACTIVE_N_SHIPMENTS_VALUE_XPATH).getText();
    }

    @Step("Get Count Of Shipments From Status Boxes.")
    public int getCountOfShipmentsFromStatusBoxes() {
        waitUntilPageIsFullyLoaded();
        click(EXPAND_ALL_STATUS_BOXES_XPATH);
        return $$(COUNT_OF_SHIPMENTS_IN_EACH_STATUS_XPATH).stream().map(s -> Integer.parseInt(s.getText())).mapToInt(Integer::intValue).sum();
    }

    @Step("Get Actual Count Of Shipments From Table.")
    public int getActualCountOfShipmentsFromTable() {
        int actualCountOfShipments = 0;
        int countOfPages = getCountOfPagesOnShipmentDashboard();
        if (countOfPages == 1) {
            actualCountOfShipments = $$(ALL_SHIPMENTS_IN_TABLE_XPATH).size();
        } else if (countOfPages > 1) {
            for (int i = 1; i <= countOfPages; i++) {
                actualCountOfShipments += $$(ALL_SHIPMENTS_IN_TABLE_XPATH).size();
                if (i != countOfPages) {
                    click(NEXT_SHIPMENT_PAGE_XPATH);
                }
                waitUntilPageIsFullyLoaded();
            }
        }
        return actualCountOfShipments;
    }

    private int getCountOfPagesOnShipmentDashboard() {
        int actualCount = 0;
        if (isPagingDisplayed()) {
            String countOfPages = $(COUNT_OF_PAGES_SHIPMENT_DASHBOARD_XPATH).getText();
            actualCount = Integer.parseInt(countOfPages.replace("of ", ""));
        } else if (!isPagingDisplayed()) {
            actualCount = 1;
        }
        return actualCount;
    }

    @Step("Open Last N Shipments Filter Dropdown.")
    public void openLastNShipmentsFilterDropdown() {
        waitUntilPageIsFullyLoaded();
        click(OPEN_LAST_N_SHIPMENTS_DROPDOWN_XPATH);
    }

    @Step("Select Count Of Shipments Filter value.")
    public void selectCountOfShipmentsFilter(String countOfShipments) {
        click(LAST_N_SHIPMENTS_VALUE_FILTER_XPATH, countOfShipments);
    }

    @Step("Check is Paging Displayed.")
    public boolean isPagingDisplayed() {
        waitUntilPageIsFullyLoaded();
        return isDisplayed(PAGING_XPATH);
    }

    @Step("Get Date For Each Shipment.")
    public List<WebElement> getDateForEachShipment() {
        return $$(ALL_DATES_XPATH);
    }
}
