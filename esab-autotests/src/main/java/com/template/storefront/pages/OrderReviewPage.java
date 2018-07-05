package com.template.storefront.pages;

import static org.testng.Assert.assertFalse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import ru.yandex.qatools.allure.annotations.Step;
import static com.template.storefront.page_elements.OrderReviewPageElements.*;

@Component
public class OrderReviewPage extends StorefrontBasePage {

	final static Logger logger = Logger.getLogger(OrderReviewPage.class);
	private String pageUrlMethod = "/esab/en/checkout/multi/summary/view";

	@Override
	public String getPageUrl() {
		String orderReviewPageURL = storefrontProject.getBaseUrl() + pageUrlMethod;
		logger.info("Order Review Page URL: " + orderReviewPageURL);
		return orderReviewPageURL;
	}

	@Step("Verify current page is Order Review page")
	public void isCurrentPageOrderReviewPage() {
		String expectedUrl = getPageUrl();
		isCurrentUrlExpectedURL(expectedUrl);
	}

	@Step("Click on confirmation Checkbox on Order Review page")
	public void clickOnConfirmationCheckbox() {
		click(XPATH_CONFIRAMTION_CHECKBOX);
	}

	@Step("Click on Place Order button")
	public void clickOnPlaceOrderButton() {
		click(XPATH_PLACE_ORDER_BUTTON);
	}

	@Step("Verify is Place Order Disabled")
	public void isPlaceOrderDisabled() {
		waitJSExecution();
		assertFalse(isElementEnabled(XPATH_PLACE_ORDER_BUTTON), "Place order button Enabled, butshould be Disabled");
		logger.info("Place Order button is Disabled");
	}

}
