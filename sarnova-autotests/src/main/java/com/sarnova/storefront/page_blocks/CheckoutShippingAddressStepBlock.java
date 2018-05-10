package com.sarnova.storefront.page_blocks;

import com.sarnova.helpers.UIComponent;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.sarnova.storefront.page_block_elements.CheckoutShippingAddressStepBlockElements.*;

@Component
public class CheckoutShippingAddressStepBlock extends UIComponent {

    private String pageUrlMethod = "multi/delivery-address/add";

    @Step("Click on Next button on Checkout Shipping address step.")
    public void clickOnNextButton() {
        click(By.id(NEXT_BUTTON_ID));
        waitUntilPageIsFullyLoaded();
    }

    public String getPageUrlMethod() {
        return pageUrlMethod;
    }

}
