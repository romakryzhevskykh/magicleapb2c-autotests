package com.template.storefront.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import com.template.storefront.models.CheckoutDataModel;
import com.template.storefront.models.ProductModel;

import ru.yandex.qatools.allure.annotations.Step;

import static com.template.storefront.page_elements.ShoppingCartPageElements.*;

@Component
public class ShoppingCartPage extends StorefrontBasePage {

	final static Logger logger = Logger.getLogger(ShoppingCartPage.class);
	private String pageUrlMethod = "/esab/en/cart";
	private String validationHeaderTitle2 = "Add new item";
	private String validationHeader2Subtitle = "Fill out the form below to add products to your order or click here to upload an order instead.";
	private String validationHeaderTitle1 = "Shopping Cart";
	private String validationAddToCartButtonLabel = "Add these products to shopping cart";
	private List<String> dataForQtyFields = new ArrayList<>(Arrays.asList("11", "22"));
	private String saveCartBauutonLabel = "SAVE CART";
	private String validationShipToAddr;
	private String checkOutButtonLabel = "Check Out";
	private CheckoutDataModel checkoutDataModel;
	List<ProductModel> products = new ArrayList<>();

	@Override
	public String getPageUrl() {
		String shoppingCartPageURL = storefrontProject.getBaseUrl() + pageUrlMethod;
		logger.info("Shopping Cart URL: " + shoppingCartPageURL);
		if (products.isEmpty()) {
			products = productController.getListOfProducts();
		}
		return shoppingCartPageURL;
	}

	@Step("Verify current page is Cart page")
	public void isCurrentPageUrlShoppingCartUrl() {
		waitJSExecution();
		String expectedUrl = getPageUrl();
		isCurrentUrlExpectedURL(expectedUrl);
	}

	public String getShoppingCartHeaderValue(String headerXpath) {
		String shoppingCartHeader = getWebElement(headerXpath).getText().trim();
		logger.info("Header value is: " + shoppingCartHeader);
		return shoppingCartHeader;
	}

	@Step("Verify Shopping cart header_1 h2")
	public void verifyShoppingCartHeader1() {
		String actualHeader1 = getShoppingCartHeaderValue(H2_SHOPPING_CART_TITLE);
		assertTrue(actualHeader1.contains(validationHeaderTitle1), "Actual Shopping cart header1: " + actualHeader1
				+ " but validation value is : " + validationHeaderTitle1);
	}

	@Step("Verify Shopping cart header_2 h2")
	public void verifyShoppingCartHeader2() {
		verifyWebElementTextValue(validationHeaderTitle2, H2_SHOPPING_CART_TITLE2);
	}

	@Step("Verify Shopping Cart Header2 subtitle")
	public void verifyH2Header2Subtitle() {
		verifyWebElementTextValue(validationHeader2Subtitle, HEADER2_SUBTITLE);
	}

	private void createShipToAddrFromDataModel() {
		checkoutDataModel = checkoutDataController.getCheckoutDataModel();
		if (!checkoutDataModel.getStreetNumber().equals("")) {
			validationShipToAddr = String.format("%s, %s, %s, %s", checkoutDataModel.getStreetName(),
					checkoutDataModel.getStreetNumber(), checkoutDataModel.getTown(),
					checkoutDataModel.getPostalCode());
		} else {
			validationShipToAddr = String.format("%s, %s, %s", checkoutDataModel.getStreetName(),
					checkoutDataModel.getTown(), checkoutDataModel.getPostalCode());
		}

		logger.info("Generated Ship To Address: " + validationShipToAddr);
	}

	@Step("Verify Ship-To address value")
	public void verifyShipToValue() {
		waitJSExecution();
		createShipToAddrFromDataModel();
		verifyWebElementTextValue(validationShipToAddr, String.format(SHIP_TO_VALUE, validationShipToAddr));
	}

	@Step("Select Ship to Addr Value")
	public void selectShipToAddress() {
		createShipToAddrFromDataModel();
		click(String.format(SHIP_TO_VALUE, validationShipToAddr));
	}

