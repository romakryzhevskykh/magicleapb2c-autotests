package com.geempower.storefront.pages.order;

import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.geempower.storefront.page_block_elements.InvoiceDetailsPopUpElements.*;
import static com.geempower.storefront.page_elements.order.OrderDetailsPageElements.*;

@Component
public class OrderDetailsPage extends StorefrontBasePage {
    private final String pageUri = "orders/details/";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Step("Orders Details page is opened.")
    public boolean isOpened(String orderNo) {
        return getCurrentUrl().contains(pageUri) && getCurrentUrl().endsWith(orderNo);
    }

    @Step("Get GE order NO.")
    public String getGeOrderNo() {
        return $(GE_ORDER_NO_XPATH).getText();
    }

    @Step("Get Total Net Price.")
    public String getTotalNetPrice() {
        waitUntilPageIsFullyLoaded();
        String netPrice = $(TOTAL_NET_PRICE_VALUE_XPATH).getText();
        return netPrice.replace(",", "").replace(".", "").replace("USD", "").trim();
    }

    @Step("Click On Expand Order Details Icon.")
    public void clickOnExpandOrderDetailsIcon() {
        waitUntilPageIsFullyLoaded();
        click(EXPAND_ORDER_DETAILS_ICON_XPATH);
    }

    @Step("Click On Invoice Hyper link.")
    public void clickOnInvoiceHyperlink() {
        waitHTMLTemplateLoad();
        click(INVOICE_DOWNLOAD_HYPERLINK_XPATH);
    }

    @Step("Is Pop-Up Appears.")
    public boolean isPopUpAppears() {
        waitUntilPageIsFullyLoaded();
        return isDisplayed(INVOICE_DETAILS_POP_UP_XPATH);
    }

    @Step("Get Invoice Details Pop-Up Header.")
    public String getInvoiceDetailsPopUpHeader() {
        return $(INVOICE_DETAILS_HEADER_XPATH).getText();
    }

    @Step("Get Pop-Up Body Text.")
    public String getPopUpBodyText() {
        return $(INVOICE_DETAILS_BODY_TEXT_XPATH).getText();
    }

    @Step("Get Invoice Details Pop Up Service Link.")
    public String getInvoiceDetailsPopUpServiceLink() {
        waitUntilPageIsFullyLoaded();
        return $(INVOICE_POP_UP_SERVICE_LINK_XPATH).getText();
    }

    @Step("Close Invoice Details Pop-Up.")
    public void closeInvoiceDetailsPopUp() {
        click(INVOICE_DETAILS_POP_UP_CLOSE_BUTTON_XPATH);
    }

    @Step("Get Tracking Information Data.")
    public String getTrackingInformationData() {
        waitUntilPageIsFullyLoaded();
        return $(TRACKING_INFO_DATA_XPATH).getText();
    }

    @Step("Click On Multiple Hyper link.")
    public void clickOnMultipleHyperlink() {
        click(TRACKING_INFO_DATA_XPATH);
    }

    @Step("Get Bol And Tracking Numbers Pop-Up Title.")
    public String getBolAndTrackingNumbersPopUpTitle() {
        waitUntilPageIsFullyLoaded();
        return $(BOL_AND_TRACKING_NUMBERS_POP_UP_TITLE_XPATH).getText();
    }

    @Step("Get Count Of Bills In BOL Pop-Up.")
    public int getCountOfBillsInBOLPopUp() {
        return $$(BILLS_OF_LANDING_IN_BOL_AND_TRACKING_NUMBERS_POP_UP_XPATH).size();
    }

    @Step("Expand First Line Order Details.")
    public void expandFirstLineOrderDetails() {
        waitUntilPageIsFullyLoaded();
        click(EXPAND_FIRST_LINE_ORDER_DETAILS_ICON_XPATH);
    }

    @Step("Get BOL Information Data.")
    public String getBOLInformationData() {
        waitUntilPageIsFullyLoaded();
        return $(BOL_DATA_XPATH).getText();
    }

    @Step("Click On BOL Hyper link.")
    public void clickOnBOLHyperlink() {
        click(BOL_DATA_XPATH);
    }

    @Step("Close BOL Pop-Up.")
    public void closeBOLPopUp() {
        click(CLOSE_BOL_POP_UP_ICON_XPATH);
    }

    @Step("Select Random Checkbox Catalog No.")
    public void selectRandomCheckboxCatalogNo(String catalogNo) {
        waitUntilPageIsFullyLoaded();
        click(CHECKBOX_RELATES_TO_CATALOG_NO_XPATH, catalogNo);
    }

