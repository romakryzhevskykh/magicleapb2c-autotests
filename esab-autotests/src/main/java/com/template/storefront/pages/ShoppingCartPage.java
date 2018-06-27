package com.template.storefront.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import com.template.storefront.models.ProductModel;

import ru.yandex.qatools.allure.annotations.Step;
import static com.template.storefront.page_elements.ShoppingCartPageElements.*;

@Component
public class ShoppingCartPage extends StorefrontBasePage {
	final static Logger logger = Logger.getLogger(RegisterPage.class);
	private String pageUrlMethod = "/esab/en/cart";
	private List<String> validationHeaderTitle2 = new ArrayList<>(Arrays.asList("Add new item"));
	private List<String> validationHeader2Subtitle = new ArrayList<>(Arrays
			.asList("Fill out the form below to add products to your order or click here to upload an order instead."));
	private String validationHeaderTitle1 = "Shopping Cart";
	private List<String> validationAddToCartButtonLabel = new ArrayList<>(
			Arrays.asList("Add these products to shopping cart"));
	private List<String> dataForQtyFields = new ArrayList<>(Arrays.asList("11", "22"));
	/*
	 * private List<String> validationShipToAddr = new ArrayList<>(
	 * Arrays.asList("999 South Wacker Drive, Chicago, 60606"));
	 */
	private List<String> validationShipToAddr = new ArrayList<>(
			Arrays.asList("999 South Wacker Drive, Chicago, 60606"));
	private String shipToAddress = "999 South Wacker Drive, Chicago, 60606";

	// private String shipToAddress = "StreetName, StreetNumber, Town,
	// PostalCode";

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
		verifyWebElementsTextValuesEqual(validationHeaderTitle2, H2_SHOPPING_CART_TITLE2);
		logger.info("Header title 2 is CORRECT: " + validationHeaderTitle2);
	}

	@Step("Verify Shopping Cart Header2 subtitle")
	public void verifyH2Header2Subtitle() {
		verifyWebElementsTextValuesEqual(validationHeader2Subtitle, HEADER2_SUBTITLE);
		logger.info("Header2 subtitle is CORRECT: " + validationHeader2Subtitle);
	}

	@Step("Verify Ship-To address value")
	public void verifyShipToValue() {
		verifyWebElementsTextValuesEqual(validationShipToAddr, String.format(SHIP_TO_VALUE, shipToAddress));
		logger.info("Ship to Address is CORRECT: " + validationShipToAddr);
	}

	@Step("Select Ship to Addr Value")
	public void selectShipToAddress() {
		click(String.format(SHIP_TO_VALUE, shipToAddress));
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
		verifyWebElementsTextValuesEqual(validationAddToCartButtonLabel, ADD_TO_CART_BUTTON_XPATH);
		logger.info("Add to Cart button label is CORRECT: " + validationAddToCartButtonLabel);
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
		List<ProductModel> products = productController.getListOfProducts();
		List<String> qtys = new ArrayList<String>();
		List<String> scus = new ArrayList<String>();
		String productQty = null;
		String productScu = null;
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
		List<ProductModel> products = productController.getListOfProducts();
		waitJSExecution();
		if (products != null) {
			for (ProductModel product : products) {
				verifyWebElementTextValue(product.getProductName(),
						String.format(PRODUCT_NAME_XPATH, product.getProductName()));
			}
		}
	}

	@Step("Verify product SCU ")
	public void verifyScuInCart() {
		List<ProductModel> products = productController.getListOfProducts();
		waitJSExecution();
		if (products != null) {
			for (ProductModel product : products) {
				verifyWebElementTextValue(product.getScu(), String.format(PRODUCT_SCU_XPATH, product.getScu()));
			}
		}
	}

	@Step("Verify In Stock value")
	public void verifyInStock() {
		List<ProductModel> products = productController.getListOfProducts();
		waitJSExecution();
		if (products != null) {
			for (ProductModel product : products) {
				verifyWebElementTextValue(product.getInStock(),
						String.format(PRODUCT_INSTOCK_XPATH, product.getInStock()));
			}
		}
	}

	public void getShoppingCartID() {
		String actualHeader1 = getShoppingCartHeaderValue(H2_SHOPPING_CART_TITLE);
		int indexOfDelimeter = actualHeader1.indexOf(':');
		String shoppingCartID = (String) actualHeader1.subSequence(indexOfDelimeter + 1, actualHeader1.length());
		logger.info("Shopping Cart ID is: " + shoppingCartID);
	}

	@Step("Verify price by SCU")
	public void verifyPriceBySCU() {
		List<ProductModel> products = productController.getListOfProducts();
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
		String resultString = null;
		if ((sourceString != null) && (sourceString.length() > 0)) {
			resultString = (String) sourceString.subSequence(1, sourceString.length());
			logger.info("String without dollar char is: " + resultString);
		} else {
			logger.error("Source string equals 0 or null. Source string = " + sourceString);
		}
		return resultString;
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
		List<ProductModel> products = productController.getListOfProducts();
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
	public void clickOnRemoveProduct() {
		List<ProductModel> products = productController.getListOfProducts();
		waitJSExecution();
		if (products != null) {
			for (ProductModel product : products) {
				String productSCU = product.getScu();
				logger.info("Delete product by SCU: " + productSCU);
				click(String.format(PRODUCT_DETAILS_BUTTON_XPATH, productSCU));
				click(String.format(PRODUCT_REMOVE_BUTTON_XPATH, productSCU));
			}
		}
	}

	@Step("Verify subtotal")
	public void verifySubtotal() {
		float expectedSubtotal = 0;
		List<ProductModel> products = productController.getListOfProducts();
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
			assertTrue((actualSubtotalNumber == expectedSubtotal),
					"Actual total price is: " + actualSubtotalNumber + " but expected is: " + expectedSubtotal);
		}
	}

}
