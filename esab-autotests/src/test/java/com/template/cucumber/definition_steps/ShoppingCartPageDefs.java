package com.template.cucumber.definition_steps;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.template.helpers.user_engine.UserSessions;
import com.template.storefront.pages.ShoppingCartPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class ShoppingCartPageDefs extends AbstractStepDefs {
	final static Logger logger = Logger.getLogger(HomePageStepDefs.class);

	@Autowired
	public UserSessions userSessions;
	@Autowired
	public ShoppingCartPage shoppingCartPage;

	@Then("^Verify current page is Shopping Cart page.$")
	public void verifyShoppingCartPageURL() {
		shoppingCartPage.isCurrentPageUrlShoppingCartUrl();
	}

	@And("^Verify h2 header1 on Shopping cart.$")
	public void verifyH2Header1() {
		shoppingCartPage.verifyShoppingCartHeader1();
	}

	@And("^Verify h2 header2 on Shopping cart.$")
	public void verifyH2Header2() {
		shoppingCartPage.verifyShoppingCartHeader2();
	}

	@And("^Verify Header2 subtitle on Shopping Cart.$")
	public void verifyHeader2Subtitle() {
		shoppingCartPage.verifyH2Header2Subtitle();
	}
	
	@And ("^Verify Ship-To address value on Shopping Cart.$")
	public void VerifyShipToAddr(){
		shoppingCartPage.verifyShipToValue();
	}
	
	@And ("^Select Ship To address on Shopping Cart.$")
	public void selectShipToAddr(){
		shoppingCartPage.selectShipToAddress();
	}
	
	@And ("^Verify SKU Inputs count on Shopping Cart is: \"(.*)\" .$")
	public void verifySkuCount(int validationSKUCount){
		shoppingCartPage.verifySkuInputsCount(validationSKUCount);
	}
	
	@And ("^Click on Add more products link on Shopping Cart.$")
	public void clickMoreProducts(){
		shoppingCartPage.clickMoreProducts();
	}
	
	@And ("^Verify add to cart button label on Shopping Cart.$")
	public void verifyAddToCartButtonLAbel(){
		shoppingCartPage.verifyAddToCartButtonLabel();
	}
	
	@And ("^Click on Add these products to shopping cart button.$")
	public void clickOnAddProductsButton(){
		shoppingCartPage.clickAddProductsButton();
	}

}
