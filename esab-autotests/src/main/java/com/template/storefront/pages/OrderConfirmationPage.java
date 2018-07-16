package com.template.storefront.pages;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import static com.template.storefront.page_elements.OrderConfirmationPageElements.*;

import ru.yandex.qatools.allure.annotations.Step;

@Component
public class OrderConfirmationPage extends OrderReviewPage {

	final static Logger logger = Logger.getLogger(OrderConfirmationPage.class);
	private String pageUrlMethodRaw = "/esab/en/checkout/orderConfirmation/%s";
	private String pageUrlMethod = "";

	public OrderConfirmationPage() {
		super();
	}
	
	/*private void generateOrderIdAccordingToShoppingCartId(){
		int intValueOfShoppingCart = Integer.valueOf(shoppingCartDataHelper.getShoppingCartID());
		logger.info("Int value of ID: " + intValueOfShoppingCart);
		int str1 = shoppingCartDataHelper.getShoppingCartID().lastIndexOf("0");		
		Subst
		//String str1 = shoppingCartDataHelper.getShoppingCartID().substring(beginIndex, endIndex)
		
	}*/

	@Step("Verify is current page Order Confirmation page")
	public void isCurrentPageOrderConfirmationPage() {
		String orderNumber = getWebElement(XPATH_ORDER_NUMBER).getText().trim();
		pageUrlMethod = String.format(pageUrlMethodRaw, orderNumber);
		String expectedURL = getPageUrl(pageUrlMethod);
		isCurrentUrlExpectedURL(expectedURL);
	}
	
	@Step("Verify Get Sold Addr")
	public void verifyAddresses(){
		verifyShipToSoldToAddr();
	}
	

}
