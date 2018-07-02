package com.geempower.storefront.page_blocks;

import com.geempower.helpers.UIComponent;
import com.geempower.helpers.managers.ProductManager;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static com.geempower.storefront.page_block_elements.PriceAndAvailabilityBlockElements.*;

@Component
public class PriceAndAvailabilityBlock extends UIComponent {
    @Autowired
    private ProductManager productManager;

    @Step("Click on Check P&A button")
    public void clickOnCheckPAButton() {
        click(By.id(CHECK_PRICE_AND_AVAILABILITY_BUTTON_ID));

    }

    @Step("Send CatalogueNo. to the Copy&Paste field")
    public void setCatalogueNoToTheCopyAndPasteField(String catalogueNo) {
        $(By.id(COPY_AND_PASTE_FIELD_ID)).sendKeys(catalogueNo);
    }

    @Step("Enter CatalogueNo. to the product field")
    public void setCatalogueNoToProductField(String catalogueNo) {
        $(By.id(FIRST_PRODUCT_ROW_ID)).sendKeys(catalogueNo);
    }

    @Step("Add the list of Items to the Copy&Paste block.")
    public void addItemsToTheCopyPasteBlock(List<String> products) {
        products.forEach(product -> $(By.id(COPY_AND_PASTE_FIELD_ID)).sendKeys(product + "\n"));
    }
}