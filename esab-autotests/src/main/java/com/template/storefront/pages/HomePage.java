package com.template.storefront.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.template.storefront.page_blocks.HeaderRowPageBlock;

import ru.yandex.qatools.allure.annotations.Step;

@Component
public class HomePage extends StorefrontBasePage {

	@Autowired
	HeaderRowPageBlock headerRowPageBlock;
	private final String pageUrlMethod = "/esab/en/";

	public boolean pageIsOpened() {
		return isCurrentURLEqualsToHomePageURL();
	}

	public boolean userIsLoggedIn() {
		return isUserLoggedInEsab();
	}

	
	private boolean isCurrentURLEqualsToHomePageURL() {
		return getPageUrl().equals(getCurrentUrl());
	}
	
	@Step("Check that current url is Home page url.")
	public void isCurrentURLDashboardPageURL(){
		String expectedUrl = getPageUrl();
		isCurrentUrlExpectedURL(expectedUrl);
	}

	@Step("Navigate to Shopping Cart.")
	public void navigateToShoppingCartByIcon() {
		headerRowPageBlock.navigateToShoppingCartByIcon();
	}

	@Override
	public String getPageUrl() {
		return storefrontProject.getBaseUrl() + pageUrlMethod;
	}
}
