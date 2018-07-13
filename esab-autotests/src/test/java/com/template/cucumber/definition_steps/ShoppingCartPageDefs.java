package com.template.cucumber.definition_steps;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.template.helpers.user_engine.UserSessions;
import com.template.storefront.pages.ShoppingCartPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
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
		shoppingCartPage.getShoppingCartID();
	}

	@And("^Verify h2 header2 on Shopping cart.$")
	public void verifyH2Header2() {
		shoppingCartPage.verifyShoppingCartHeader2();
	}

	@And("^Verify Header2 subtitle on Shopping Cart.$")
	public void verifyHeader2Subtitle() {
		shoppingCartPage.verifyH2Header2Subtitle();
	}

	@And("^Verify Ship-To address value on Shopping Cart.$")
	public void VerifyShipToAddr() {
		shoppingCartPage.verifyShipToValue();
	}

	@And("^Select Ship To address on Shopping Cart.$")
	public void selectShipToAddr() {
		shoppingCartPage.selectShipToAddress();
	}

	@And("^Verify SKU Inputs count on Shopping Cart is: \"(.*)\" .$")
	public void verifySkuCount(int validationSKUCount) {
		shoppingCartPage.verifySkuInputsCount(validationSKUCount);
	}

	@And("^Click on Add more products link on Shopping Cart.$")
	public void clickMoreProducts() {
		shoppingCartPage.clickMoreProducts();
	}

	@And("^Verify add to cart button label on Shopping Cart.$")
	public void verifyAddToCartButtonLAbel() {
		shoppingCartPage.verifyAddToCartButtonLabel();
	}

	@And("^Click on Add these products to shopping cart button.$")
	public void clickOnAddProductsButton() {
		shoppingCartPage.clickAddProductsButton();
	}

	@Then("^Fill in Qty fields on Shopping Cart.$")
	public void fillInQty() {
		shoppingCartPage.fillInQtyFields();
	}

	@Given("^Add Product model: SCU: \"(.*)\", Qty: \"(.*)\", Price: \"(.*)\","
			+ " Product name: \"(.*)\", In Stock: \"(.*)\".$")
	public void addProductToList(String newScu, String newQty, String newPrice, String newProductName,
			String newInStock) {
		shoppingCartPage.addProductToTheList(newScu, newQty, newPrice, newProductName, newInStock);
	}

	@And("^Get list of Products.$")
	public void getListOfProducts() {
		shoppingCartPage.getListOfProducts();
	}

	@And("^Fill in SCU and Qty from Product Model.$")
	public void fiilInQtyFromProductModel() {
		shoppingCartPage.fillInFieldFromObjectModel();
	}

	@And("^Verify product names on Shopping Cart.$")
	public void verifyProductName() {
		shoppingCartPage.verifyProductNameInCart();
	}

	@And("^Verify product SCU on Shopping Cart.$")
	public void verifySCU() {
		shoppingCartPage.verifyScuInCart();
	}

	@And("^Verify In Stock value on Shopping Cart.$")
	public void verifyInStock() {
		shoppingCartPage.verifyInStock();
	}

	@And("^Verify Product Price on Shopping Cart.$")
	public void verifyProductPriceByScu() {
		shoppingCartPage.verifyPriceBySCU();
	}

	@And("^Verify Total Price on Shopping Cart.$")
	public void verifyTotalPrice() {
		shoppingCartPage.verifyTotalPriceInList();
	}

	@And("^Remove all products by SCU on Shopping Cart.$")
	public void removeAllProductsByScu() {
		shoppingCartPage.clickOnRemoveProductByScu();
	}

	@And("^Verify Subtotal price on Shopping Cart.$")
	public void verifySubtotal() {
		shoppingCartPage.verifySubtotal();
	}

	@And("^Verify Save Cart button label.$")
	public void verifySaveCartButtonLbel() {
		shoppingCartPage.verifySaveCartButtonLabel();
	}

	@And("^Click on Save shopping cart button.$")
	public void clickSaveShoppingCartButton() {
		shoppingCartPage.clickOnSaveCartButton();
	}

	@And("^Verify Check Out button label.$")
	public void verifyCheckOutButtonLabel() {
		shoppingCartPage.verifyCheckoutButtonLabel();
	}

	@And("^Click on Check Out button.$")
	public void clickOnCheckOutButton() {
		shoppingCartPage.clickOnCheckOutButton();
	}
	
	@And("^Save Product Price, Product Total Price, Products Subtotal of Products on Shopping Cart page.$")
	public void testGetMap(){
		shoppingCartPage.savePricesTotalPricesAndSubtotal();
	}

	@And("^Remove all products on Shopping Cart.$")
	public void removeAllProducts(){
		shoppingCartPage.removeAllProducts();
	}
}
