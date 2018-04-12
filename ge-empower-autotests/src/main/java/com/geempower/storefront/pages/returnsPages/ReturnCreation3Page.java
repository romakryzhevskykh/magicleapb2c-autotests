package com.geempower.storefront.pages.returnsPages;

import com.geempower.storefront.StorefrontBasePage;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.time.LocalDateTime;
import java.time.ZoneId;

import static com.geempower.storefront.page_elements.returnsCreationPageElements.ReturnCreation3PageElements.*;


@Component
public class ReturnCreation3Page extends StorefrontBasePage {

    private final String pageUri = "returnTracking";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }


    @Step("Return Creation 3 page Is Displayed.")
    public boolean returnCreation3pageIsDisplayed() {
        waitUntilPageIsFullyLoaded();
        return isDisplayed(ADDITIONAL_INFORMATION_ACTIVE_TITLE_XPATH);
    }

    @Step("Click on Additional Info Button")
    public void clickOnAdditionalInfoButton() {
        waitUntilPageIsFullyLoaded();
        click(ADDITIONAL_INFORMATION_BUTTON_XPATH);
    }

    @Step("Set color of shrink field")
    public String setColorOfShrinkField() {
        waitUntilPageIsFullyLoaded();
        String uniqueColor = Long.toString(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().getEpochSecond());
        $(COLOR_OF_SHRINK_FIELD_XPATH).sendKeys(uniqueColor);
        return uniqueColor;
    }


    @Step("Set Additional Information Field")
    public String setAdditionalInformationField() {
        waitUntilPageIsFullyLoaded();
        String uniqueAddInfo = Long.toString(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().getEpochSecond());
        $(ADDITIONAL_INFO_FIELD_XPATH).sendKeys(uniqueAddInfo);
        return uniqueAddInfo;
    }

    @Step("Click on Save button")
    public void clickOnSaveButton() {
        waitUntilPageIsFullyLoaded();
        click(SAVE_BUTTON_XPATH);
    }

    @Step("Click on Next button")
    public void clickOnNextButton() {
        waitUntilPageIsFullyLoaded();
        click(BOTTOM_NEXT_BUTTON_XPATH);
    }

    @Step("Get Reason For Request Value")
    public String getReasonForRequest() {
        return $(REASON_FOR_REQUEST_VALUE_XPATH).getText();
    }

    @Step("Get Requested Action")
    public String getRequestedAction() {
        return $(REQUESTED_ACTION_VALUE_XPATH).getText();
    }
}