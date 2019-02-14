package com.template.helpers.page;

import com.template.helpers.web_engine.WebDriverSessions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.FileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public abstract class BaseComponentImpl implements BaseComponent {
    @Autowired
    protected WebDriverSessions webDriverPool;
    //TODO move default configs from active sessions to constant class
    private int defaultImplWait = 60; //driverSessions.getActiveDriverSession().getTimeOut();
    private TimeUnit defaultTimeUnit = TimeUnit.SECONDS; //driverSessions.getActiveDriverSession().getTimeUnit();
    private boolean isFrame = false;

    @Override
    public WebDriver getDriver() {
        return webDriverPool.getActiveDriverSession().getWebDriver();
    }

    private void setCustomImplWait() {
        webDriverPool.getActiveDriverSession().changeImplicitWait(this.defaultImplWait, this.defaultTimeUnit);
    }

    private void restoreDefaults() {
        webDriverPool.getActiveDriverSession().restoreDefaultImplicitWait();
        if (this.isFrame) {
            getDriver().switchTo().defaultContent();
        }
    }

    @Override
    public <T extends BaseComponent> T withTimeOutOf(int timeout, TimeUnit timeUnit) {
        this.defaultImplWait = timeout;
        this.defaultTimeUnit = timeUnit;
        return (T) this;
    }

    @Override
    public <T extends BaseComponent> T withFrame(String frameName) {
        getDriver().switchTo().frame(frameName);
        this.isFrame = true;
        return (T) this;
    }

    @Override
    public <T extends BaseComponent> T waitUntil(ExpectedCondition<?> expectedCondition) {
        setCustomImplWait();
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
        restoreDefaults();
        return (T) this;
    }

    @Override
    public Element $(String xPath, String... args) {
        setCustomImplWait();
        try {
            return new Element(getDriver().findElement(By.xpath(String.format(xPath, args))));
        } catch (UnhandledAlertException ex) {
            System.out.println("WARNING: Unexpected alert: " + ex);
            alertHandling();
            return $(xPath, args);
        } catch (NoSuchElementException ex) {
            return null;
        } finally {
            restoreDefaults();
        }
    }

    @Override
    public Element $(By by) {
        setCustomImplWait();
        try {
            return new Element(getDriver().findElement(by));
        } catch (UnhandledAlertException ex) {
            System.out.println("WARNING: Unexpected alert!");
            alertHandling();
            return $(by);
        } catch (NoSuchElementException ex) {
            return null;
        } finally {
            restoreDefaults();
        }
    }

    @Override
    public List<Element> $$(String xPath, String... args) {
        setCustomImplWait();
        try {
            return getDriver().findElements(By.xpath(String.format(xPath, args)))
                    .stream().map(Element::new).collect(Collectors.toList());
        } finally {
            restoreDefaults();
        }
    }

    @Override
    public List<Element> $$(By by) {
        setCustomImplWait();
        try {
            return getDriver().findElements(by)
                    .stream().map(Element::new).collect(Collectors.toList());
        } finally {
            restoreDefaults();
        }
    }

    private void click(WebElement webElement) {
        setCustomImplWait();
        try {
            waitUntil(ExpectedConditions.elementToBeClickable(webElement));
            try {
                webElement.click();
            } catch (UnhandledAlertException ex) {
                System.out.println("WARNING: Unexpected alert!");
                alertHandling();
                webElement.click();
            }
        } catch (WebDriverException | NullPointerException ex) {
            System.out.println("[INFO]: " + ex);
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement);
            try {
                webElement.click();
            } catch (UnhandledAlertException exception) {
                System.out.println("WARNING: Unexpected alert!");
                alertHandling();
                webElement.click();
            }
        } finally {
            restoreDefaults();
        }
    }

    private void enterText(String text, WebElement element) {
        waitUntilElementIsVisible(element);
        element.clear();
        element.sendKeys(text);
        blurElement(element);
    }

    private void enterTextWithActions(String text, WebElement element) {
        waitUntilElementIsVisible(element);
        Actions navigator = new Actions(getDriver());
        navigator.click(element)
                .sendKeys(Keys.END)
                .keyDown(Keys.SHIFT)
                .sendKeys(Keys.HOME)
                .keyUp(Keys.SHIFT)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(text)
                .perform();
        blurElement(element);
    }

    private void blurElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].focus(); arguments[0].blur(); return true", element);
    }

    @Override
    public boolean isDisplayed(WebElement element) {
        setCustomImplWait();
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException | NullPointerException ex) {
            return false;
        } catch (StaleElementReferenceException ex) {
            return isDisplayed(element);
        } finally {
            restoreDefaults();
        }
    }

    @Override
    public boolean isPresent(String xpath, String... args) {
        setCustomImplWait();
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
            restoreDefaults();
        }
    }

    @Override
    public boolean isPresent(By by) {
        setCustomImplWait();
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
            restoreDefaults();
        }
    }

    @Override
    public boolean isPresent(WebElement parentElement, By by) {
        setCustomImplWait();
        try {
            parentElement.findElement(by);
            return true;
        } catch (UnhandledAlertException ex) {
            System.out.println("WARNING: Unexpected alert: " + ex);
            alertHandling();
            return isPresent(parentElement, by);
        } catch (NoSuchElementException ex) {
            return false;
        } finally {
            restoreDefaults();
        }
    }

    /**
     * As xpath and webDriver don't allow to get the .text() attribute of web element
     * we have to use this method to get it.
     * Important thing, that this method is real slow, and you should avoid using it
     * when you have normal element which contains text without children.
     * <p>
     * e.g.
     *
     * <div class="alert alert-warning alert-dismissable">
     * <button class="close" aria-hidden="true" data-dismiss="alert" type="button">×</button>
     * Correct errors below to continue.</div>
     * <p>
     * as you can see <div> contains button with text 'x'
     * if you get text of the div in standard way webElement.getText();
     * you will receive the next "x Correct errors below to continue."
     * so, when you have to get only text in div without button text, use the method, otherwise use getText()
     *
     * @param webElement WebElement the parent element which contains text and children with text
     * @return (String) .text of the input web element
     */
    private String getTextNode(WebElement webElement) {
        String text = webElement.getText().trim();
        List<WebElement> children = webElement.findElements(By.xpath("./*"));
        for (WebElement child : children) {
            text = text.replaceFirst(child.getText(), "").trim();
        }
        return text;
    }

    private String getAttribute(String attribute, WebElement element) {
        return element.getAttribute(attribute);
    }

    private String getAttributeValue(WebElement element) {
        return element.getAttribute("value");
    }

    private boolean isEditable(WebElement element) {
        return !((element.getAttribute("disabled") != null) || (element.getAttribute("readonly") != null) || !element.isEnabled());
    }

    private boolean isClickable(WebElement element) {
        setCustomImplWait();
        WebDriverWait wait = new WebDriverWait(getDriver(), webDriverPool.getActiveDriverSession().getShortTimeOut());
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (WebDriverException ex) {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
            try {
                wait.until(ExpectedConditions.elementToBeClickable(element));
                return true;
            } catch (WebDriverException exception) {
                return false;
            }
        } finally {
            restoreDefaults();
        }
    }

    public void alertHandling() {
        getDriver().switchTo().alert().accept();
    }

    public class Element extends RemoteWebElement {

        private final RemoteWebElement element;

        public Element(final WebElement element) {
            this.element = (RemoteWebElement) element;
            this.id = this.element.getId();
            try {
                Field parent =this.element.getClass().getDeclaredField("parent");
                parent.setAccessible(true);
                this.parent = (RemoteWebDriver) parent.get(this.element);
                Field fileDetector =this.element.getClass().getDeclaredField("fileDetector");
                fileDetector.setAccessible(true);
                this.fileDetector = (FileDetector) fileDetector.get(this.element);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void click() {
            BaseComponentImpl.this.click(element);
        }

        public void waitUntilIsVisible() {
            BaseComponentImpl.this.waitUntilElementIsVisible(element);
        }

        public void waitUntilIsInVisible() {
            BaseComponentImpl.this.waitUntilElementIsInvisible(element);
        }

        public void enterText(String text) {
            BaseComponentImpl.this.enterText(text, element);
        }

        public void enterTextWithActions(String text) {
            BaseComponentImpl.this.enterTextWithActions(text, element);
        }

        @Override
        public boolean isDisplayed() {
            return BaseComponentImpl.this.isDisplayed(element);
        }

        public String getTextNode() {
            return BaseComponentImpl.this.getTextNode(element);
        }

        @Override
        public String getAttribute(String attribute) {
            return BaseComponentImpl.this.getAttribute(attribute, element);
        }

        public String getAttributeValue() {
            return BaseComponentImpl.this.getAttributeValue(element);
        }

        public boolean isEditable() {
            return BaseComponentImpl.this.isEditable(element);
        }

        public boolean isClickable() {
            return BaseComponentImpl.this.isClickable(element);
        }

        public void waitElementAttributeIsNotEmpty(String attribute) {
            BaseComponentImpl.this.waitElementAttributeIsNotEmpty(attribute, element);
        }

        public Element getChildElement(String xPath, String... args) {
            try {
                return new Element(this.findElement(By.xpath(String.format(xPath, args))));
            } catch (NoSuchElementException ex) {
                return null;
            }
        }

        public Element getChildElement(By by) {
            try {
                return new Element(this.findElement(by));
            } catch (NoSuchElementException ex) {
                return null;
            }
        }

        @Override
        public String toString() {
            return "Element{" +
                    "element=" + element +
                    ", id='" + id + '\'' +
                    ", parent=" + parent +
                    ", fileDetector=" + fileDetector +
                    '}';
        }

        public void selectByVisibleText(String text) {
            Select select = new Select(element);
            select.selectByVisibleText(text);
        }
    }

    /**
     * Waits
     */

    private void waitUntilElementIsVisible(WebElement webElement) {
        waitUntil(driver1 -> isDisplayed(webElement));
    }

    private void waitUntilElementIsInvisible(WebElement webElement) {
        waitUntil(driver1 -> !isDisplayed(webElement));
    }

    private void waitElementAttributeIsNotEmpty(String attributeName, WebElement webElement) {
        waitUntil(driver1 -> (!webElement.getAttribute(attributeName).isEmpty()));
    }

}
