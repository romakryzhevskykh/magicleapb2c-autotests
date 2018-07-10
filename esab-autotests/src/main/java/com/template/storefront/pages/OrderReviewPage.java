package com.template.storefront.pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import com.template.storefront.models.CheckoutDataModel;

import ru.yandex.qatools.allure.annotations.Step;
import static com.template.storefront.page_elements.OrderReviewPageElements.*;

@Component
public class OrderReviewPage extends StorefrontBasePage {

	final static Logger logger = Logger.getLogger(OrderReviewPage.class);
	private String pageUrlMethod = "/esab/en/checkout/multi/summary/view";
	private CheckoutDataModel checkoutDataModel;
	private String orderReviewPageHeader = "Order Review";

	@Override
	public String getPageUrl() {
		String orderReviewPageURL = storefrontProject.getBaseUrl() + pageUrlMethod;
		if (checkoutDataModel == null) {
			initCheckoutDataModel();
		}
		logger.info("Order Review Page URL: " + orderReviewPageURL);
		return orderReviewPageURL;
	}

	private void initCheckoutDataModel() {
		checkoutDataModel = checkoutDataController.getCheckoutDataModel();
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

	@Step("Get Sold To Addr")
	public void verifyShipToSoldToAddr() {
		waitJSExecution();
		List<WebElement> elements = getWebElements(XPATH_SHIPPING_INFO);
		logger.info("Ship to Sold to elements: " + elements);
		String validationText = "";

		if (checkoutDataModel.getStreetNumber().equals("")) {
			validationText = String.format("%s,  %s,  %s,  %s", checkoutDataModel.getStreetName(),
					checkoutDataModel.getTown(), checkoutDataModel.getPostalCode(), checkoutDataModel.getCountry());
		} else {
			validationText = String.format("%s,  %s, %s  %s,  %s", checkoutDataModel.getStreetName(),
					checkoutDataModel.getStreetNumber(), checkoutDataModel.getTown(), checkoutDataModel.getPostalCode(),
					checkoutDataModel.getCountry());
		}

		for (WebElement element : elements) {
			String actualText = element.getText();
			assertTrue(actualText.contains(validationText),
					"Actual text: <" + actualText + "> not contains <\n" + validationText + ">");
			logger.info("Validation text: " + validationText);
			logger.info("SOld To addr: \n" + actualText);

		}
	}

	private void verifyValue(String xpath, String validationValue) {
		assertTrue(isStringContainsText(xpath, validationValue), "There is no such value: " + validationValue);
		logger.info("Element value is correct");
	}

	@Step("Verify Purchase Order Number")
	public void verifyPurchaseOrderNumber() {
		verifyValue(String.format(XPATH_PURCHASE_ORDER_VALUE, checkoutDataModel.getPurchaseOrderNumber()),
				checkoutDataModel.getPurchaseOrderNumber());
	}

	@Step("Verify page header on Order Review")
	public void verifyHeader() {
		verifyWebElementTextValue(orderReviewPageHeader, XPATH_ORDER_REVIEW_PAGE_HEADER);
	}

	@Step("Verify Account Number on Order Review")
	public void verifyAccountNumber() {
		verifyValue(XPATH_ACCOUNT_NUMBER, checkoutDataModel.getAccount());
	}

	@Step("Verify Requested Deliver Date")
	public void verifyRequestedDeliveryDate() {
		verifyValue(XPATH_REQUESTED_DELIVERY_DATE, checkoutDataModel.getRequestedDeliveryDate());
	}

}
