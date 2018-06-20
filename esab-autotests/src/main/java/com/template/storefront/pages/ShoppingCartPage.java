package com.template.storefront.pages;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import ru.yandex.qatools.allure.annotations.Step;
import static com.template.storefront.page_elements.ShoppingCartPageElements.*;

@Component
public class ShoppingCartPage extends StorefrontBasePage {
	final static Logger logger = Logger.getLogger(RegisterPage.class);
	private String pageUrlMethod = "/esab/en/cart";
	private List<String> h2HeaderTexts = new ArrayList<>(Arrays.asList("Shopping Cart", "Add new item")); 

	@Override
	public String getPageUrl() {
		String shoppingCartPageURL = storefrontProject.getBaseUrl() + pageUrlMethod;
		logger.info("Shopping Cart URL: " + shoppingCartPageURL);
		return shoppingCartPageURL;
	}

	@Step("Verify current page is Cart page")
	public void isCurrentPageUrlShoppingCartUrl() {
		String expectedUrl = getPageUrl();
		isCurrentUrlExpectedURL(expectedUrl);
	}
	
	@Step("Verify Shopping cart headers h2")
	public void verifyShoppingCartHeaders(){
		verifyWebElementsTextValuesEqual(h2HeaderTexts, H2_HEADERS_XPATH);
	}

}
