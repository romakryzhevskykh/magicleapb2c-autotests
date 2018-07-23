package com.template.storefront.pages;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import ru.yandex.qatools.allure.annotations.Step;

import static com.template.storefront.page_elements.SavedCartDetailsPageElements.*;

@Component
public class SavedCartDetailsPage extends StorefrontBasePage {
	final static Logger logger = Logger.getLogger(SavedCartDetailsPage.class);
	private String pageUrlMethod = "/esab/en/my-account/saved-carts/";
	private String savedCartId = "";

	@Override
	public String getPageUrl() {
		getSavedCartId();
		String savedCartDetailsPageURL = storefrontProject.getBaseUrl() + pageUrlMethod + savedCartId;
		logger.info("Saved Cart Details URL: " + savedCartDetailsPageURL);
		return savedCartDetailsPageURL;
	}

	private void getSavedCartId() {
		savedCartId = getWebElement(XPATH_SAVED_CART_DETAILS_ID).getText().trim();
	}
	
	@Step("Verify current page is Saved Cart Details page")
	public void isCurrentPageUrlSavedCartDetailsUrl(){
		waitJSExecution();
		String expectedUrl = getPageUrl();
		isCurrentUrlExpectedURL(expectedUrl);
	}

}
