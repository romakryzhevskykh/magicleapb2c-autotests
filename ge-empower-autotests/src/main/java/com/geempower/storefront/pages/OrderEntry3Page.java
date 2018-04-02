package com.geempower.storefront.pages;

import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.OrderEntry3PageElements.*;

@Component
public class OrderEntry3Page extends StorefrontBasePage {

    private final String pageUri = "checkout";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Step("Check that third step of order creation is opened.")
    public boolean isOrderSummaryStepOpened() {
        waitUntilPageIsFullyLoaded();
        return $(ORDER_SUMMARY_STEP_TITLE_XPATH).isDisplayed();
    }

    @Step("Check that Po No. is equal to chosen Po No.")
    public String getPoNoFromOrderSummary() {
        return $(PO_NUMBER_SUMMARY_XPATH).getText();
    }

    @Step("User clicks on Place order button on the third Order entry page.")
    public void clickOnThePlaceOrderButton() {
        waitUntilPageIsFullyLoaded();
        JavascriptExecutor je = (JavascriptExecutor) getDriver();
        WebElement element = $(PLACE_ORDER_BOTTOM_BUTTON_XPATH);
        je.executeScript("arguments[0].scrollIntoView(true);", element);
        $(PLACE_ORDER_BOTTOM_BUTTON_XPATH).click();
    }

    @Step("User submit the Confirmation pop-up.")
    public void submitTermsAndConditions() {
        waitUntilPageIsFullyLoaded();
        $(TERMS_AND_CONDITIONS_CHECKBOX_XPATH).click();
        $(SUBMIT_ORDER_BUTTON_IN_TERMS_POP_UP_XPATH).click();
    }

    @Step("Getting the GE Order No. from the 'Order successful' pop-up.")
    public String getGEOrderNoFromOrderSuccessPopUp(String title) {
        waitForElementWithAppropriateTextToAppear(By.xpath(ORDER_CONFIRMATION_POP_UP_TITLE_XPATH), title);
        return $(GE_ORDER_NUMBER_ON_THE_CONFIRMATION_POP_UP_XPATH).getText();
    }

    @Step("User close the Confirmation pop-up.")
    public void closeOrderConfirmationPopUp() {
        $(CLOSE_ORDER_CONFIRMATION_POP_UP_XPATH).click();
        waitUntilPageIsFullyLoaded();
    }
}
