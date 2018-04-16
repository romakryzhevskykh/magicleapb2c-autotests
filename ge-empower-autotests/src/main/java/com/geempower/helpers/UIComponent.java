package com.geempower.helpers;

import com.geempower.helpers.web_engine.WebDriverSessions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class UIComponent {

    @Autowired
    protected WebDriverSessions webDriverPool;

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
        click(webElement);
    }

    protected void moveToElement(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(getDriver(), webDriverPool.getActiveDriverSession().getShortTimeOut());
        Actions actions = new Actions(getDriver());
        actions.moveToElement(webElement);
        actions.perform();
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected void click(By by) {
        WebElement webElement = $(by);
        click(webElement);
    }

    protected void click(WebElement webElement) {
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

    public void waitUntilPageIsFullyLoaded() {
        waitHTMLTemplateLoad();
        waitJQueryRequestsLoad();
    }

    public void waitHTMLTemplateLoad() {
        WebDriverWait wait = new WebDriverWait(getDriver(), webDriverPool.getActiveDriverSession().getTimeOut());
        ExpectedCondition<Boolean> pageLoadCondition = driver1
                -> ((JavascriptExecutor) driver1).executeScript("return document.readyState").equals("complete");
        wait.until(pageLoadCondition);
    }

    public void waitJQueryRequestsLoad() {
        WebDriverWait wait = new WebDriverWait(getDriver(), webDriverPool.getActiveDriverSession().getTimeOut());
        try {
            Thread.sleep((long) (1000 * webDriverPool.getActiveDriverSession().getShortTimeOut() / 20));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ExpectedCondition<Boolean> jQueryLoadCondition = driver1 -> {
            boolean result;
            JavascriptExecutor js = (JavascriptExecutor) driver1;
            try {
                result = (Boolean) js.executeScript("return jQuery.active == 0");
            } catch (WebDriverException ex) {
                result = true;
                System.out.println("[INFO] No jQueries.");
            }
            return result;
        };
        try {
            wait.until(jQueryLoadCondition);
        } catch (TimeoutException ex) {
            System.out.println("[WARNING] Timeout exception after " + webDriverPool.getActiveDriverSession().getTimeOut() + " Seconds. Possible problem - browser hovered(not responding)!");
        }
        try {
            Thread.sleep((long) (1000 * webDriverPool.getActiveDriverSession().getShortTimeOut() / 20));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForElementToDisappear(By by) {
        WebElement webElement = $(by);
        webDriverPool.getActiveDriverSession().setShortImplicitWait();
        WebDriverWait wait = new WebDriverWait(getDriver(), webDriverPool.getActiveDriverSession().getShortTimeOut());
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    public void waitForElementWithAppropriateTextToAppear(By by, String text) {
        webDriverPool.getActiveDriverSession().setImplicitWait();
        WebDriverWait wait = new WebDriverWait(getDriver(), webDriverPool.getActiveDriverSession().getTimeOut());
        wait.until(ExpectedConditions.textToBe(by, text));

    }
}