	@Step("Verify SKU Input count")
	public void verifySkuInputsCount(int validationSKUCount) {
		waitJSExecution();
		int actualSkuInputCount = getWebElements(SKU_INPUT_XPATH).size();
		logger.info("Actual SKU Inputs count is: " + actualSkuInputCount);
		assertEquals(actualSkuInputCount, validationSKUCount, "Actual SKU Input Count is: " + actualSkuInputCount
				+ " but expected SKU Count is: " + validationSKUCount);
	}

	@Step("Press on Add more products link")
	public void clickMoreProducts() {
		click(ADD_MORE_PRODUCTS_XPATH);
	}

	@Step("Verify add to cart button label")
	public void verifyAddToCartButtonLabel() {
		verifyWebElementTextValue(validationAddToCartButtonLabel, ADD_TO_CART_BUTTON_XPATH);
	}

	@Step("Click on Add to products to shopping cart button")
	public void clickAddProductsButton() {
		click(ADD_TO_CART_BUTTON_XPATH);
	}

	@Step("Fill in Qty fields")
	public void fillInQtyFields() {
		fillInSeveralFields(dataForQtyFields, QTY_FIELDS_XPATH);
	}

	public void addProductToTheList(String newScu, String newQty, String newPrice, String newProductName,
			String newInStock) {
		productController.addProductToCollection(newScu, newQty, newPrice, newProductName, newInStock);
	}

	public List<ProductModel> getListOfProducts() {
		return productController.getListOfProducts();
	}

	public void fillInFieldFromObjectModel() {
		List<String> qtys = new ArrayList<String>();
		List<String> scus = new ArrayList<String>();
		String productQty = null;
		String productScu = null;
		waitJSExecution();
		if (products != null) {
			for (ProductModel product : products) {
				productQty = product.getQty();
				productScu = product.getScu();
				logger.info("Product Qty: " + productQty);
				logger.info("Product SCU: " + productScu);
				qtys.add(productQty);
				scus.add(productScu);
			}
		}
		logger.info("Product Qtys: " + qtys);
		logger.info("Product Scus: " + scus);
		fillInSeveralFields(scus, SKU_INPUT_XPATH);
		fillInSeveralFields(qtys, QTY_FIELDS_XPATH);
	}

	@Step("Verify product name ")
	public void verifyProductNameInCart() {
		waitJSExecution();
		if (products != null) {
			for (ProductModel product : products) {
				verifyWebElementTextValue(product.getProductName(),
						String.format(PRODUCT_NAME_FOR_VERIFICATION_XPATH, product.getProductName()));
			}
		}
	}

	@Step("Verify product SCU ")
	public void verifyScuInCart() {
		waitJSExecution();
		if (products != null) {
			for (ProductModel product : products) {
				verifyWebElementTextValue(product.getScu(), String.format(PRODUCT_SCU_XPATH, product.getScu()));
			}
		}
	}

	@Step("Verify In Stock value")
	public void verifyInStock() {
		waitJSExecution();
		if (products != null) {
			for (ProductModel product : products) {
				verifyWebElementTextValue(product.getInStock(),
						String.format(PRODUCT_INSTOCK_XPATH, product.getInStock()));
			}
		}
	}

	public void saveShoppingCartID() {
		String actualHeader1 = getShoppingCartHeaderValue(H2_SHOPPING_CART_TITLE);
		int indexOfDelimeter = actualHeader1.indexOf(':');
		String shoppingCartID = (String) actualHeader1.subSequence(indexOfDelimeter + 1, actualHeader1.length());
		logger.info("Shopping Cart ID is: " + shoppingCartID);
		shoppingCartDataHelper.setShoppingCartID(shoppingCartID);
	}

	@Step("Verify price by SCU")
	public void verifyPriceBySCU() {
		waitJSExecution();
		if (products != null) {
			for (ProductModel product : products) {
				String actualPriceRaw = getWebElement(String.format(PRODUCT_PRICE_XPATH, product.getScu())).getText()
						.trim();
				if (actualPriceRaw != null) {
					String actualPrice = getPriceWithoutDollarChar(actualPriceRaw);
					String expectedPrice = product.getPrice();
					assertEquals(actualPrice, expectedPrice,
							"Expected price is: " + expectedPrice + " but actual is: " + actualPrice);
				}
			}
		}
	}

