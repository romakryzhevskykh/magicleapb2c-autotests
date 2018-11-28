package com.geempower.storefront.pages.order;

import com.geempower.helpers.Utils;
import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.stream.Stream;

import static com.geempower.storefront.page_elements.order.OrdersPageElements.*;

@Component
public class OrdersPage extends StorefrontBasePage {
    @Autowired
    private Utils utils;

    private final String pageUri = "user/viewOrderHistory.action";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Step("Get Orders title")
    public String getOrdersTitle() {
        return $(ORDERS_TITLE_XPATH).getText();
    }

    private int getCountOfPagesWithOrders() {
        String countOfPages = $(COUNT_OF_PAGES_WITH_ORDERS_XPATH).getText();
        int actualCount = 0;
        if (!countOfPages.equals("")) {
            actualCount = Integer.parseInt(countOfPages.replace("of ", ""));
        } else if (!isOrdersTableEmpty() && countOfPages.equals("")) {
            actualCount = 1;
        } else if (isOrdersTableEmpty()) {
            actualCount = 0;
        }
        return actualCount;
    }

    private boolean isOrdersTableEmpty() {
        try {
            return $(EMPTY_ORDERS_TABLE_XPATH).isDisplayed();
        } catch (NoSuchElementException | NullPointerException exception) {
            return false;
        }
    }

    @Step("Get actual count of orders with appropriate status.")
    public int getActualCountOfOrders() {
        int ordersCount = 0;
        int actualCountOfOrderPages = getCountOfPagesWithOrders();
        if (actualCountOfOrderPages != 0) {
            for (int i = 0; i < actualCountOfOrderPages; i++) {
                ordersCount += $$(ORDER_TABLE_SIZE_PER_PAGE_XPATH).size();
                if (i != actualCountOfOrderPages - 1) {
                    click(NEXT_ORDER_PAGE_XPATH);
                }
                waitUntilPageIsFullyLoaded();
            }
        }
        return ordersCount;
    }

    @Step("Open Appropriate Order By Status.")
    public void openAppropriateOrderByStatus(String orderStatus) {
        waitUntilPageIsFullyLoaded();
        try {
            click(FIRST_ORDER_IN_APPROPRIATE_STATUS_XPATH, orderStatus);
        } catch (NullPointerException ex) {
            System.err.println("There is no order in " + orderStatus + " status" + ex);
        }
    }

    @Step("Sort Orders Table By Status.")
    public void sortOrdersTableByStatus() {
        waitUntilPageIsFullyLoaded();
        for (int i = 0; i < 2; i++) {
            click(By.id(SORTING_ORDERS_TABLE_ICON_BY_STATUS_ID));
        }
    }

    @Step("Get current page url.")
    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    @Step("Click On Order By Order No.")
    public void clickOnOrderByOrderNo(String orderNo) {
        waitUntilPageIsFullyLoaded();
        click(ORDER_LINK_BY_ORDER_NO_XPATH, orderNo);
    }

    @Step("User click on random order No.")
    public StringBuilder userClickOnRandomOrderNo() {
        StringBuilder orderNo = new StringBuilder("");
        $$(LIST_OF_ORDER_NO_LINKS_XPATH).stream().findAny().ifPresent(webElement -> {
            orderNo.append(webElement.getText());
            click(webElement);
        });
        return orderNo;
    }

    @Step("Get Open Order Message.")
    public String getOpenOrderMessage() {
        waitUntilPageIsFullyLoaded();
        return $(OPEN_ORDER_REPORT_TEXT_XPATH).getText();
    }

    @Step("Click On Open Order Report Window Button.")
    public void clickOnOpenOrderReportWindowButton() {
        click(OPEN_ORDER_REPORT_OPEN_BUTTON_XPATH);
    }

    @Step("Get Open Order Report Window Title.")
    public String getOpenOrderReportWindowTitle() {
        waitUntilPageIsFullyLoaded();
        return $(OPEN_ORDER_REPORT_WINDOW_TITLE_XPATH).getText();
    }

    @Step("Select Pricing Option.")
    public void selectPricingOption(String pricingOption) {
        click(OPEN_PRICING_OPTIONS_ICON_XPATH);
        waitUntilPageIsFullyLoaded();
        click(PRICING_OPTION_BY_OPTION_LABEL_XPATH, pricingOption);
    }

    @Step("Click On Generate Now Open Order Report Button.")
    public void clickOnGenerateNowOpenOrderReportButton() {
        click(GENERATE_NOW_OPEN_ORDER_REPORT_BUTTON_XPATH);
    }

    @Step("Get Post Report Date.")
    public String getPostReportDate() {
        waitUntilPageIsFullyLoaded();
        return $(OPEN_ORDER_REPORT_FIRST_ROW_POST_DATE_XPATH).getText();
    }

    @Step("Get Post Report Pricing Option.")
    public String getPostReportPricingOption() {
        waitUntilPageIsFullyLoaded();
        return $(OPEN_ORDER_REPORT_FIRST_ROW_PRICING_OPTION_XPATH).getText();
    }

    @Step("Get Post Report Comment.")
    public String getPostReportComment() {
        waitUntilPageIsFullyLoaded();
        return $(OPEN_ORDER_REPORT_FIRST_ROW_COMMENT_XPATH).getText();
    }

