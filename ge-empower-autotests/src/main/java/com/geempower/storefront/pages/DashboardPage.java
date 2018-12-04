package com.geempower.storefront.pages;

import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

import static com.geempower.storefront.page_elements.DashboardPageElements.*;

@Component
public class DashboardPage extends StorefrontBasePage {

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl();
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

    @Step("Check that order Status widget is displayed.")
    public boolean orderStatusWidgetIsDisplayed() {
        return isDisplayed(ORDER_STATUS_WIDGET_XPATH);
    }

    @Step("Check that Featured Updates widget is displayed.")
    public boolean featuredUpdatesWidgetIsDisplayed() {
        return isDisplayed(FEATURED_UPDATES_WIDGET_XPATH);
    }

    @Step("Check that order Search widget is displayed.")
    public boolean orderSearchWidgetIsDisplayed() {
        return isDisplayed(ORDER_SEARCH_WIDGET_XPATH);
    }

    @Step("Check that Price and Availability widget is displayed.")
    public boolean priceAndAvailabilityWidgetIsDisplayed() {
        return isDisplayed(PRICE_AND_AVAILABILITY_WIDGET_XPATH);
    }

    @Step("Check that Recent Orders widget is displayed.")
    public boolean recentOrdersWidgetIsDisplayed() {
        return isDisplayed(RECENT_ORDERS_WIDGET_XPATH);
    }

    @Step("Check that Recent List widget is displayed.")
    public boolean recentListWidgetIsDisplayed() {
        return isDisplayed(RECENT_LIST_WIDGET_XPATH);
    }

    @Step("Click on Skip training button.")
    public void skipTrainingLevel() {
        waitUntilPageIsFullyLoaded();
        if (isDisplayed(SKIP_BUTTON_XPATH)) {
            click(SKIP_BUTTON_XPATH);
        }
    }

    @Step("Click on Close Cookies button.")
    public void closeCookiesPopUp() {
        if (isDisplayed(By.id(CLOSE_COOKIES_BUTTON_ID))) {
            click(By.id(CLOSE_COOKIES_BUTTON_ID));
        }
    }

    @Step("Get account info.")
    public String getAccountInfo() {
        waitUntilPageIsFullyLoaded();
        return $(ACCOUNT_INFO_XPATH).getText();

    }

    @Step("Select Address from address field.")
    public String selectAddressFromAddressField() {
        waitUntilPageIsFullyLoaded();
        return $(By.id(SELECT_SHIP_ADDRESS_FIELD_ID)).getText();
    }

    @Step("Click on Submit button.")
    public void clickOnSubmitButton() {
        click(SUBMIT_SHIP_ADDRESS_BUTTON_XPATH);
    }

    @Step("Close we are now ABB pop-up.")
    public void closeWeAreNowAbbPopUpIfPresent() {
        if (isDisplayed(WE_ARE_NOW_ABB_POP_UP_XPATH)) {
            click(WE_ARE_NOW_ABB_OK_BUTTON_XPATH);
            waitUntilPageIsFullyLoaded();
        }
    }

    @Step("Search Order Via Order Search Field.")
    public void searchOrderViaOrderSearchField(String orderNo) {
        waitUntilPageIsFullyLoaded();
        $(ORDER_SEARCH_INPUT_XPATH).clear();
        $(ORDER_SEARCH_INPUT_XPATH).sendKeys(orderNo);
        click(SEARCH_ORDER_BY_PARAMS_BUTTON_XPATH);
    }

    @Step("Check if T&B widget displayed on Dashboard.")
    public boolean isTnBWidgetDisplayed() {
        waitUntilPageIsFullyLoaded();
        return isDisplayed(T_AND_B_ACCESS_WIDGET_XPATH);
    }

    @Step("Get T&B Access Widget Title.")
    public String getTnBAccessWidgetTitle() {
        waitUntilPageIsFullyLoaded();
        return $(T_AND_B_ACCESS_WIDGET_TITLE_XPATH).getText();
    }

    @Step("Click On T&B Access Button And Get Site Url.")
    public String clickOnTandBAccessButtonAndGetSiteUrl() {
        String oldTab = getDriver().getWindowHandle();
        click(T_AND_B_ACCESS_BUTTON_XPATH);
        waitUntilPageIsFullyLoaded();
        ArrayList<String> newTab = new ArrayList<>(getDriver().getWindowHandles());
        newTab.remove(oldTab);
        getDriver().switchTo().window(newTab.get(0));
        waitUntilPageIsFullyLoaded();
        String currentUrl = getDriver().getCurrentUrl();
        getDriver().close();
        getDriver().switchTo().window(oldTab);
        return currentUrl;
    }

    @Step("Get Title From Features Widget.")
    public String getTitleFromFeaturesWidget() {
        return $(FEATURED_UPDATES_WIDGET_TITLE_XPATH).getText();
    }

    @Step("Get View All Link Name.")
    public String getViewAllLinkName() {
        return $(FEATURED_UPDATES_WIDGET_VIEW_ALL_LINK_XPATH).getText();
    }

    @Step("Get View All Url.")
    public String getViewAllUrl() {
        return $(FEATURED_UPDATES_WIDGET_VIEW_ALL_LINK_XPATH).getAttribute("href");
    }

    @Step("Get count of features on the Dashboard page.")
    public int getCountOfFeatures() {
        return $$(COUNT_OF_AVAILABLE_FEATURES_XPATH).size();
    }

    @Step("Open Account Info Dropdown.")
    public void openAccountInfoDropdown() {
        waitUntilPageIsFullyLoaded();
        click(ACCOUNT_INFO_DROPDOWN_XPATH);
    }

