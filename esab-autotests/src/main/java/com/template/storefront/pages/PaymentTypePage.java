package com.template.storefront.pages;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.template.storefront.models.CheckoutDataModel;

import static com.template.storefront.page_elements.PaymentTypePageElements.*;

import ru.yandex.qatools.allure.annotations.Step;

@Component
public class PaymentTypePage extends StorefrontBasePage {

	final static Logger logger = Logger.getLogger(PaymentTypePage.class);
	private String pageUrlMethod = "/esab/en/checkout/multi/payment-type/choose";
	private String orderNumber = "Purchase Order Number";
	private String validationErrorText = "Errors were found with the purchase order number you provided";
	private CheckoutDataModel checkoutDataModel;

	@Override
	public String getPageUrl() {
		String paymentTypePageUrl = storefrontProject.getBaseUrl() + pageUrlMethod;
		if (checkoutDataModel == null) {
			initCheckoutDataModel();
		}
		logger.info("Register page URL: " + paymentTypePageUrl);
		return paymentTypePageUrl;
	}

	private void initCheckoutDataModel() {
		checkoutDataModel = checkoutDataController.getCheckoutDataModel();
	}

	@Step("Verify current page is Payment Type page")
	public void isCurrentPagePaymentTypePage() {
		String expectedUrl = getPageUrl();
		isCurrentUrlExpectedURL(expectedUrl);
	}

	@Step("Fill in Purchase Order Number")
	public void fillInOrderNumber() {
		fillInTextInput(checkoutDataModel.getPurchaseOrderNumber(), XPATH_ORDER_NUMBER);
	}

	@Step("Click On Next Button")
	public void cliclOnNextPaymentOrderPage() {
		click(XPATH_NEXT_PAYMENT_TYPE);
	}

	@Step("Clear Purchase Order Number on Payment Type page")
	public void clearPurchaseOrderNumber() {
		clear(XPATH_ORDER_NUMBER);
	}

	@Step("Verify empty Purchase Order Number field validation on Payment Type page")
	public void verifyValidationText() {
		verifyWebElementTextValue(validationErrorText, XPATH_VALIDATION_ERROR);
	}

}
