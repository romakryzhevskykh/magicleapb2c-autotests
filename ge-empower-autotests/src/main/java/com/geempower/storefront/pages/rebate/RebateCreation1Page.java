package com.geempower.storefront.pages.rebate;

import com.geempower.helpers.Utils;
import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Random;

import static com.geempower.storefront.page_elements.rebate.RebateCreation1PageElements.*;

@Component
public class RebateCreation1Page extends StorefrontBasePage {

    @Autowired
    private Utils utils;

    private final String pageUri = "rebate/create-rebate";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

    @Step("Check that first Step Is Opened")
    public boolean firstStepIsOpened() {
        waitUntilPageIsFullyLoaded();
        return $(REBATE_CREATE_REQUEST_ACTIVE_STEP_XPATH).isDisplayed();
    }
}