	private String getPriceWithoutDollarChar(String sourceString) {
		/*
		 * String resultString = null; if ((sourceString != null) &&
		 * (sourceString.length() > 0)) { resultString = (String)
		 * sourceString.subSequence(1, sourceString.length());
		 * logger.info("String without dollar char is: " + resultString); } else
		 * { logger.error("Source string equals 0 or null. Source string = " +
		 * sourceString); }
		 */
		if ((sourceString != null) && (sourceString.length() > 0) && (sourceString.contains("$"))) {
			sourceString = sourceString.replace("$", "");
			logger.info("String without dollar char is: " + sourceString);
		} else {
			logger.error("Source string equals 0 or null. Source string = " + sourceString);
		}
		return sourceString;
	}

	private void calculateAndCompareTotlaPrice(float actualQty, float actualPrice, float actualTotalPrice) {
		if ((actualPrice > 0) && (actualQty > 0)) {
			float expectedTotalPrice = actualPrice * actualQty;
			logger.info("Actual Total price float value: " + actualPrice);
			assertTrue((actualTotalPrice == expectedTotalPrice),
					"Actual total price is: " + actualTotalPrice + " but expected is: " + expectedTotalPrice);
		} else {
			logger.error("Actual price or Qty equals 0. Actual price = " + actualPrice + " Qty = " + actualQty);
		}
	}

	@Step("Verify Total price of Product in the list")
	public void verifyTotalPriceInList() {
		waitJSExecution();

		if (products != null) {
			for (ProductModel product : products) {
				String productScu = product.getScu();
				String actualPriceRaw = getWebElement(String.format(PRODUCT_PRICE_XPATH, productScu)).getText().trim();
				logger.info("Raw Price = " + actualPriceRaw);
				String actualQty = getWebElement(String.format(PRODUCT_QTY_XPATH, productScu)).getAttribute("value")
						.trim();
				logger.info("Raw Qty = " + actualQty);
				String actualTotalPriceRaw = getWebElement(String.format(PRODUCT_TOTAL_PRICE, productScu)).getText()
						.trim();
				logger.info("Raw total price = " + actualTotalPriceRaw);
				String actualPrice = getPriceWithoutDollarChar(actualPriceRaw);
				String actualTotalPrice = getPriceWithoutDollarChar(actualTotalPriceRaw);
				float actualPriceNumber = castStringToFloat(actualPrice);
				float actualQtyNumber = castStringToFloat(actualQty);
				float totalPriceNumber = castStringToFloat(actualTotalPrice);
				calculateAndCompareTotlaPrice(actualQtyNumber, actualPriceNumber, totalPriceNumber);
			}
		}
	}

