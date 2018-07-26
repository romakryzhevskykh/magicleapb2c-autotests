package com.geempower.storefront.pages.product;

import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.stream.Collectors;

import static com.geempower.storefront.page_elements.product.PDPPageElements.*;

@Component
public class PDPPage extends StorefrontBasePage {

    private final String pageUri = "p/product_detail";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().contains(getPageUrl());
    }


    @Step("Get Catalog No Header Title.")
    public String getCatalogNoHeaderTitle() {
        return $(CATALOG_NO_HEADER_TITLE_XPATH).getText();
    }

    @Step("Get Product Details Panel Title.")
    public String getProductDetailsPanelTitle() {
        return $(PRODUCT_DETAILS_BLOCK_HEADER_XPATH).getText();
    }

    @Step("Is Image Block Displayed.")
    public boolean isImageDisplayed() {
        return isDisplayed(IMAGE_IN_PRODUCT_DETAILS_BLOCK_XPATH);
    }

    @Step("Is Active Product Details Tab Selected.")
    public String isActiveProductDetailsTabSelected() {
        return $(ACTIVE_PRODUCT_DETAILS_TAB_XPATH).getAttribute("class");
    }

    @Step("Get Product Summary Title.")
    public String getProductSummaryTitle() {
        return $(PRODUCT_SUMMARY_HEADER_TITLE_XPATH).getText();
    }

    @Step("Get All Product Detail Table Items.")
    public List<String> getAllProductDetailTableItems() {
        return $$(ALL_PRODUCT_DETAILS_TABLE_ITEMS_XPATH).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    @Step("Click On Price And Availability Tab On PDP Page.")
    public void clickOnPriceAndAvailabilityTabOnPDPPage() {
        click(PRICE_AND_AVAILABILITY_TAB_XPATH);
    }

    @Step("Is Active PA Tab Selected.")
    public String isActivePATabSelected() {
        return $(ACTIVE_PA_TAB_XPATH).getAttribute("class");
    }

    @Step("Get Availability Details Header Title.")
    public String getAvailabilityDetailsHeaderTitle() {
        waitUntilPageIsFullyLoaded();
        return $(AVAILABILITY_DETAILS_TITLE_XPATH).getText();
    }

    @Step("Get Warehouse Info Table Header.")
    public String getWarehouseInfoTableHeader() {
        return $(DISTRIBUTION_WAREHOUSE_INFO_TABLE_HEADER_XPATH).getText();
    }

    @Step("Get Availability Info Table Header.")
    public String getAvailabilityInfoTableHeader() {
        return $(PRODUCT_AVAILABILITY_INFO_TABLE_HEADER_XPATH).getText();
    }

    @Step("Get Pricing Details Header Title.")
    public String getPricingDetailsHeaderTitle() {
        return $(PRICING_DETAILS_HEADER_TITLE_XPATH).getText();
    }

    @Step("Get All Pricing Details Items.")
    public List<String> getAllPricingDetailsItems() {
        return $$(ALL_PRICING_DETAILS_TABLE_ITEMS_XPATH).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    @Step("Is Add To Cart Button Displayed In Product Details Block On PDP Page.")
    public boolean isAddToCartButtonDisplayedInProductDetailsBlockOnPDPPage() {
        return isDisplayed(ADD_TO_CART_BUTTON_ON_PDP_PAGE_XPATH);
    }

    @Step("User Clicks On Specifications Tab.")
    public void userClicksOnSpecificationsTab() {
        click(SPECIFICATIONS_TAB_XPATH);
    }

    @Step("Is Active Specification Tab Selected.")
    public String isActiveSpecificationTabSelected() {
        return $(ACTIVE_SPECIFICATION_TAB_XPATH).getAttribute("class");
    }

    @Step("Get Specifications Tab Header Title.")
    public String getGeneralCharacteristicsTabHeaderTitle() {
        waitUntilPageIsFullyLoaded();
        return $(GENERAL_CHARACTERISTICS_HEADER_TITLE_XPATH).getText();
    }

    @Step("Get All General Characteristics Items.")
    public List<String> getAllGeneralCharacteristicsItems() {
        return $$(ALL_GENERAL_CHARACTERISTICS_TABLE_ITEMS_XPATH).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    @Step("User Clicks On Publications Tab.")
    public void userClicksOnPublicationsTab() {
        click(PUBLICATIONS_TAB_XPATH);
    }

    @Step("Get List Of Publications Header Title.")
    public String getListOfPublicationsHeaderTitle() {
        waitUntilPageIsFullyLoaded();
        return $(LIST_OF_PUBLICATIONS_HEADER_TITLE_XPATH).getText();
    }

    @Step("Is Active Publications Tab Selected.")
    public String isActivePublicationsTabSelected() {
        return $(ACTIVE_PUBLICATIONS_TAB_XPATH).getAttribute("class");
    }

    @Step("Get All Publication Table Headers.")
    public List<String> getAllPublicationTableHeaders() {
        return $$(ALL_PUBLICATIONS_HEADERS_XPATH).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    @Step("Is Publication Table Contains Link.")
    public String isPublicationTableContainsLink() {
        return $(LINK_IN_THE_PUBLICATIONS_TABLE_XPATH).getAttribute("href");
    }
}