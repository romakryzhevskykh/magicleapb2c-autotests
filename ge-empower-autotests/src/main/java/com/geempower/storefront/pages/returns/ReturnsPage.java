package com.geempower.storefront.pages.returns;

import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

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
        click(SAVED_REQUEST_TAB_XPATH);
    }

    @Step("Get Last Saved Return Name.")
    public String getLastSavedReturntName() {
        waitUntilPageIsFullyLoaded();
        return $(LAST_SAVED_RETURN_NAME_XPATH).getText();
    }

    @Step("Edit Last Saved Return.")
    public void editLastSavedReturn() {
        click(EDIT_LAST_SAVED_RETURN_ICON_XPATH);
    }
}