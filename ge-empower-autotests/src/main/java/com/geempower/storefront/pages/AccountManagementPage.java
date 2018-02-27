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

    public void chooseRegion(Region chosenRegion) {
        chosenRegion.getRegionType().getRegionName();
    }

    @Step("Click on Cancel Button")
    public void clickOnCancelButton() {
        $(By.xpath(CANCEL_BUTTON_XPATH)).click();
    }
}
