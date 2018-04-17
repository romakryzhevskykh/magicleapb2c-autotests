package com.template.helpers;

import com.template.helpers.web_engine.WebDriverSessions;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

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
			logger.info("Click on web element");
			webElement.click();
		} catch (WebDriverException ex) {
			logger.info("Click on web element with javaScript");
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
			logger.info("Click on web element");
			webElement.click();
		} catch (WebDriverException ex) {
			logger.info("Click on web element with javaScript");
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
}
