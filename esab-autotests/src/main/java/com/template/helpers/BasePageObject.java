package com.template.helpers;

import com.template.helpers.web_engine.WebDriverSessions;

import javafx.collections.transformation.SortedList;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import static com.template.storefront.page_elements.RegisterPageElements.REGISTRATION_PAGE_LABELS_XPATH;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class BasePageObject {

	@Autowired
	protected WebDriverSessions webDriverPool;
	@Autowired
	protected ThreadVarsHashMap threadVarsHashMap;
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
		logger.info("Add web elemnts values to the list");
		for (WebElement webElement : webElements) {
			String webElementValue = webElement.getText().trim();
			logger.info("Add value to the list: " + webElementValue);
			webElementsValues.add(webElementValue);
		}
		if (webElementsValues.size() > 0) {
			logger.info("Sort list of String values. Return list of values.");
			Collections.sort(webElementsValues);
			return webElementsValues;
		}
		logger.error("List of values is empty. Return NULL.");
		return null;
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
			logger.info("Dashboard welcome text: " + $(xpath).getText());
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

	protected void fillInTextInput(String textForInput, String xpath, String... args) {
		WebElement webElement = getWebElement(xpath, args);
		if (webElement != null) {
			logger.info("Send text: " + textForInput + "into web element" + webElement);
			webElement.sendKeys(textForInput);
		}
	}
}