    @Step("Get Count Of Favorite Accounts In Account Info Dropdown.")
    public int getCountOfFavoriteAccountsInAccountInfoDropdown() {
        return Integer.parseInt($(COUNT_OF_FAVORITE_ACCOUNTS_XPATH).getText().replace("Favorites (", "").replace(")", ""));
    }

    @Step("Get List Of Favorite Accounts From Account Info Dropdown.")
    public List<WebElement> getListOfFavoriteAccountsFromAccountInfoDropdown() {
        return $$(LIST_OF_FAVORITE_ACCOUNTS_XPATH);
    }

    @Step("Get Account info drop down message In Red Block.")
    public String getAccountInfoDropDownMessageInRedBlock() {
        return $(ACCOUNT_INFO_DROPDOWN_MESSAGE_IN_RED_BLOCK_IN_XPATH).getText();
    }

    @Step("Is Red Triangle Icon Displayed Near Account No.")
    public boolean isRedTriangleIconDisplayedNearAccountNo() {
        waitUntilPageIsFullyLoaded();
        return isDisplayed(RED_TRIANGLE_ICON_NEAR_ACCOUNT_NO_XPATH);
    }

    @Step("Get Expired Tax Cert Pop Up Title.")
    public String getExpiredTaxCertPopUpTitle() {
        return $(EXPIRED_TAX_CERT_POP_UP_TITLE_XPATH).getText();
    }

    @Step("Is Expired Tax Cert Pop Up Displayed.")
    public boolean isExpiredTaxCertPopUpDisplayed() {
        waitUntilPageIsFullyLoaded();
        return isDisplayed(EXPIRED_TAX_CERT_POP_UP_XPATH);
    }

    @Step("User Clicks On Here Link.")
    public void userClicksOnHereLink() {
        click(By.id(HERE_LINK_IN_ACCOUNT_INFO_DROP_DOWN_ID));
    }

    @Step("Get Main Text In Expired TAX Certificate Pop Up.")
    public String getMainTextInExpiredTAXCertificatePopUp() {
        return $(MAIN_TEXT_IN_EXPIRED_TAX_CERT_POP_UP_XPATH).getText();
    }

    @Step("User Clicks On Dismiss Button.")
    public void userClicksOnDismissButton() {
        click(DISMISS_BUTTON_XPATH);
    }

    @Step("Is Avr Widget Displayed.")
    public boolean isAvrWidgetDisplayed() {
        waitUntilPageIsFullyLoaded();
        return isDisplayed(AVR_WIDGET_XPATH);
    }

    @Step("Get Avr Widget Title.")
    public String getAvrWidgetTitle() {
        waitUntilPageIsFullyLoaded();
        return $(AVR_WIDGET_TITLE_XPATH).getText();
    }

    @Step("Get Avr Currency Label.")
    public String getAvrCurrencyLabel() {
        waitUntilPageIsFullyLoaded();
        return $(By.id(AVR_CURRENCY_TITLE_ID)).getText();
    }

    @Step("Get Min Count Of Avrs.")
    public int getMinCountOfAvrs() {
        waitUntilPageIsFullyLoaded();
        return $$(AVR_MIN_COUNT_ON_DASHBOARD_XPATH).size();
    }

    @Step("Get Avr Rebate Company Name.")
    public String getAvrRebateCompanyName() {
        waitUntilPageIsFullyLoaded();
        return $(ACTIVE_AVR_REBATE_COMPANY_NAME_XPATH).getText();
    }

    @Step("Is Current Payout Displayed.")
    public String isCurrentPayoutDisplayed() {
        return $(CURRENT_PAYOUT_TITLE_XPATH).getText();
    }

    @Step("Is Current Volume Displayed.")
    public String isCurrentVolumeDisplayed() {
        return $(CURRENT_VOLUME_TITLE_XPATH).getText();
    }

    @Step("Is Ytd Payout Displayed.")
    public String isYtdPayoutDisplayed() {
        return $(YTD_PAYOUT_TITLE_XPATH).getText();
    }

    @Step("Get Ytd Payout.")
    public String getYtdPayout() {
        return $(YTD_PAYOUT_VALUE_XPATH).getText();
    }

    @Step("Get Current Volume.")
    public String getCurrentVolume() {
        return $(CURRENT_VOLUME_VALUE_XPATH).getText();
    }

    @Step("Select Appropriate Avr on the Dashboard.")
    public void selectAppropriateAvr(int avrNumber) {
        waitUntilPageIsFullyLoaded();
        click(APPROPRIATE_AVR_ON_THE_DASHBOARD_XPATH, String.valueOf(avrNumber));
    }

    @Step("Get Avr Type Description Without Percentage.")
    public String getAvrTypeDescriptionWithoutPercentage(int avrNumber) {
        waitUntilPageIsFullyLoaded();
        String fullAvrDescription = $(AVR_TYPE_DESCRIPTION_XPATH, String.valueOf(avrNumber)).getText();
        if (fullAvrDescription.contains("%)")) {
            return fullAvrDescription.split(" \\(")[0];
        } else
            return fullAvrDescription;
    }

    @Step("Get Avr Target Description Without Price.")
    public String getAvrTargetDescriptionWithoutPrice(int avrNumber) {
        waitUntilPageIsFullyLoaded();
        return $(APPROPRIATE_AVR_TARGET_LABEL_XPATH, String.valueOf(avrNumber)).getText();
    }

    @Step("Click To The Active Avr Link.")
    public void clickToTheActiveAvrLink() {
        click(ACTIVE_AVR_LINK_TO_ANNUAL_REBATE_PAGE_XPATH);
    }
}