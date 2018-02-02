package com.sarnova.helpers;

import com.sarnova.helpers.web_engine.WebDriverSessions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class UIComponent {

    @Autowired protected WebDriverSessions webDriverPool;

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
            WebDriverWait wait = new WebDriverWait(getDriver(), webDriverPool.getActiveDriverSession().getShortTimeOut());
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
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
            WebDriverWait wait = new WebDriverWait(getDriver(), webDriverPool.getActiveDriverSession().getShortTimeOut());
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
        } catch (WebDriverException ex) {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement);
            webElement.click();
        } finally {
            webDriverPool.getActiveDriverSession().restoreDefaultImplicitWait();
        }
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
}
