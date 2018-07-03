package com.template.storefront.pages;

import static com.template.storefront.page_elements.ShippingAddressPageElements.*;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import ru.yandex.qatools.allure.annotations.Step;

@Component
public class ShippingAddressPage extends StorefrontBasePage {

	private String pageUrlMethod = "/esab/en/checkout/multi/delivery-address/add";
	private String pageUrlMethodAfterValidationError = "/esab/en/checkout/multi/delivery-address/shipInfo";
	final static Logger logger = Logger.getLogger(ShippingAddressPage.class);
	private String shippingInstructions = "Shipping Instructions";
	private String requestedDate = "09/05/2018";
	private String shippingInstructionsValidationMessage = "Please provide shipping instructions for your order";

	@Override
	public String getPageUrl() {
		return getPageUrlParametrick(pageUrlMethod);
	}

	public String getPageUrlParametrick(String pageUrlMethod) {
		String shippingAddressPageURL = storefrontProject.getBaseUrl() + pageUrlMethod;
		logger.info("Shipping Address URL: " + shippingAddressPageURL);
		return shippingAddressPageURL;
	}

	@Step("Fill in Shipping Instructions")
	public void fillInShippingInstructions() {
		fillInTextInput(shippingInstructions, XPATH_SHIPPING_INSTRUCTIONS_INPUT);
	}

	@Step("Verify current page is Shipping Addr page")
	public void isCurrentPageShippingAddrPage() {
		String expectedUrl = getPageUrl();
		isCurrentUrlExpectedURL(expectedUrl);
	}

	@Step("Verify current page is Shipping Addr page after validation error")
	public void isCurrentPageShippingPageAfterError() {
		String expectedUrl = getPageUrlParametrick(pageUrlMethodAfterValidationError);
		isCurrentUrlExpectedURL(expectedUrl);
	}

	@Step("Clear Shipping Instructions")
	public void clearSippingInstructions() {
		clear(XPATH_SHIPPING_INSTRUCTIONS_INPUT);
	}

	@Step("Click on Next button")
	public void clickOnNextButtonOnShippingAddrPage() {
		click(XPATH_NEXT_BUTTOON_SHIPPING_ADDR);
	}

	@Step("Fill in requested Deliery Date")
	public void fillInRequestedDate() {
		fillInTextInput(requestedDate, XPATH_REQUESTED_DELIVERY_DATE);
	}

	@Step("Verify Shipping Instructions validation message")
	public void verifyShippingInstructionValidationMessage() {
		verifyWebElementTextValue(shippingInstructionsValidationMessage, XPATH_VALIDATION_ERROR);
	}

}
