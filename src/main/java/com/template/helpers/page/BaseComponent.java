package com.template.helpers.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;
import java.util.concurrent.TimeUnit;

public interface BaseComponent {

    /**
     * Returns driver for further using in the methods
     * @return {@link WebDriver}
     */
    WebDriver getDriver();

    /**
     * Used for changing webdriver wait in build pattern style.
     * @param timeout
     * @param timeUnit
     * @param <T>
     * @return called class that extends base class
     */
    <T extends BaseComponent> T withTimeOutOf(int timeout, TimeUnit timeUnit);

    /**
     * Switch to frame in build pattern style
     * @param frameName
     * @param <T>
     * @return
     */
    <T extends BaseComponent> T withFrame(String frameName);

    <T extends BaseComponent> T waitUntil(ExpectedCondition<?> expectedCondition);

    WebElement $(String xPath, String... args);
    WebElement $(By by);

    List<BaseComponentImpl.Element> $$(String xPath, String... args);
    List<BaseComponentImpl.Element> $$(By by);

    boolean isPresent(String xpath, String... args);
    boolean isPresent(By by);
    boolean isPresent(WebElement parentElement, By by);
    boolean isDisplayed(WebElement element);
}
