package com.template.storefront.pages;

import static com.template.storefront.page_elements.ShippingAddressPageElements.*;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.template.storefront.models.CheckoutDataModel;

import ru.yandex.qatools.allure.annotations.Step;

@Component
public class ShippingAddressPage extends StorefrontBasePage {

	private String pageUrlMethod = "/esab/en/checkout/multi/delivery-address/add";
	private String pageUrlMethodAfterValidationError = "/esab/en/checkout/multi/delivery-address/shipInfo";
	final static Logger logger = Logger.getLogger(ShippingAddressPage.class);
	private String shippingInstructions = "Shipping Instructions";
	private String shippingInstructionsValidationMessage = "Please provide shipping instructions for your order";
	private CheckoutDataModel checkoutDataModel;

	@Override
	public String getPageUrl() {
		return getPageUrlParametrick(pageUrlMethod);
	}

	public void createCheckoutDataModel(String newStreetName, String newStreetNumber, String newPostalCode,
			String newTown, String newCountry, String newRequestedDeliveryDate, String newPartialDeliveryAllowed,
			String newAccount, String newPackagingInstructions, String newShippingInstructions,
			String newPurchaseOrderNumber) {
		checkoutDataController.createCheckoutDataModel(newStreetName, newStreetNumber, newPostalCode, newTown,
				newCountry, newRequestedDeliveryDate, newPartialDeliveryAllowed, newAccount, newPackagingInstructions,
				newShippingInstructions, newPurchaseOrderNumber);
		checkoutDataModel = checkoutDataController.getCheckoutDataModel();
	}

	private String getPageUrlParametrick(String pageUrlMethod) {
		String shippingAddressPageURL = storefrontProject.getBaseUrl() + pageUrlMethod;
		logger.info("Shipping Address URL: " + shippingAddressPageURL);
		return shippingAddressPageURL;
	}

	@Step("Fill in Shipping Instructions")
	public void fillInShippingInstructions() {
		fillInTextInput(checkoutDataController.getCheckoutDataModel().getShippingInstructions(), XPATH_SHIPPING_INSTRUCTIONS_INPUT);
	}

	@Step("Fill in Packcaging Instructions")
	public void fillInPackagingInstructions() {
		fillInTextInput(checkoutDataModel.getPackagingInstructions(), XPATH_PACKAGING_INSTRUCTIONS_TEXTAREA);
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
	public void clearShippingInstructions() {
		clear(XPATH_SHIPPING_INSTRUCTIONS_INPUT);
	}

	@Step("Clear Packaging Instructions textarea")
	public void clearPackagingInstructions() {
		clear(XPATH_PACKAGING_INSTRUCTIONS_TEXTAREA);
	}

	@Step("Click on Next button")
	public void clickOnNextButtonOnShippingAddrPage() {
		click(XPATH_NEXT_BUTTOON_SHIPPING_ADDR);
	}

	@Step("Fill in requested Deliery Date")
	public void fillInRequestedDate() {
		fillInTextInput(checkoutDataModel.getRequestedDeliveryDate(), XPATH_REQUESTED_DELIVERY_DATE);
	}

	@Step("Verify Shipping Instructions validation message")
	public void verifyShippingInstructionValidationMessage() {
		verifyWebElementTextValue(shippingInstructionsValidationMessage, XPATH_VALIDATION_ERROR);
	}

	private void clickOnPartialDeliveryRadioButton(String selection) {
		click(String.format(XPATH_PARTIAL_DELIVERY_RADIO_BUTTON, selection));
	}

	@Step("Click on partial delivery button according to data model")
	public void clickOnRadioButtonAccordingToDataModel() {
		clickOnPartialDeliveryRadioButton(checkoutDataModel.getPartialDeliveryAllowed());
	}

	@Step("Click on Yes radio button")
	public void clickOnYesButon() {
		clickOnPartialDeliveryRadioButton("Yes");
	}

	@Step("Click on No radio button")
	public void clickOnNoButton() {
		clickOnPartialDeliveryRadioButton("No");
	}

	@Step("Clear Requested Delivery date")
	public void clearRequestedDelivery() {
		clear(XPATH_REQUESTED_DELIVERY_DATE);
	}

	@Step("Click on Modify Address button")
	public void clickOnModifyAddressButton() {
		click(XPATH_MODIFY_ADDRESS_BUTTON);
	}
	
	@Step ("Close modify Address Popup")
	public void closeModifyAddrPopup(){
		click(XPATH_CLOSE_MODIFY_ADDR_POPUP);
	}

}
