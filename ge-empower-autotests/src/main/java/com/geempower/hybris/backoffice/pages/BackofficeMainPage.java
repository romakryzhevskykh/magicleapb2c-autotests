package com.geempower.hybris.backoffice.pages;

import com.geempower.helpers.Utils;
import com.geempower.hybris.backoffice.BackofficeBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.hybris.backoffice.page_elements.BackofficeMainPageElements.*;

@Component
public class BackofficeMainPage extends BackofficeBasePage {
    @Autowired
    private Utils utils;

    @Override
    public String getPageUrl() {
        return templateBackoffice.getBaseUrl();
    }

    @Step("Is Commerce Logo Displayed.")
    public boolean isCommerceLogoDisplayed() {
        System.out.println("User has been redirected to tne main backoffice page: " + utils.getLocalDateTimeStamp());
        waitUntilPageIsFullyLoaded();
        loadBackofficeIfNeeded();
        return isDisplayed(COMMERCE_LOGO_XPATH);
    }

    @Step("Load Backoffice If Needed.")
    private void loadBackofficeIfNeeded() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        if ((Boolean) js.executeScript("return jQuery.active == 0")) {
            if (!isDisplayed(COMMERCE_LOGO_XPATH)) {
                utils.refreshCurrentPage();
            }
        }
        if (isDisplayed(WEBKIT_CHROME_BREEZE_XPATH)) {
            utils.refreshCurrentPage();
        }
    }

    @Step("Open Users Section.")
    public void openUsersSection() {
        waitUntilPageIsFullyLoaded();
        click(USERS_SECTION_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Open customers sub section.")
    public void openCustomersSubSection() {
        click(CUSTOMERS_SUB_SECTION_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Is List Of Users Displayed.")
    public boolean isListOfUsersDisplayed() {
        waitUntilPageIsFullyLoaded();
        try {
            waitForElementToDisappear(By.xpath(PROGRESS_BAR_XPATH));
            waitForElementToDisappear(By.xpath(WEBKIT_CHROME_BREEZE_XPATH));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
        }
        return isDisplayed(CUSTOMERS_TABLE_XPATH);
    }

    @Step("Open System Section.")
    public void openSystemSection() {
        waitUntilPageIsFullyLoaded();
        click(SYSTEM_SECTION_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Open Background Processes Section.")
    public void openBackgroundProcessesSection() {
        waitUntilPageIsFullyLoaded();
        click(BACKGROUND_PROCESSES_SECTION_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Open Cron jobs Section.")
    public void openCronJobSection() {
        waitUntilPageIsFullyLoaded();
        click(CRONJOBS_SECTION_XPATH);
        waitUntilPageIsFullyLoaded();
        try {
            waitForElementToDisappear(By.xpath(PROGRESS_BAR_XPATH));
            waitForElementToDisappear(By.xpath(WEBKIT_CHROME_BREEZE_XPATH));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
        }
    }

    @Step("Is List Of Cron Jobs Displayed.")
    public boolean isListOfCronJobsDisplayed() {
        waitUntilPageIsFullyLoaded();
        try {
            waitForElementToDisappear(By.xpath(PROGRESS_BAR_XPATH));
            waitForElementToDisappear(By.xpath(WEBKIT_CHROME_BREEZE_XPATH));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
        }
        return isDisplayed(CRON_JOBS_LIST_XPATH);
    }

    @Step("Open Catalog Tab In Backoffice.")
    public void openCatalogTabInBackoffice() {
        waitUntilPageIsFullyLoaded();
        click(CATALOG_SECTION_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Open Categories Section In Backoffice.")
    public void openCategoriesSectionInBackoffice() {
        waitUntilPageIsFullyLoaded();
        click(CATEGORIES_SECTION_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Is List Of Categories Displayed.")
    public boolean isListOfCategoriesDisplayed() {
        waitUntilPageIsFullyLoaded();
        try {
            waitForElementToDisappear(By.xpath(PROGRESS_BAR_XPATH));
            waitForElementToDisappear(By.xpath(WEBKIT_CHROME_BREEZE_XPATH));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
        }
        return isDisplayed(CATEGORIES_LIST_XPATH);
    }

    @Step("Open Products Section In Backoffice.")
    public void openProductsSectionInBackoffice() {
        waitUntilPageIsFullyLoaded();
        click(PRODUCTS_SECTION_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Is List Of Products Displayed.")
    public boolean isListOfProductsDisplayed() {
        waitUntilPageIsFullyLoaded();
        try {
            waitForElementToDisappear(By.xpath(PROGRESS_BAR_XPATH));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
        }
        return isDisplayed(PRODUCTS_LIST_XPATH);
    }
}
