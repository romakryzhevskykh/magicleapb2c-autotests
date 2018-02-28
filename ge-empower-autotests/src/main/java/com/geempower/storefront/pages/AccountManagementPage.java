package com.geempower.storefront.pages;

import com.geempower.helpers.models.Region;
import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.AccountManagementPageElements.*;

@Component
public class AccountManagementPage extends StorefrontBasePage {
    @Autowired
    private AccountManagementPage accountManagementPage;

    private final String pageUri = "my-account/manage-accounts";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().contains(getPageUrl());
    }

    public void selectAppropriateRegionFromRegionList(Region chosenRegion) {
        waitUntilPageIsFullyLoaded();
        openRegionsList();
        chooseRegion(chosenRegion);
    }

    @Step("Select appropriate region by region name")
    public void chooseRegion(Region chosenRegion) {
        click(APPROPRIATE_REGION_BY_NAME_XPATH, chosenRegion.getRegionType().getRegionName());
    }

    @Step("Open regions list")
    public void openRegionsList() {
        click(REGION_COMBOBOX_XPATH);
    }

    public void searchAccountForChosenRegion(String accountName) {
        setAccountNumberToSearchField(accountName);
        clickOnSearchButton();
    }

    @Step("Set account number to search field")
    public void setAccountNumberToSearchField(String accountName) {
        $(SEARCH_FIELD_XPATH).sendKeys(accountName);
    }

    @Step("Click on Search account button")
    public void clickOnSearchButton() {
        click(SEARCH_BUTTON_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    public void selectFirstAccount() {
        click(FIRST_ACCOUNT_FROM_LIST_OF_ACCOUNTS_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Click on Cancel Button")
    public void clickOnCancelButton() {
        $(By.xpath(CANCEL_BUTTON_XPATH)).click();
    }
}
