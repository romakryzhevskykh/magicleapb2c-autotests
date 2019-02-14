package com.template.helpers.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class UIComponent extends BaseComponentImpl{

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

    public void waitHTMLTemplateLoad() {
        waitUntil(driver1 -> ((JavascriptExecutor) driver1).executeScript("return document.readyState").toString().equals("complete"));
    }

    public void waitUntilPageIsFullyLoaded() {
        waitHTMLTemplateLoad();
        waitJQueryRequestsLoad();
    }
}