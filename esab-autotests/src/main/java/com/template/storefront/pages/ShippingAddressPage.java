package com.template.storefront.pages;

import static com.template.storefront.page_elements.ShippingAddressPageElements.*;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import ru.yandex.qatools.allure.annotations.Step;

@Component
public class ShippingAddressPage extends StorefrontBasePage {

	private String pageUrlMethod = "/esab/en/checkout/multi/delivery-address/add";
	final static Logger logger = Logger.getLogger(ShippingAddressPage.class);
	private String shippingInstructions = "Shipping Instructions";

	@Override
	public String getPageUrl() {
		String shippingAddressPageURL = storefrontProject.getBaseUrl() + pageUrlMethod;
		logger.info("Shipping Address URL: " + shippingAddressPageURL);
		return shippingAddressPageURL;
	}

	@Step("Fill in Shipping Instructions")
	public void fillInShippingInstructions() {
		fillInTextInput(shippingInstructions, XPATH_SHIPPING_INSTRUCTIONS_INPUT );
	}

	@Step("Verify current page is Shipping Addr page")
	public void isCurrentPageShippingAddrPage() {
		String expectedUrl = getPageUrl();
		isCurrentUrlExpectedURL(expectedUrl);
	}
	
	@Step("Click on Next button")
	public void clickOnNextButtonOnShippingAddrPage(){
		click(XPATH_NEXT_BUTTOON_SHIPPING_ADDR);
	}

}
