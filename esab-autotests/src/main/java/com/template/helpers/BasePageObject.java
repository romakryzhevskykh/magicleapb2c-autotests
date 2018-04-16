package com.template.helpers;

import com.template.helpers.web_engine.WebDriverSessions;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class BasePageObject {

    @Autowired protected WebDriverSessions webDriverPool;
    @Autowired protected ThreadVarsHashMap threadVarsHashMap;
    final static Logger logger = Logger.getLogger(BasePageObject.class);
    private WebDriverWait wait;
    
    protected WebDriverWait initWebDriverWait(){
    	if(wait==null){
    		logger.info("WebDriver wait, object is not created yet. Create object");
    		wait = new WebDriverWait(getDriver(), webDriverPool.getActiveDriverSession().getShortTimeOut());
    		logger.info("WebDriver wait, object has been created");
    	}else{
    		logger.info("WebDriver wait, object has already created. Return object");
    	}
    	return wait;
    }

    protected WebDriver getDriver() {
        return webDriverPool.getActiveDriver();
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
        WebElement webElement = $(xpath, args);
        webDriverPool.getActiveDriverSession().setShortImplicitWait();
        try {
            initWebDriverWait().until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
        } catch (WebDriverException ex) {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement);
            webElement.click();
        } finally {
            webDriverPool.getActiveDriverSession().restoreDefaultImplicitWait();
        }
    }

    protected void click(By by) {
        WebElement webElement = $(by);
        webDriverPool.getActiveDriverSession().setShortImplicitWait();
        try {
            initWebDriverWait().until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
        } catch (WebDriverException ex) {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement);
            webElement.click();
        } finally {
            webDriverPool.getActiveDriverSession().restoreDefaultImplicitWait();
        }
    }

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    protected boolean isDisplayed(String xpath, String... args) {
        webDriverPool.getActiveDriverSession().setShortImplicitWait();
        try {
            return $(xpath, args).isDisplayed();
        } catch (NoSuchElementException | NullPointerException ex) {
            return false;
        } finally {
            webDriverPool.getActiveDriverSession().restoreDefaultImplicitWait();
        }
    }

    protected boolean isDisplayed(By by) {
        webDriverPool.getActiveDriverSession().setShortImplicitWait();
        try {
            return $(by).isDisplayed();
        } catch (NoSuchElementException | NullPointerException ex) {
            return false;
        } finally {
            webDriverPool.getActiveDriverSession().restoreDefaultImplicitWait();
        }
    }
    
    protected boolean isStringContainsText(String xpath, String text){
    	webDriverPool.getActiveDriverSession().setShortImplicitWait();
    	boolean IsTextPresent = false; 
    	if($(xpath)!= null){
    		logger.info("Dashboard welcome text: " + $(xpath).getText());
        	IsTextPresent = $(xpath).getText().contains(text);	
    	}else{
    		logger.error("There is no desired webelement");
    	}
    	webDriverPool.getActiveDriverSession().restoreDefaultImplicitWait();
    	return IsTextPresent;
    }
}
