package com.sarnova.storefront.page_blocks;

import com.sarnova.helpers.UIComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static com.sarnova.storefront.page_block_elements.ProductLicenseRequiredPopUpBlockElements.*;

@Component
public class ProductLicenseRequiredPopUpBlock extends UIComponent {

    @Step("Select user has no license in pop-up.")
    public void selectUserHasNoLicense() {
        click(By.id(HAS_NO_LICENSE_SELECT_BOX_ID));
    }

    @Step("Click on Continue button.")
    public void clickOnContinueButton() {
        click(CONTINUE_BUTTON_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Get products skus listed in pop-up.")
    public ArrayList<String> getProductsSKUsListedInPopUp() {
        return $$(PRODUCTS_SKUS_XPATH).stream().map(WebElement::getText).collect(Collectors.toCollection(ArrayList::new));
    }
}
