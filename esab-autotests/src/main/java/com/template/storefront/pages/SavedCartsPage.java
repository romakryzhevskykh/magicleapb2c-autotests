package com.template.storefront.pages;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import ru.yandex.qatools.allure.annotations.Step;

import static com.template.storefront.page_elements.SavedCartsPageElements.*;

@Component
public class SavedCartsPage extends StorefrontBasePage {
	final static Logger logger = Logger.getLogger(SavedCartsPage.class);
	private String pageUrlMethod = "/my-account/saved-carts";

	@Override
	public String getPageUrl() {
		String savedCartsPageURL = storefrontProject.getBaseUrl() + pageUrlMethod;
		logger.info("Saved Carts URL: " + savedCartsPageURL);
		return savedCartsPageURL;
	}
	
	@Step("Verify current page is Saved Carts page")
	public void isCurrentPageUrlSavedCartsUrl(){
		waitJSExecution();
		String expectedUrl = getPageUrl();
		isCurrentUrlExpectedURL(expectedUrl);
	}
}
