package com.sarnova.storefront.page_blocks;

import com.sarnova.helpers.UIComponent;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;

import static com.sarnova.storefront.page_block_elements.CheckoutShippingMethodStepBlockElements.*;

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

    @Step("Select OVERNIGHT shipping method.")
    public void selectOvernightShippingMethod() {
        if (!isOvernightSelected())
            click(OVERNIGHT_SHIPPING_METHOD_SELECTOR_XPATH);
    }

    @Step("Is OVERNIGHT shipping method selected?")
    public boolean isOvernightSelected() {
        return $(OVERNIGHT_SHIPPING_METHOD_SELECTOR_XPATH).isSelected();
    }

    @Step("Select GROUND shipping method.")
    public void selectGroundShippingMethod() {
        if (!isGroundSelected())
            click(GROUND_SHIPPING_METHOD_SELECTOR_XPATH);
    }

    @Step("Is GROUND shipping method selected?")
    public boolean isGroundSelected() {
        return $(GROUND_SHIPPING_METHOD_SELECTOR_XPATH).isSelected();
    }

    @Step("Select 2-DAY shipping method.")
    public void select2DayShippingMethod() {
        if (!is2DaySelected())
            click(DAY_2_SHIPPING_METHOD_SELECTOR_XPATH);
    }

    @Step("Is 2-DAY shipping method selected?")
    public boolean is2DaySelected() {
        return $(DAY_2_SHIPPING_METHOD_SELECTOR_XPATH).isSelected();
    }
}