    @Step("Get Quantity Of Selected Catalog No Checkbox.")
    public String getQuantityOfSelectedCatalogNoCheckbox(String catalogNo) {
        return $(QUANTITY_OF_APPROPRIATE_PRODUCT_XPATH, catalogNo).getText();
    }

    @Step("Get random catalog No.")
    public String getRandomCatalogNo() {
        waitUntilPageIsFullyLoaded();
        StringBuilder catalogNo = new StringBuilder("");
        $$(ALL_CATALOG_NO_XPATH).stream().findAny().ifPresent(webElement -> {
            catalogNo.append(webElement.getText());
        });
        return String.valueOf(catalogNo);
    }

    @Step("Click On Add To Cart Button On Order Details Page.")
    public void clickOnAddToCartButtonOnOrderDetailsPage() {
        click(REORDER_BUTTON_XPATH);
    }

    @Step("User Clicks On Random Status Box.")
    public void userClicksOnRandomStatusBox() {
        waitUntilPageIsFullyLoaded();
        $$(STATUS_BOXES_XPATH).stream().findAny().ifPresent(this::click);
    }

    @Step("Get List Of Catalog No.")
    public List<WebElement> getListOfCatalogNo() {
        return $$(ALL_CATALOG_NO_XPATH);
    }

    @Step("Get Catalog No By Row.")
    public String getCatalogNoByRow(String rowNo) {
        return $(ALL_CATALOG_NO_BY_ROW_XPATH, rowNo).getText();
    }

    @Step("Get Description By Row.")
    public String getDescriptionByRow(String rowNo) {
        return $(ALL_DESCRIPTION_BY_ROW_XPATH, rowNo).getText();
    }

    @Step("Is Table With Products Displayed.")
    public boolean isTableWithProductsDisplayed() {
        return isDisplayed(TABLE_WITH_PRODUCTS_XPATH);
    }