    @Step("Close The Open Orders Report Window.")
    public void closeTheOpenOrdersReportWindow() {
        waitUntilPageIsFullyLoaded();
        click(OPEN_ORDER_REPORT_WINDOW_CLOSE_ICON_XPATH);
    }

    @Step("Open filter on Orders page.")
    public void clickOnFilterOrderIcon() {
        click(FILTER_ORDERS_ICON_XPATH);
    }

    @Step("Set Order No To The Search Field For Filtering.")
    public void setOrderNoToTheSearchFieldForFiltering(String orderNo) {
        waitUntilPageIsFullyLoaded();
        $(ORDER_NO_FIELD_FILTER_SLIDER_XPATH).clear();
        $(ORDER_NO_FIELD_FILTER_SLIDER_XPATH).sendKeys(orderNo);
    }

    @Step("Click On Apply Filter Button.")
    public void clickOnApplyFilterButton() {
        click(APPLY_FILTER_BUTTON_XPATH);
    }

    @Step("Get First Order Number From Orders List.")
    public String getFirstOrderNumberFromOrdersList() {
        return $(FIRST_ORDER_NUMBER_FROM_ORDERS_LIST_XPATH).getText();
    }

    @Step("Click On First Order Number.")
    public void clickOnFirstOrderNumber() {
        click(FIRST_ORDER_NUMBER_FROM_ORDERS_LIST_XPATH);
    }

    @Step("Get Random Po Number From Orders List.")
    public String getRandomPoNumberFromOrdersList() {
        waitUntilPageIsFullyLoaded();
        return $$(ALL_PO_NUMBERS_PER_PAGE_XPATH).stream().findAny().get().getText();
    }

    @Step("Set Po Number To The Search Field For Filtering.")
    public void setPoNumberToTheSearchFieldForFiltering(String poNo) {
        waitUntilPageIsFullyLoaded();
        $(PO_NO_FIELD_FILTER_SLIDER_XPATH).clear();
        $(PO_NO_FIELD_FILTER_SLIDER_XPATH).sendKeys(poNo);
    }

    @Step("Get All Po Numbers From Orders List.")
    public Stream<WebElement> getAllPoNumbersFromOrdersList() {
        waitUntilPageIsFullyLoaded();
        return $$(ALL_PO_NUMBERS_PER_PAGE_XPATH).stream();
    }

    @Step("Get Random Job Name From Orders List.")
    public String getRandomJobNameFromOrdersList() {
        return $$(ALL_JOB_NAMES_PER_PAGE_XPATH).stream().filter(jobName ->
                !jobName.getText().equals("")).findFirst().get().getText();
    }

    @Step("Set Job Name To The Search Field For Filtering.")
    public void setJobNameToTheSearchFieldForFiltering(String jobName) {
        waitUntilPageIsFullyLoaded();
        $(JOB_NAME_FIELD_FILTER_SLIDER_XPATH).clear();
        $(JOB_NAME_FIELD_FILTER_SLIDER_XPATH).sendKeys(jobName);
    }

    @Step("Get All Job Names From Orders List.")
    public Stream<WebElement> getAllJobNamesFromOrdersList() {
        waitUntilPageIsFullyLoaded();
        return $$(ALL_JOB_NAMES_PER_PAGE_XPATH).stream();
    }

    @Step("Get Random Date Name From Orders List.")
    public String getRandomDateNameFromOrdersList() {
        return $$(ALL_DATES_PER_PAGE_XPATH).stream().findAny().get().getText();
    }

    @Step("Set Date From To The Search Field For Filtering.")
    public void setDateFromToTheSearchFieldForFiltering(String date) {
        waitUntilPageIsFullyLoaded();
        String convertedDate = utils.convertStringDateToStringValues(date);
        String month = convertedDate.substring(4, 7).trim();
        String day = convertedDate.substring(8, 10).trim();
        String year = convertedDate.substring(24).trim();
        click(DATE_FROM_FIELD_FILTER_SLIDER_XPATH);
        String currentMonthAndYearInCalendar = $(CURRENT_MONTH_AND_YEAR_XPATH).getText();
        while (!(currentMonthAndYearInCalendar.startsWith(month) && currentMonthAndYearInCalendar.endsWith(year))) {
            click(PREVIOUS_MONTH_ICON_XPATH);
            currentMonthAndYearInCalendar = $(CURRENT_MONTH_AND_YEAR_XPATH).getText();
        }
        click(NEEDED_DAY_XPATH, day);
    }

    @Step("Get All Dates From Orders List.")
    public Stream<WebElement> getAllDatesFromOrdersList() {
        waitUntilPageIsFullyLoaded();
        return $$(ALL_DATES_PER_PAGE_XPATH).stream();
    }

    @Step("User click on random PO No.")
    public StringBuilder userClickOnRandomPONo() {
        StringBuilder orderNo = new StringBuilder("");
        $$(ALL_PO_NUMBERS_PER_PAGE_XPATH).stream().findAny().ifPresent(webElement -> {
            orderNo.append(webElement.getText());
            click(webElement);
        });
        return orderNo;
    }
}