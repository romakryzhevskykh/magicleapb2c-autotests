package com.geempower.storefront.pages.returns;

import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.stream.Stream;

import static com.geempower.storefront.page_elements.returns.ReturnsPageElements.*;

@Component
public class ReturnsPage extends StorefrontBasePage {
    private final String pageUri = "returnTracking";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

    @Step("Get Returns title.")
    public String getReturnsTitle() {
        return $(CASES_TITLE_XPATH).getText();
    }

    @Step("Click on Create Request Button.")
    public void clickOnCreateRequestButton() {
        click(By.id(CREATE_REQUEST_BUTTON_ID));
    }

    @Step("Open Saved Requests Tab.")
    public void openSavedRequestsTab() {
        waitUntilPageIsFullyLoaded();
        click(SAVED_REQUEST_TAB_XPATH);
    }

    @Step("Get Last Saved Return Name.")
    public String getLastSavedReturntName() {
        waitUntilPageIsFullyLoaded();
        return $(LAST_SAVED_RETURN_NAME_XPATH).getText();
    }

    @Step("Edit Appropriate Saved Return.")
    public void editAppropriateReturn(String savedReturn) {
        click(EDIT_ICON_FOR_APPROPRIATE_RETURN_XPATH, savedReturn);
    }

    @Step("Delete Appropriate Saved Return.")
    public void deleteAppropriateReturn(String savedReturn) {
        click(DELETE_ICON_FOR_APPROPRIATE_RETURN_XPATH, savedReturn);
    }

    @Step("Get Updated Sent Requests Tab.")
    public void getUpdatedSentRequestsTab(int allReturnsQuantity) {
        waitUntilPageIsFullyLoaded();
        int counter = 0;
        try {
            do {
                getDriver().navigate().refresh();
                counter++;
            }
            while (!isSentRequestTabFullyUpdated(allReturnsQuantity) && counter < 5);
            waitUntilPageIsFullyLoaded();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }

    private boolean isSentRequestTabFullyUpdated(int allReturnsQuantity) {
        return Integer.parseInt($(ALL_RETURNS_QUANTITY_XPATH).getText()) == allReturnsQuantity;
    }

    @Step("Get All Returns Quantity.")
    public int getAllReturnsQuantity() {
        return Integer.parseInt($(ALL_RETURNS_QUANTITY_XPATH).getText());
    }

    @Step("Get Last Added Return.")
    public String getLastAddedReturn() {
        return $(LAST_ADDED_RETURN_XPATH).getText();
    }

    @Step("Get All Returns Confirmation No.")
    public Stream<WebElement> getAllReturnsConfirmationNo() {
        waitUntilPageIsFullyLoaded();
        return $$(ALL_RETURNS_CONFIRM_NO_XPATH).stream();
    }

    @Step("Is Saved Requests Table Displayed.")
    public boolean isSavedRequestsTableDisplayed() {
        return isDisplayed(SAVED_REQUEST_TABLE_XPATH);
    }

    @Step("Get Window Title.")
    public String getWindowTitle() {
        waitUntilPageIsFullyLoaded();
        return getDriver().getTitle();
    }

    @Step("Get Access Denied Page Title.")
    public String getAccessDeniedPageTitle() {
        return $(ACCESS_DENIED_TITLE_RETURNS_PAGE_XPATH).getText();
    }

    @Step("Get Access Denied Page Sub-Title.")
    public String getAccessDeniedPageSubTitle() {
        return $(ACCESS_DENIED_SUB_TITLE_RETURNS_PAGE_XPATH).getText();
    }

    @Step("Get Return Home Button Name.")
    public String getReturnHomeButtonName() {
        return $(ACCESS_DENIED_GO_HOME_BUTTON_XPATH).getText();
    }

    @Step("Click On Filter Returns Icon.")
    public void clickOnFilterReturnsIcon() {
        click(RETURN_FILTER_ICON_XPATH);
    }

    @Step("Select Appropriate Status In The Case Status Drop Down Field.")
    public void selectAppropriateStatusInTheCaseStatusDropDownField(String status) {
        waitUntilPageIsFullyLoaded();
        click(CASE_STATUS_DROP_DOWN_ARROW_XPATH);
        waitUntilPageIsFullyLoaded();
        click(APPROPRIATE_DROP_DOWN_ITEM_XPATH, status);
    }

    @Step("Click On Apply Filter Button On Returns Page.")
    public void clickOnApplyFilterButtonOnReturnsPage() {
        waitUntilPageIsFullyLoaded();
        click(APPLY_BUTTON_IN_FILTERS_XPATH);
    }

    @Step("Get Status Of Opened Return.")
    public String getStatusOfOpenedReturn() {
        waitUntilPageIsFullyLoaded();
        return $(RETURN_STATUS_XPATH).getText();
    }

    @Step("Click On Case No In Opened Return block.")
    public void clickOnCaseNoInOpenedReturn() {
        click(CASE_NO_LINK_IN_OPENED_RETURN_BLOCK_XPATH);
    }

    @Step("Get Case No In Opened Return block.")
    public String getCaseNoInOpenedReturn() {
        return $(CASE_NO_LINK_IN_OPENED_RETURN_BLOCK_XPATH).getText();
    }

    @Step("Is Filter Slider Displayed.")
    public boolean isFilterSliderDisplayed() {
        waitUntilPageIsFullyLoaded();
        return isDisplayed(FILTER_SLIDER_XPATH);
    }
}