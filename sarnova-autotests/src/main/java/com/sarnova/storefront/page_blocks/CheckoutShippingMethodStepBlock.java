package com.sarnova.storefront.page_blocks;

import com.sarnova.helpers.UIComponent;
import com.sarnova.helpers.models.delivery_methods.DeliveryMethod;
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

    @Step("Select {0} shipping method.")
    public void selectShippingMethod(DeliveryMethod deliveryMethod) {
        if (!isDeliveryMethodSelected(deliveryMethod))
            click(SHIPPING_METHOD_BY_NAME_SELECTOR_XPATH, deliveryMethod.getNameInCheckoutHTML());
    }

    @Step("Is {0} shipping method selected?")
    public boolean isDeliveryMethodSelected(DeliveryMethod deliveryMethod) {
        return $(SHIPPING_METHOD_BY_NAME_SELECTOR_XPATH, deliveryMethod.getNameInCheckoutHTML()).isSelected();
    }
}
