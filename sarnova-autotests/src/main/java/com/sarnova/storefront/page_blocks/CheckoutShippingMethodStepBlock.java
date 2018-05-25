package com.sarnova.storefront.page_blocks;

import com.sarnova.helpers.UIComponent;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;

import static com.sarnova.storefront.page_block_elements.CheckoutShippingMethodStepBlockElements.CHECK_PRODUCT_LICENSE_POP_UP_XPATH;
import static com.sarnova.storefront.page_block_elements.CheckoutShippingMethodStepBlockElements.NEXT_BUTTON_ID;

@Component
public class CheckoutShippingMethodStepBlock extends UIComponent {
    @Autowired ProductLicenseRequiredPopUpBlock productLicenseRequiredPopUpBlock;

    private String pageUrlMethod = "multi/delivery-method/choose";

    @Step("Click on Next button on Checkout Shipping method step.")
    public void clickOnNextButton() {
        click(By.id(NEXT_BUTTON_ID));
        waitUntilPageIsFullyLoaded();
    }

    @Step("Is Check product license pop-up opened.")
    public boolean isCheckLicensePopUpOpened() {
        return isDisplayed(CHECK_PRODUCT_LICENSE_POP_UP_XPATH);
    }

    public void selectUserHasNoLicenseSelectBoxOnCheckoutShippingMethodStepInLicensePopUp() {
        productLicenseRequiredPopUpBlock.selectUserHasNoLicense();
    }

    public void clickOnContinueButtonOnCheckoutShippingMethodStepInLicensePopUp() {
        productLicenseRequiredPopUpBlock.clickOnContinueButton();
    }

    public ArrayList<String> getSKUsInCheckLicensePopUp() {
        return productLicenseRequiredPopUpBlock.getProductsSKUsListedInPopUp();
    }

    public String getPageUrlMethod() {
        return pageUrlMethod;
    }
}
