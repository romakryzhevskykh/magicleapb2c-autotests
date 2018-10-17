package com.geempower.storefront.pages.order;

import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.geempower.storefront.page_elements.order.PODetailsPageElements.*;

@Component
public class PODetailsPage extends StorefrontBasePage {
    private final String pageUri = "orders/details/";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Step("PO Details page is opened.")
    public boolean isOpened(String orderNo) {
        return getCurrentUrl().contains(orderNo);
    }

    @Step("Is Purchase Order Title Displayed On Details PO Number Page.")
    public String  getPurchaseOrderTitleOnDetailsPONumberPage() {
        if (isDisplayed (By.id(PO_NUMBERS_ORDER_TABLE_ID))){
            click(PO_NUMBERS_ORDER_TABLE_SELECT_ALL_CHECKBOX_XPATH);
            click(ACTIVE_NEXT_BUTTON_ABOVE_PO_NUMBERS_ORDER_TABLE_XPATH);
            waitUntilPageIsFullyLoaded();
            return $(PURCHASE_ORDER_TITLE_XPATH).getText();
        } else {
            return $(PURCHASE_ORDER_TITLE_XPATH).getText();
        }
    }


    @Step("Get PO No Title Number.")
    public String getPONoTitleNumber() {
        return $(PO_NO_TITLE_NUMBER_XPATH).getAttribute("value");
    }

    @Step("Is Email Download Icon Displayed In Right Corner.")
    public boolean isEmailDownloadIconDisplayedInRightCorner() {
        return isDisplayed(EMAIL_DOWNLOAD_ICON_XPATH);
    }

    @Step("User Expands/Closes status boxes on PO Details page")
    public void userExpandsClosesStatusBoxesOnPODetailsPage() {
        waitUntilPageIsFullyLoaded();
        click(EXPAND_CLOSE_STATUS_BOXES_ARROW_BUTTON_XPATH);
    }

    @Step("Is Expanded Status Box Line Displayed.")
    public boolean isExpandedStatusBoxLineDisplayedOnPODetailsPage() {
        waitUntilPageIsFullyLoaded();
        return isDisplayed(EXPANDED_STATUS_BOXES_LINE_XPATH);
    }

    @Step("Get All Statuses In Status Boxes On PO Details Page.")
    public List<String> getAllStatusesInStatusBoxesOnPODetailsPage() {
        return $$(STATUS_BOX_TITLES_XPATH).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    @Step("Get Label Value in PO Details block.")
    public String getLabelValueInPODetailsBlock(String label) {
        return $(LABEL_VALUES_IN_PO_DETAILS_BLOCK_XPATH, label).getText();
    }

    @Step("User Click On Time Status Drop Down Field.")
    public void userClickOnTimeStatusDropDownField() {
        click(TIME_STATUSES_DROP_DOWN_FIELD_XPATH);
    }

    @Step("Get All Time Statuses In Time Status Drop Down.")
    public Stream<WebElement> getAllTimeStatusesInTimeStatusDropDown() {
        waitUntilPageIsFullyLoaded();
        return $$(TIME_STATUSES_VALUES_IN_DROP_DOWN_XPATH).stream();
    }
}