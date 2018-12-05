package com.geempower.storefront.pages.rebate;

import com.geempower.storefront.StorefrontBasePage;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.rebate.RebatesPageElements.*;

@Component
public class RebatesPage extends StorefrontBasePage {
    private final String pageUri = "rebate";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

    @Step("Get Rebates title")
    public String getRebatesTitle() {
        return $(REBATES_TITLE_XPATH).getText();
    }

    @Step("Click on Create rebate button.")
    public void clickOnCreateRebateButton() {
        waitUntilPageIsFullyLoaded();
        $(CREATE_REBATE_BUTTON_XPATH).click();
    }

    @Step("Check that created rebate is displayed on the All rebates page.")
    public boolean isRebateDisplayed(String id) {
        return $(REBATE_BY_ID_XPATH, id).isDisplayed();
    }

    @Step("Get a number of all Rebates on the Rebates page.")
    public int getNumberOfAllRebates() {
        return Integer.parseInt($(ALL_REBATES_COUNT_XPATH).getText());
    }

    @Step("Open Saved Credit Requests Tab.")
    public void openSavedCreditRequestsTab() {
        click(SAVED_CREDIT_REQUEST_TAB_XPATH);
    }

    @Step("Get Last Saved Rebate Name.")
    public String getLastSavedRebateName() {
        waitUntilPageIsFullyLoaded();
        return $(LAST_SAVED_REBATE_NAME_XPATH).getText();
    }

    @Step("Edit Just Saved Rebate.")
    public void editJustSavedRebate() {
        click(EDIT_LAST_SAVED_REQUEST_ICON_XPATH);
    }

    @Step("Delete Just Saved Rebate.")
    public void deleteJustSavedRebate() {
        click(DELETE_LAST_SAVED_REQUEST_ICON_XPATH);
        click(CONFIRM_DELETE_ACTION_SAVED_REBATE_BUTTON_XPATH);
    }
}