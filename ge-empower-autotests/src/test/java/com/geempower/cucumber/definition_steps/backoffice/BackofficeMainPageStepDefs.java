package com.geempower.cucumber.definition_steps.backoffice;

import com.geempower.cucumber.definition_steps.AbstractStepDefs;
import com.geempower.helpers.Utils;
import com.geempower.hybris.backoffice.pages.BackofficeMainPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class BackofficeMainPageStepDefs extends AbstractStepDefs {
    @Autowired
    private BackofficeMainPage backofficeMainPage;
    @Autowired
    private Utils utils;

    @And("^Commerce logo is displayed on the main backoffice page.$")
    public void checkThatCommerceLogoIsDisplayedOnTheMainBackofficePage() {
        if (backofficeMainPage.isCommerceLogoDisplayed()) {
            System.out.println("Main page was fully loaded at: " + utils.getLocalDateTimeStamp());
        } else
            System.out.println("Commerce Logo is not Displayed, main page is not fully loaded after all the timeouts at: " + utils.getLocalDateTimeStamp());
    }

    @When("^Admin opens Users tab in Backoffice.$")
    public void adminOpensUsersTabInBackoffice() {
        backofficeMainPage.openUsersSection();
    }

    @And("^Admin opens Customers section in Backoffice.$")
    public void adminOpensCustomersSectionInBackoffice() {
        backofficeMainPage.openCustomersSubSection();
    }

    @And("^List of users is displayed on the Customers section.$")
    public void listOfUsersIsDisplayedOnTheCustomersSection() {
        backofficeMainPage.isListOfUsersDisplayed();
    }

    @When("^Admin opens System tab in Backoffice.$")
    public void adminOpensSystemTabInBackoffice() {
        backofficeMainPage.openSystemSection();
    }

    @And("^Admin opens Background processes tab in Backoffice.$")
    public void adminOpensBackgroundProcessesTabInBackoffice() {
        backofficeMainPage.openBackgroundProcessesSection();
    }

    @And("^Admin opens CronJobs section in Backoffice.$")
    public void adminOpensCronJobsSectionInBackoffice() {
        backofficeMainPage.openCronJobSection();
    }

    @And("^List of cronJobs is displayed on the CronJobs section.$")
    public void listOfCronJobsIsDisplayedOnTheCronJobsSection() {
        backofficeMainPage.isListOfCronJobsDisplayed();
    }

    @When("^Admin opens Catalog tab in Backoffice.$")
    public void adminOpensCatalogTabInBackoffice() {
        backofficeMainPage.openCatalogTabInBackoffice();
    }

    @And("^Admin opens Categories section in Backoffice.$")
    public void adminOpensCategoriesSectionInBackoffice() {
        backofficeMainPage.openCategoriesSectionInBackoffice();
    }

    @And("^List of categories is displayed on the Customers section.$")
    public void listOfCategoriesIsDisplayedOnTheCustomersSection() {
        backofficeMainPage.isListOfCategoriesDisplayed();
    }

    @And("^Admin opens Products section in Backoffice.$")
    public void adminOpensProductsSectionInBackoffice() {
        backofficeMainPage.openProductsSectionInBackoffice();
    }

    @And("^List of products is displayed on the Customers section.$")
    public void listOfProductsIsDisplayedOnTheCustomersSection() {
        backofficeMainPage.isListOfProductsDisplayed();
    }
}