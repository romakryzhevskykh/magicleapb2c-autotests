package com.template.storefront.pages;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import ru.yandex.qatools.allure.annotations.Step;

import static com.template.storefront.page_elements.SavedCartsPageElements.*;

@Component
public class SavedCartsPage extends StorefrontBasePage {
	final static Logger logger = Logger.getLogger(SavedCartsPage.class);
	private String pageUrlMethod = "/my-account/saved-carts";
	private final int maxNumberOfCartsOnThePage = 5;

	@Override
	public String getPageUrl() {
		String savedCartsPageURL = storefrontProject.getBaseUrl() + pageUrlMethod;
		logger.info("Saved Carts URL: " + savedCartsPageURL);
		return savedCartsPageURL;
	}

	@Step("Verify current page is Saved Carts page")
	public void isCurrentPageUrlSavedCartsUrl() {
		waitJSExecution();
		String expectedUrl = getPageUrl();
		isCurrentUrlExpectedURL(expectedUrl);
	}

	@Step("Go to Saved cart details page")
	public void goToSavedCartDetails() {
		click(String.format(XPATH_SAVED_CART_NAME, shoppingCartDataHelper.getSavedCardName()));
	}

	@Step("Get number of carts")
	public void getSavedCartsNumber() {
		int countOfCartsOnthePage = parsePaginationBarResults(XPATH_SAVED_CARTS_LIST, XPATH_PAGINATION_BAR_RESULTS,
				"Saved", maxNumberOfCartsOnThePage);
		savedCartsDataExchanger.setSavedCartsCount(countOfCartsOnthePage);
		logger.info("Qty of saved carts in the list: " + savedCartsDataExchanger.getSavedCartsCount());
	}
}
