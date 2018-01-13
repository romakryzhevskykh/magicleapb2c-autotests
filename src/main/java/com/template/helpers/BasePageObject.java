package com.template.helpers;

import com.template.helpers.web_engine.WebDriverSessions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class BasePageObject {

    @Autowired protected WebDriverSessions webDriverPool;
    @Autowired protected ThreadVarsHashMap threadVarsHashMap;

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

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    protected boolean isDisplayed(String xpath, String... args) {
        webDriverPool.getActiveDriverSession().setShortImplicitWait();
        try {
            return getDriver().findElement(By.xpath(String.format(xpath, args))).isDisplayed();
        } catch (NoSuchElementException | NullPointerException ex) {
            return false;
        } finally {
            webDriverPool.getActiveDriverSession().restoreDefaultImplicitWait();
        }
    }
}