    @Step("User Expands Quote Details Block.")
    public void userExpandsQuoteDetailsBlock() {
        click(EXPAND_QUOTES_BLOCK_ARROW_BUTTON_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Get Label Value in Quote Details block.")
    public String getLabelValueInQuoteDetailsBlock(String label) {
        waitUntilPageIsFullyLoaded();
        return $(LABEL_VALUES_IN_QUOTES_BLOCK_XPATH, label).getText();
    }

    @Step("Get All Labels in Quote Details Block.")
    public List<String> getAllLabelsInQuoteDetailsBlock() {
        return $$(LABELS_IN_QUOTES_BLOCK_XPATH).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    @Step("User Closes Quote Details Block.")
    public void userClosesQuoteDetailsBlock() {
        click(HIDE_QUOTES_BLOCK_ARROW_BUTTON_XPATH);
    }

    @Step("User Expands/Closes status boxes.")
    public void userExpandsClosesStatusBoxes() {
        click(EXPAND_CLOSE_STATUS_BOXES_ARROW_BUTTON_XPATH);
    }

    @Step("Get Select Items Text First Part.")
    public String getSelectItemsTextFirstPart() {
        return $(REORDER_BUTTON_TEXT_FIRST_PART_XPATH).getText().trim();
    }

    @Step("Get Bottom Row In Details Quotes Block.")
    public WebElement getBottomRowInDetailsQuotesBlock() {
        waitUntilPageIsFullyLoaded();
        return $(BOTTOM_ROW_IN_DETAILS_QUOTES_BLOCK_XPATH);
    }

    @Step("Is Expanded Status Box Line Displayed.")
    public boolean isExpandedStatusBoxLineDisplayed() {
        waitUntilPageIsFullyLoaded();
        return isDisplayed(EXPANDED_STATUS_BOXES_LINE_XPATH);
    }

    @Step("Get All Statuses In Status Boxes.")
    public List<String> getAllStatusesInStatusBoxes() {
        return $$(STATUS_BOX_TITLES_XPATH).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    @Step("Get All Time Statuses Near Color Icons.")
    public List<String> getAllTimeStatusNearColorIcons() {
        return $$(TIME_STATUSES_NEAR_COLOR_ICON_XPATH).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    @Step("User Clicks On Time Status Drop Down Field.")
    public void userClicksOnTimeStatusDropDownField() {
        click(TIME_STATUSES_DROP_DOWN_FIELD_XPATH);
    }

    @Step("Get All Time Statuses In Time Status Drop Down.")
    public Stream<WebElement> getAllTimeStatusesInTimeStatusDropDown() {
        waitUntilPageIsFullyLoaded();
        return $$(TIME_STATUSES_VALUES_IN_DROP_DOWN_XPATH).stream();
    }

    @Step("Get All Detail Order Table Headers.")
    public List<String> getAllDetailOrderTableHeaders() {
        return $$(ORDER_DETAILS_TABLE_HEADERS_XPATH).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    @Step("User Opens Random Product Detail Block.")
    public void userOpensRandomProductDetailBlock() {
        waitUntilPageIsFullyLoaded();
        $$(EXPAND_DETAIL_PRODUCT_BLOCK_ARROW_XPATH).stream().findAny().ifPresent(this::click);
        waitUntilPageIsFullyLoaded();
    }

    @Step("User Closes Opened Product Detail Block.")
    public void userClosesOpenedProductDetailBlock() {
        $(CLOSE_DETAIL_PRODUCT_BLOCK_ARROW_XPATH).click();
    }

    @Step("Get Label Value In Product Details Block.")
    public String getLabelValueInProductDetailsBlock(String label) {
        waitUntilPageIsFullyLoaded();
        return $(LABEL_VALUES_IN_PRODUCT_DETAILS_BLOCK_XPATH, label).getText();
    }

    @Step("Get All Product Detail Labels.")
    public List<String> getAllProductDetailLabels() {
        return $$(LABELS_IN_PRODUCT_DETAILS_BLOCK_XPATH).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    @Step("Get Sum Of All Ext Price.")
    public double getSumOfAllExtPrice() {
        return $$(ALL_EXT_PRICES_IN_PRODUCT_DETAILS_BLOCK_XPATH).stream()
                .map(s -> Double.parseDouble(s.getAttribute("value").replace(",", "")))
                .mapToDouble(Double::doubleValue).sum();
    }

    @Step("Click On Tracking Info Hyper Link.")
    public void clickOnTrackingInfoHyperLink() {
        click(TRACKING_INFO_HYPERLINK_XPATH);
    }

    @Step("Click On Random Tracking Number.")
    public void clickOnRandomTrackingNumber() {
        $$(LIST_OF_TRACKING_NUMBERS_XPATH).stream().findAny().orElse(null).click();
    }

    @Step("Is Tracking Slider Displayed.")
    public boolean isTrackingSliderDisplayed() {
        waitUntilPageIsFullyLoaded();
        return isDisplayed(TRACKING_DETAILS_SLIDER_XPATH);
    }

    @Step("Get Slider Title.")
    public String getSliderTitle() {
        waitUntilPageIsFullyLoaded();
        return $(TRACKING_DETAILS_SLIDER_HEADER_XPATH).getText();
    }

    @Step("Get Tracking Error Message.")
    public String getTrackingErrorMessage() {
        return $(TRACKING_DETAILS_ERROR_MESSAGE_XPATH).getText();
    }

    @Step("Get Line No Details.")
    public String getLineNoDetails() {
        return $(LINE_NO_AND_CATALOG_NO_DETAILS_XPATH).getText();
    }

    @Step("Are All Progress Bars Displayed.")
    public boolean areAllProgressBarsDisplayed() {
        return isDisplayed(DELIVERED_PROGRESS_BAR_XPATH) && isDisplayed(IN_TRANSIT_PROGRESS_BAR_XPATH)
                && isDisplayed(SHIPMENT_INFO_SENT_PROGRESS_BAR_XPATH);
    }

    @Step("Is Exclamation Mark Icon Displayed.")
    public boolean isExclamationMarkIconDisplayed() {
        return isDisplayed(ERROR_EXCLAMATION_MARK_ICON_XPATH);
    }

    @Step("Get Shipment Info Sent Status Text.")
    public String getShipmentInfoSentStatusText() {
        return $(SHIPMENT_INFO_SENT_STATUS_NAME_XPATH).getText();
    }

    @Step("Get Delivered Status Text.")
    public String getDeliveredStatusText() {
        return $(DELIVERED_STATUS_NAME_XPATH).getText();
    }

    @Step("Get In Transit Status Text.")
    public String getInTransitStatusText() {
        return $(IN_TRANSIT_STATUS_NAME_XPATH).getText();
    }

    @Step("Go To The Next Tracking Info.")
    public void goToTheNextTrackingInfo() {
        click(NEXT_TRACKING_INFO_BUTTON_XPATH);
    }

    @Step("Go To The Previous Tracking Info.")
    public void goToThePreviousTrackingInfo() {
        click(PREVIOUS_TRACKING_INFO_BUTTON_XPATH);
    }

    @Step("Click On Appropriate Status Box.")
    public void clickOnAppropriateStatusBox(String status) {
        click(SINGLE_STATUS_BOX_XPATH, status.toLowerCase());
    }

    @Step("Get Price For Appropriate Status Box.")
    public String getPriceForAppropriateStatusBox(String status) {
        waitUntilPageIsFullyLoaded();
        return $(SINGLE_STATUS_BOX_PRICE_VALUE_XPATH, status.toLowerCase()).getText().replace(",", "").replace(".", "");
    }
}