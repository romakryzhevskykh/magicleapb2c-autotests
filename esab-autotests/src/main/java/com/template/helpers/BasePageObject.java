package com.template.helpers;

import com.template.helpers.web_engine.WebDriverSessions;
import com.template.storefront.models.CheckoutModelBuilder;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BasePageObject {

	@Autowired
	protected WebDriverSessions webDriverPool;
	@Autowired
	protected ThreadVarsHashMap threadVarsHashMap;
	@Autowired
	protected ProductController productController;
	@Autowired
	protected CheckoutDataController checkoutDataController;

	final static Logger logger = Logger.getLogger(BasePageObject.class);
	private WebDriverWait wait;
	private long shortTimeout;

	protected WebDriverWait initWebDriverWait() {
		if (wait == null) {
			logger.info("WebDriver wait, object is not created yet. Create object");
			wait = new WebDriverWait(getDriver(), initTimeoutShort());
			logger.info("WebDriver wait, object has been created");
		} else {
			logger.info("WebDriver wait, object has already created. Return object");
		}
		return wait;
	}

	protected void setImplicitWaitShort() {
		webDriverPool.getActiveDriverSession().setShortImplicitWait();
	}

	protected void setDefaultImplicitWait() {
		webDriverPool.getActiveDriverSession().restoreDefaultImplicitWait();
	}

	protected long initTimeoutShort() {
		if (shortTimeout == 0) {
			logger.info("shortTimeout is not initiated. Inititate shortTimeout");
			shortTimeout = webDriverPool.getActiveDriverSession().getShortTimeOut();
			logger.info("shortTimeout is not initiated. shortTimeout inititated");
		}
		return shortTimeout;
	}

	protected WebDriver getDriver() {
		return webDriverPool.getActiveDriver();
	}

	public WebElement getWebElement(String xpath, String... args) {
		logger.info("Locate element if it's present");
		setImplicitWaitShort();
		WebElement element = initWebDriverWait()
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(xpath, args))));
		if (element != null) {
			logger.info("Waiting untill Web element" + element + " is Clicable (Displayed and Enabled)");
			initWebDriverWait().until(ExpectedConditions.elementToBeClickable(element));
			logger.info("Web element " + element + " is present and Clicable (Displayed and Enabled)");
			setDefaultImplicitWait();
			return element;
		} else {
			logger.info("Web element" + element + " is not fount");
		}
		setDefaultImplicitWait();
		return null;
	}

	public void waitJSExecution() {
		setImplicitWaitShort();
		ExpectedCondition<Boolean> jQueryLoaded = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {

					boolean isJQueryLoaded = ((Long) ((JavascriptExecutor) getDriver())
							.executeScript("return jQuery.active")) == 0;
					logger.info("isJQueryLoaded value: " + isJQueryLoaded);
					return isJQueryLoaded;
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {

				Boolean isJsLoaded = ((JavascriptExecutor) getDriver()).executeScript("return document.readyState")
						.toString().equals("complete");
				logger.info("isJsLoaded value: " + isJsLoaded);
				return isJsLoaded;
			}
		};
		logger.info("wait JSExecution method has triggered");
		initWebDriverWait().until(jQueryLoaded);
		initWebDriverWait().until(jsLoad);
		setDefaultImplicitWait();
	}

	public WebElement getWebElement(By by) {
		logger.info("Locate element if it's present");
		setImplicitWaitShort();
		WebElement element = initWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(by));
		if (element != null) {
			logger.info("Waiting untill Web element is Clicable (Displayed and Enabled)");
			initWebDriverWait().until(ExpectedConditions.elementToBeClickable(element));
			logger.info("Web element is present and Clicable (Displayed and Enabled)");
			setDefaultImplicitWait();
			return element;
		} else {
			logger.info("Web element is not fount");
		}
		setDefaultImplicitWait();
		return null;
	}

	public List<WebElement> getWebElements(String xpath, String... args) {
		logger.info("Locate Web elements if such present");
		setImplicitWaitShort();
		List<WebElement> elements = new ArrayList<WebElement>();
		elements = initWebDriverWait()
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(String.format(xpath, args))));
		if (elements.size() > 0) {
			for (WebElement loopElement : elements) {
				logger.info("Verify WebElement is Displayed and Enabled");
				if (loopElement.isDisplayed() && loopElement.isEnabled()) {
					logger.info(loopElement);
					logger.info("WebElement is Displayed and Enabled");
				} else {
					logger.error("Web element is not Displayed or Enabled");
					setDefaultImplicitWait();
					return null;
				}
			}
			setDefaultImplicitWait();
			return elements;
		}
		setDefaultImplicitWait();
		return null;
	}

	public List<String> getWebElementsTextValues(String xpath, String... args) {
		List<WebElement> webElements = getWebElements(xpath, args);
		List<String> webElementsValues = new ArrayList<String>();
		if (webElements != null) {
			for (WebElement webElement : webElements) {
				String webElementValue = webElement.getText().trim();
				logger.info("Add value to the list: " + webElementValue);
				webElementsValues.add(webElementValue);
			}
		}
		if (webElementsValues.size() > 0) {
			logger.info("Sort list of String values. Return list of values.");
			Collections.sort(webElementsValues);
			return webElementsValues;
		}
		logger.error("List of values is empty. Return NULL.");
		return null;
	}

	protected String toText(WebElement webElement) {
		String webElementValue = webElement.getText().trim();
		logger.info("Add value to the list: " + webElementValue);
		return webElementValue;
	}

	protected void open(String url) {
		getDriver().get(url);
	}

	protected WebElement $(String xpath, String... args) {
		try {
			return getDriver().findElement(By.xpath(String.format(xpath, args)));
		} catch (NoSuchElementException ex) {
			return null;
		}
	}

	protected WebElement $(By by) {
		try {
			return getDriver().findElement(by);
		} catch (NoSuchElementException ex) {
			return null;
		}
	}

	protected List<WebElement> $$(String xpath, String... args) {
		return getDriver().findElements(By.xpath(String.format(xpath, args)));
	}

	protected List<WebElement> $$(By by) {
		return getDriver().findElements(by);
	}

	protected void click(String xpath, String... args) {
		WebElement webElement = getWebElement(xpath, args);
		setImplicitWaitShort();
		waitJSExecution();
		try {
			logger.info("Click on web element" + webElement);
			webElement.click();
		} catch (WebDriverException ex) {
			logger.info("Click on web element with javaScript" + webElement);
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement);
			webElement.click();
		} finally {
			setDefaultImplicitWait();
		}
	}

	protected void clear(String xpath) {
		WebElement webElement = getWebElement(xpath);
		setImplicitWaitShort();
		webElement.clear();
		setDefaultImplicitWait();
	}

	protected void click(By by) {
		WebElement webElement = $(by);
		setImplicitWaitShort();
		try {
			logger.info("Click on web element" + webElement);
			webElement.click();
		} catch (WebDriverException ex) {
			logger.info("Click on web element with javaScript" + webElement);
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement);
			webElement.click();
		} finally {
			setDefaultImplicitWait();
		}
	}

	public String getCurrentUrl() {
		return getDriver().getCurrentUrl();
	}

	protected boolean isDisplayed(String xpath, String... args) {
		setImplicitWaitShort();
		try {
			return $(xpath, args).isDisplayed();
		} catch (NoSuchElementException | NullPointerException ex) {
			return false;
		} finally {
			setDefaultImplicitWait();
		}
	}

	protected boolean isDisplayed(By by) {
		setImplicitWaitShort();
		try {
			return $(by).isDisplayed();
		} catch (NoSuchElementException | NullPointerException ex) {
			return false;
		} finally {
			setDefaultImplicitWait();
		}
	}

	protected boolean isStringContainsText(String xpath, String text) {
		setImplicitWaitShort();
		boolean IsTextPresent = false;
		if ($(xpath) != null) {
			logger.info("Web element text value is: " + $(xpath).getText());
			IsTextPresent = $(xpath).getText().contains(text);
		} else {
			logger.error("There is no desired webelement");
		}
		setDefaultImplicitWait();
		return IsTextPresent;
	}

	protected void verifyWebElementsTextValuesEqual(List<String> verificationListOfTexts, String xpath,
			String... args) {
		List<String> webElementsValues = getWebElementsTextValues(xpath, args);
		if (webElementsValues != null) {
			Collections.sort(verificationListOfTexts);
			assertEquals(webElementsValues, verificationListOfTexts, "Incorrect texts on page");
			logger.info("All texts are present and correct");
		} else {
			logger.error("List of texts is null");
		}
	}

	protected void verifyWebElementTextValue(String validationText, String xpath) {
		String webElementText = getWebElement(xpath).getText().trim();
		logger.info("Web element actual value: " + webElementText);
		logger.info("Web element expected value: " + validationText);
		if (webElementText != null) {
			assertEquals(webElementText, validationText,
					"Actual text value is: " + webElementText + " but expected value is: " + validationText);
			logger.info("Element label is CORRECT: " + webElementText);
		}
	}

	protected void fillInTextInput(String textForInput, String xpath, String... args) {
		WebElement webElement = getWebElement(xpath, args);
		if (webElement != null) {
			logger.info("Send text: " + textForInput + " into web element" + webElement);
			webElement.sendKeys(textForInput);
		}
	}

	protected void isCurrentUrlExpectedURL(String validationURL) {
		waitJSExecution();
		String actualUrl = getCurrentUrl();
		String expectedUrl = validationURL;
		assertEquals(actualUrl, expectedUrl,
				"Actual URL: " + actualUrl + " is not equals to expected URL: " + expectedUrl);
		logger.info("Page URL is CORRECT: " + actualUrl);
	}

	protected void fillInSeveralFields(List<String> textsForInput, String xpath) {
		List<WebElement> fields = getWebElements(xpath);
		int i = 0;
		if ((fields != null) && (textsForInput != null) && (fields.size() == textsForInput.size())) {
			for (WebElement field : fields) {
				String fieldValue = textsForInput.get(i);
				logger.info("Value to be entered: " + fieldValue);
				field.sendKeys(fieldValue);
				i++;
			}
		} else {
			logger.info("Field web elements or validation values is null"
					+ " or fields number is different to validation values number  ");
		}
	}

	protected float castStringToFloat(String sourceString) {
		logger.info("Invoke cast String to Float method");
		float resultFloatValue = 0;
		if ((sourceString != null) && (sourceString.length() > 0)) {
			resultFloatValue = Float.valueOf(sourceString);
			logger.info("Float value of source string is: " + resultFloatValue);
		} else {
			logger.error("Source string equals 0 or null. Source string = " + sourceString);
		}
		return resultFloatValue;
	}

	protected boolean isElementEnabled(String xpath) {
		boolean isEnabled = false;
		isEnabled = getDriver().findElement(By.xpath(xpath)).isEnabled();
		logger.info("Is Element enabled is: " + isEnabled);
		return isEnabled;
	}

}