	@Step("Remove all products by scu")
	public void clickOnRemoveProductByScu() {
		waitJSExecution();
		if (products != null) {
			for (ProductModel product : products) {
				String productSCU = product.getScu();
				// TODO Need to refactor in future. Sometimes element is not
				// attached webdriver message shown on attempt to delete
				// products.
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					logger.info("Time Unit method failed");
				}
				logger.info("Delete product by SCU: " + productSCU);
				click(String.format(PRODUCT_DETAILS_BUTTON_XPATH, productSCU));
				logger.info("Click on product details button");
				click(String.format(PRODUCT_REMOVE_BUTTON_XPATH, productSCU));
				logger.info("Click on Remove button");
			}
		}
	}

	private List<String> getListOfAddedSCUS() {
		waitJSExecution();
		WebElement productQtyElement = getWebElement(PRODUCTS_QTY_FROM_CART_ICON);
		String productQtyNumber = productQtyElement.getText().trim();
		logger.info("Prduct Qty according to Cart Icon in the header: " + productQtyNumber);
		if (!productQtyNumber.equals("0")) {
			List<WebElement> elements = getWebElements(TOTAL_COUNT_OF_PRODUCTS);
			List<String> elValues = new ArrayList<String>();
			if (elements != null) {
				for (WebElement element : elements) {
					String elementValue = element.getText().trim();
					elValues.add(elementValue);
					logger.info("SCUs: " + elValues);
				}
				return elValues;
			} else {
				logger.error("List of elements is null");
			}
		} else {
			logger.info("There is no Products in the cart");
		}
		return null;
	}

	@Step("Remove all Products")
	public void removeAllProducts() {
		List<String> elValues = getListOfAddedSCUS();
		if (elValues != null) {
			for (String elValue : elValues) {
				logger.info("Web element SCU to be removed: " + elValue);
				click(String.format(PRODUCT_DETAILS_BUTTON_XPATH, elValue));
				click(String.format(PRODUCT_REMOVE_BUTTON_XPATH, elValue));
			}
		} else {
			logger.info("Products SCU list is not allocated");
		}
	}

	private void saveListOfSCUs() {
		List<String> elValues = getListOfAddedSCUS();
		if (elValues != null) {
			shoppingCartDataHelper.setshoppingCartProductSCUs(elValues);
			logger.info("Saved SCUs: " + shoppingCartDataHelper.getshoppingCartProductSCUs());
		} else {
			logger.info("Products SCU list is not allocated");
		}

	}

	private void saveListOfProductsInCart(List<String> productSCUs) {
		if (!productSCUs.isEmpty()) {
			for (String scu : productSCUs) {
				String productNameByScu = getWebElement(String.format(PRODUCT_NAME_ELEMENT_XPATH, scu)).getText()
						.trim();
				shoppingCartDataHelper.addScuProductToMap(scu, productNameByScu);
			}
		}
	}

	@Step("Verify subtotal")
	public void verifySubtotal() {
		float expectedSubtotal = 0;
		waitJSExecution();
		String actualSubTotalRaw = getWebElement(SUBTOTAL_XPATH).getText().trim();
		logger.info("Subtotal price = " + actualSubTotalRaw);
		String actualSubtotal = getPriceWithoutDollarChar(actualSubTotalRaw);
		float actualSubtotalNumber = castStringToFloat(actualSubtotal);
		if (products != null) {
			for (ProductModel product : products) {
				String productScu = product.getScu();
				String actualTotalPriceRaw = getWebElement(String.format(PRODUCT_TOTAL_PRICE, productScu)).getText()
						.trim();
				logger.info("Raw total price = " + actualTotalPriceRaw);
				String actualTotalPrice = getPriceWithoutDollarChar(actualTotalPriceRaw);
				float totalPriceNumber = castStringToFloat(actualTotalPrice);
				expectedSubtotal += totalPriceNumber;
			}
			logger.info("Expected Subtotal is: " + expectedSubtotal + "\n");
			assertTrue((actualSubtotalNumber == expectedSubtotal),
					"Actual total price is: " + actualSubtotalNumber + " but expected is: " + expectedSubtotal);
		}
	}

	@Step("Verify Save Cart button label")
	public void verifySaveCartButtonLabel() {
		verifyWebElementTextValue(saveCartBauutonLabel, SAVE_CART_BUTTON_XPATH);
	}

	@Step("Click on Save Cart button")
	public void clickOnSaveCartButton() {
		waitJSExecution();
		click(SAVE_CART_BUTTON_XPATH);
	}

	@Step("Verify Check Out button label")
	public void verifyCheckoutButtonLabel() {
		verifyWebElementTextValue(checkOutButtonLabel, CHECKOUT_BUTTON_XPATH);
	}

	@Step("Clic on Check Out button")
	public void clickOnCheckOutButton() {
		waitJSExecution();
		click(CHECKOUT_BUTTON_XPATH);
	}

	private void addProductPriceMapping(List<String> productSCUs) {
		if (!productSCUs.isEmpty()) {
			for (String scu : productSCUs) {
				String actualPriceRaw = getWebElement(String.format(PRODUCT_PRICE_XPATH, scu)).getText().trim();
				logger.info("Raw Price = " + actualPriceRaw);
				String productNameByScu = shoppingCartDataHelper.getScuProductMap().get(scu);
				String actualPrice = getPriceWithoutDollarChar(actualPriceRaw);
				float actualPriceNumber = castStringToFloat(actualPrice);
				shoppingCartDataHelper.addProductNamePriceToMap(productNameByScu, actualPriceNumber);
			}
			Map<String, Float> productWithPrices = shoppingCartDataHelper.getProductWithPrices();
			logger.info("Values in product Map: " + productWithPrices);
			for (int i = 0; i < productWithPrices.size(); i++) {
				logger.info("Saved Prices: Product name: " + products.get(i).getProductName() + " Price: "
						+ productWithPrices.get(products.get(i).getProductName()));
			}
		}
	}

	private void addProductNameTotalPriceMapping(List<String> productSCUs) {
		if (!productSCUs.isEmpty()) {
			for (String scu : productSCUs) {
				String productNameByScu = shoppingCartDataHelper.getScuProductMap().get(scu);
				String actualTotalPriceRaw = getWebElement(String.format(PRODUCT_TOTAL_PRICE, scu)).getText().trim();
				logger.info("Raw total price = " + actualTotalPriceRaw);
				String actualTotalPrice = getPriceWithoutDollarChar(actualTotalPriceRaw);
				float totalPriceNumber = castStringToFloat(actualTotalPrice);
				shoppingCartDataHelper.addProductNameTotalPriceToMap(productNameByScu, totalPriceNumber);
			}
			Map<String, Float> productWithPrices = shoppingCartDataHelper.getProductWithTotalPrices();
			logger.info("Values in product Map: " + productWithPrices);
			for (int i = 0; i < productWithPrices.size(); i++) {
				logger.info("Saved Total Price: Product name: " + products.get(i).getProductName() + " Price: "
						+ productWithPrices.get(products.get(i).getProductName()));
			}
		}
	}

	private void saveSubtotalValue() {
		String actualSubTotalRaw = getWebElement(SUBTOTAL_XPATH).getText().trim();
		logger.info("Subtotal price = " + actualSubTotalRaw);
		String actualSubtotal = getPriceWithoutDollarChar(actualSubTotalRaw);
		float actualSubtotalNumber = castStringToFloat(actualSubtotal);
		shoppingCartDataHelper.setSubtotal(actualSubtotalNumber);
		logger.info("Saved Subtotal price = " + shoppingCartDataHelper.getSubtotal());
	}

	private void saveQtyValue(List<String> productSCUs) {
		if (!productSCUs.isEmpty()) {
			List<String> qtys = new ArrayList<String>();
			for (String scu : productSCUs) {
				String actualQty = getWebElement(String.format(PRODUCT_QTY_XPATH, scu)).getAttribute("value").trim();
				qtys.add(actualQty);
				shoppingCartDataHelper.setQtyValuesList(qtys);
			}
			logger.info("Saved Qtys: " + Arrays.asList(shoppingCartDataHelper.getQtyValuesList()));
		}
	}

	@Step("Save Shopping cart data")
	public void savePricesTotalPricesAndSubtotal() {
		waitJSExecution();
		saveListOfSCUs();
		List<String> productSCUs = shoppingCartDataHelper.getshoppingCartProductSCUs();
		saveSubtotalValue();
		saveListOfProductsInCart(productSCUs);
		addProductNameTotalPriceMapping(productSCUs);
		addProductPriceMapping(productSCUs);
		saveQtyValue(productSCUs);
		saveShoppingCartID();
	}

	@Step("Click On Cancel button in SAve Cart popup")
	public void clickOnCancelButtonInSaveCartPopup() {
		click(XPATH_CANCEL_SAVE_CART_POPUP);
	}

	@Step("Check if Save button disabled")
	public void isSaveButtonDisabled() {
		waitJSExecution();
		assertFalse(isElementEnabled(XPATH_SAVE_CART_BUTTON_POPUP), "Save Cart button Enabled, butshould be Disabled");
		logger.info("Save Cart button is Disabled");
	}

	@Step("Fill in Cart name")
	public void fillInCartName(String cartName) {
		fillInTextInput(cartName, XPATH_SAVE_CART_NAME_INPUT_POPUP);
	}

	@Step("Fill in Cart Description")
	public void fillInCartDescription(String cartDescription) {
		fillInTextInput(cartDescription, XPATH_SAVE_CART_DESCRIPTION_TEXTAREA_POPUP);
	}

	@Step("Click on save button in Save Cart popup")
	public void clickOnSaveButtonInPopup() {
		click(XPATH_SAVE_CART_BUTTON_POPUP);
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			logger.info("Time Unit method failed");
		}
	}
	
	@Step("Save Shopping Cart name during saving")
	public void saveShoppingCartName(String savedCardName){
		shoppingCartDataHelper.setSavedCardName(savedCardName);
	}

}
