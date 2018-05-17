package com.topcon.helpers;

import com.topcon.helpers.web_engine.WebDriverSessions;
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

    protected void alertHandling() {
        getDriver().switchTo().alert().accept();
    }

    @Step("Open url: {0}.")
    protected void open(String url) {
        try {
            getDriver().get(url);
        } catch (UnhandledAlertException ex) {
            System.out.println("WARNING: Unexpected alert!");
            alertHandling();
            getDriver().get(url);
        }
    }

    protected WebElement $(String xpath, String... args) {
        try {
            return getDriver().findElement(By.xpath(String.format(xpath, args)));
        } catch (UnhandledAlertException ex) {
            System.out.println("WARNING: Unexpected alert!");
            alertHandling();
            return getDriver().findElement(By.xpath(String.format(xpath, args)));
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

    protected void blurElement(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].focus(); arguments[0].blur(); return true", webElement);
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

    public void waitUntilVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), webDriverPool.getActiveDriverSession().getTimeOut());
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
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

    protected void waitUntilPageIsFullyLoaded() {
        waitHTMLTemplateLoad();
        waitJQueryRequestsLoad();
    }

    public void waitElementAttributeIsNotEmpty(String xpath, String attributeName) {
        waitUntil(driver1 -> (!$(xpath).getAttribute(attributeName).isEmpty()));
    }

    public void waitHTMLTemplateLoad() {
        waitUntil(driver1 -> ((JavascriptExecutor) driver1).executeScript("return document.readyState").toString().equals("complete"));
    }

    public void waitUntil(ExpectedCondition<Boolean> expectedCondition) {
        WebDriverWait wait = new WebDriverWait(getDriver(), webDriverPool.getActiveDriverSession().getTimeOut());
        wait.until(expectedCondition);
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
}