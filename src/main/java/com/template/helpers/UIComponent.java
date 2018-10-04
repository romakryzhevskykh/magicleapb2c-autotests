package com.template.helpers;

import com.template.helpers.web_engine.WebDriverSessions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public abstract class UIComponent {

    @Autowired protected WebDriverSessions webDriverPool;

    protected WebDriver getDriver() {
        return webDriverPool.getActiveDriver();
    }

    @Step("Accept alert.")
    protected void alertHandling() {
        getDriver().switchTo().alert().accept();
    }

    protected WebElement $(String xpath, String... args) {
        try {
            return getDriver().findElement(By.xpath(String.format(xpath, args)));
        } catch (UnhandledAlertException ex) {
            System.out.println("WARNING: Unexpected alert: " + ex);
            alertHandling();
            return $(xpath, args);
        } catch (NoSuchElementException ex) {
            return null;
        }
    }

    protected WebElement $(By by) {
        try {
            return getDriver().findElement(by);
        } catch (UnhandledAlertException ex) {
            System.out.println("WARNING: Unexpected alert!");
            alertHandling();
            return $(by);
        } catch (NoSuchElementException ex) {
            return null;
        }
    }

    protected List<WebElement> $$(String xpath, String... args) {
        return getDriver().findElements(By.xpath(String.format(xpath, args)));
    }

    protected List<WebElement> getElementsInFrame(String frameName, String xpath, String... args) {
        getDriver().switchTo().frame(frameName);
        List<WebElement> webElements = $$(xpath, args);
        getDriver().switchTo().defaultContent();
        return webElements;
    }

    protected List<WebElement> $$(By by) {
        return getDriver().findElements(by);
    }

    protected void clickInFrame(String frameName, String xpath, String... args) {
        getDriver().switchTo().frame(frameName);
        click(xpath, args);
        getDriver().switchTo().defaultContent();
    }

    protected void clickInFrame(String frameName, By by) {
        getDriver().switchTo().frame(frameName);
        click(by);
        getDriver().switchTo().defaultContent();
    }

    protected boolean isSelectedInFrame(String frameName, String xpath, String... args) {
        getDriver().switchTo().frame(frameName);
        boolean result = $(xpath, args).isSelected();
        getDriver().switchTo().defaultContent();
        return result;
    }

    protected void click(String xpath, String... args) {
        WebElement webElement = $(xpath, args);
        webDriverPool.getActiveDriverSession().setShortImplicitWait();
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), webDriverPool.getActiveDriverSession().getShortTimeOut());
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            try {
                webElement.click();
            } catch (UnhandledAlertException ex) {
                System.out.println("WARNING: Unexpected alert!");
                alertHandling();
                webElement.click();
            }
        } catch (WebDriverException | NullPointerException ex) {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement);
            try {
                webElement.click();
            } catch (UnhandledAlertException exception) {
                System.out.println("WARNING: Unexpected alert!");
                alertHandling();
                webElement.click();
            }
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
            try {
                webElement.click();
            } catch (UnhandledAlertException exception) {
                System.out.println("WARNING: Unexpected alert!");
                alertHandling();
                webElement.click();
            }
        } catch (WebDriverException ex) {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement);
            try {
                webElement.click();
            } catch (UnhandledAlertException exception) {
                System.out.println("WARNING: Unexpected alert!");
                alertHandling();
                webElement.click();
            }
        } finally {
            webDriverPool.getActiveDriverSession().restoreDefaultImplicitWait();
        }
    }

    protected void enterText(String text, By by) {
        waitUntilElementIsVisible(by);
        $(by).clear();
        $(by).sendKeys(text);
        blurElement($(by));
    }

    protected void enterText(String text, String xpath, String... args) {
        waitUntilElementIsVisible(xpath, args);
        $(xpath, args).clear();
        $(xpath, args).sendKeys(text);
        blurElement($(xpath, args));
    }

    protected void blurElement(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].focus(); arguments[0].blur(); return true", webElement);
    }

    protected boolean isDisplayedInFrame(String frameName, String xpath, String... args) {
        webDriverPool.getActiveDriverSession().setShortImplicitWait();
        try {
            getDriver().switchTo().frame(frameName);
        } catch (NoSuchFrameException ex) {
            System.out.println(ex);
            return false;
        } finally {
            webDriverPool.getActiveDriverSession().restoreDefaultImplicitWait();
        }
        boolean result = isDisplayed(xpath, args);
        getDriver().switchTo().defaultContent();
        return result;
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

    protected boolean isPresent(String xpath, String... args) {
        webDriverPool.getActiveDriverSession().setShortImplicitWait();
        try {
            getDriver().findElement(By.xpath(String.format(xpath, args)));
            return true;
        } catch (UnhandledAlertException ex) {
            System.out.println("WARNING: Unexpected alert: " + ex);
            alertHandling();
            return isPresent(xpath, args);
        } catch (NoSuchElementException ex) {
            return false;
        } finally {
            webDriverPool.getActiveDriverSession().restoreDefaultImplicitWait();
        }
    }

    protected boolean isPresent(By by) {
        webDriverPool.getActiveDriverSession().setShortImplicitWait();
        try {
            getDriver().findElement(by);
            return true;
        } catch (UnhandledAlertException ex) {
            System.out.println("WARNING: Unexpected alert: " + ex);
            alertHandling();
            return isPresent(by);
        } catch (NoSuchElementException ex) {
            return false;
        } finally {
            webDriverPool.getActiveDriverSession().restoreDefaultImplicitWait();
        }
    }

    @Step("Wait until page is fully loaded.")
    protected void waitUntilPageIsFullyLoaded() {
        waitHTMLTemplateLoad();
        waitJQueryRequestsLoad();
    }

    public void waitElementAttributeIsNotEmpty(String xpath, String attributeName) {
        waitUntil(driver1 -> (!$(xpath).getAttribute(attributeName).isEmpty()));
    }

    @Step("Wait until HTML template is fully loaded.")
    public void waitHTMLTemplateLoad() {
        waitUntil(driver1 -> ((JavascriptExecutor) driver1).executeScript("return document.readyState").toString().equals("complete"));
    }

    @Step("Wait until element is visible {0}.")
    public void waitUntilElementIsVisible(String xpath, String... args) {
        waitUntil(driver1 -> isDisplayed(xpath, args));
    }

    @Step("Wait until element is visible {0}.")
    public void waitUntilElementIsVisible(By by) {
        waitUntil(driver1 -> isDisplayed(by));
    }

    public void waitUntil(ExpectedCondition<Boolean> expectedCondition) {
        WebDriverWait wait = new WebDriverWait(getDriver(), webDriverPool.getActiveDriverSession().getTimeOut());
        try {
            wait.until(expectedCondition);
        } catch (UnhandledAlertException ex) {
            System.out.println("[ERROR]: " + ex);
        }
        try {
            Thread.sleep((long) (1000 * webDriverPool.getActiveDriverSession().getShortTimeOut() / 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForAngularLoad() {
        WebDriverWait wait = new WebDriverWait(getDriver(), webDriverPool.getActiveDriverSession().getTimeOut());
        try {
            Thread.sleep((long) (1000 * webDriverPool.getActiveDriverSession().getShortTimeOut() / 20));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ExpectedCondition<Boolean> angularLoadCondition = driver1 -> {
            boolean result;
            JavascriptExecutor js = (JavascriptExecutor) driver1;
            try {
                result = (Boolean) js.executeScript("return angular.element(document).injector().get('$http').pendingRequests.length === 0");
            } catch (WebDriverException ex) {
                result = true;
                System.out.println("[INFO] No Angular.");
            }
            return result;
        };
        try {
            wait.until(angularLoadCondition);
        } catch (TimeoutException ex) {
            System.out.println("[WARNING] Timeout exception after " + webDriverPool.getActiveDriverSession().getTimeOut() + " Seconds. Possible problem - browser hovered(not responding)!");
        }
        try {
            Thread.sleep((long) (1000 * webDriverPool.getActiveDriverSession().getShortTimeOut() / 20));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step("Wait until JQuery is fully loaded.")
    public void waitJQueryRequestsLoad() {
        WebDriverWait wait = new WebDriverWait(getDriver(), webDriverPool.getActiveDriverSession().getTimeOut());
        try {
            Thread.sleep((long) (1000 * webDriverPool.getActiveDriverSession().getShortTimeOut() / 10));
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
            Thread.sleep((long) (1000 * webDriverPool.getActiveDriverSession().getShortTimeOut() / 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}