package com.template.helpers.webengine;

import com.template.helpers.Logging;
import com.template.helpers.Utils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.stream.Collectors;

public class Browser extends HtmlUnitDriver {

    private static Logging log = Logging.getLogging();
    private static ArrayList<Browser> browsers = new ArrayList<>();
    private static final int WEB_DRIVER_TIMEOUT = 30;
    private static final double TWO_HUNDRED_MILLISECONDS = 0.2;
    private static final double MIN_TIMEOUT = 0.05;
    private static final int ONE_SECOND = 1;
    private static final int BROWSER_MAX_TRIES = 50;
    private static final int SHORT_MAX_TRIES = 20;

    private WebDriver driver;
    private final String handle;
    private String newHandle;
    private WebDriverWait wait;
    private Set<Cookie> cookies;
    private boolean isBrowserGhost;


    public Browser(WebDriver driver) {
        this.driver = driver;
        this.handle = driver.getWindowHandle();
        this.isBrowserGhost = this.driver instanceof HtmlUnitDriver;
        if (isBrowserGhost)
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, WEB_DRIVER_TIMEOUT);
        browsers.add(this);
    }

    public static Browser createNewInstance() {
        return new Browser(new FirefoxDriver());
    }

    @Override
    public String getPageSource() {
        return driver.getPageSource();
    }

    public void waitHTMLTemplateLoad() {
        if (!isBrowserGhost) {
            ExpectedCondition<Boolean> pageLoadCondition = driver1 -> ((JavascriptExecutor) driver1).executeScript("return document.readyState").equals("complete");
            wait.until(pageLoadCondition);
        }
    }

    public void waitJQueryRequestsLoad() {
        if (!isBrowserGhost) {
            Utils.wait(TWO_HUNDRED_MILLISECONDS / 4);
            ExpectedCondition<Boolean> jQueryLoadCondition = driver1 -> {
                boolean result;
                JavascriptExecutor js = (JavascriptExecutor) driver1;
                try {
                    result = (Boolean) js.executeScript("return jQuery.active == 0");
                } catch (WebDriverException ex) {
                    result = true;
                    log.writeLog("[INFO] No jQueries.");
                }
                return result;
            };
            try {
                wait.until(jQueryLoadCondition);
            } catch (TimeoutException ex) {
                log.writeLog("[WARNING] Timeout exception after " + WEB_DRIVER_TIMEOUT + " Seconds. Possible problem - browser hovered(not responding)!");
            }
            Utils.wait(TWO_HUNDRED_MILLISECONDS / 4);
        }
    }

    public boolean isElementPresent(Element element) {
        return isElementPresent(element, SHORT_MAX_TRIES);
    }

    public boolean isElementPresent(Element element, int maxTries) {
        try {
            getVisibleWebElement(element, maxTries);
            return true;
        } catch (NotFoundException e) {
            return false;
        }
    }

    public boolean isElementActive(Element element) {
        return getAttributeValueOfElement(element, "class").contains("active");
    }

    public boolean isElementSelected(Element element) {
        WebElement elem = driver.findElement(element.getBy());
        return elem.getSize().getWidth() > 0 && elem.isSelected();
    }

    public void waitElementAppears(Element element) {
        getVisibleWebElement(element, BROWSER_MAX_TRIES);
    }

    public void waitElementDisappears(Element element) {
        hasElementDisappeared(element);
    }

    public boolean hasElementDisappeared(Element element) {
        for (int i = 0; i <= BROWSER_MAX_TRIES; i++) {
            if (!isElementPresent(element, 1)) {
                return true;
            }
            Utils.wait(TWO_HUNDRED_MILLISECONDS);
        }
        return false;
    }

    public void openUrl(String url) {
        if (!isBrowserGhost) {
            driver.get(url);
        } else {
            log.writeLog("[INFO] Get url: " + url + " using ghost mode.");
            java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF);
            driver.get(url);
        }
    }

    public boolean activateElement(Element element) {
        return activateElement(element, 0);
    }

    public boolean activateElement(Element element, int sleepTime) {
        int tries = 0;
        do {
            click(element);
            Utils.wait(sleepTime);
            waitJQueryRequestsLoad();
            if (isElementActive(element))
                return true;
            Utils.wait(TWO_HUNDRED_MILLISECONDS / 2);
        } while (++tries < SHORT_MAX_TRIES);
        log.writeLog("[ERROR] Can't select element: " + element);
        throw new NotFoundException("[ERROR] Can't select element: " + element);
    }

    public void click(Element element) {
        performActionWithElement(element, new ActionElementClick());
    }

    public void contextClick(Element element) {
        performActionWithElement(element, new ActionElementContextClick(driver));
    }

    public void enterText(Element element, String text) {
        isElementPresent(element, BROWSER_MAX_TRIES);
        driver.findElement(element.getBy()).clear();
        driver.findElement(element.getBy()).sendKeys(text);
    }

    public void pressEnter(Element element) {
        driver.findElement(element.getBy()).sendKeys(Keys.ENTER);
    }

    public void closeBrowser() {
        driver.close();
    }

    public void quitBrowser() {
        driver.quit();
    }

    public String getTextOnElement(Element element) {
        if (!isBrowserGhost) {
            waitJQueryRequestsLoad();
            int tries = 0;
            do {
                try {
                    WebElement elem = driver.findElement(element.getBy());
                    try {
                        if (!elem.getText().isEmpty()) {
                            return elem.getText();
                        } else if (!((String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText", elem)).isEmpty()) {
                            log.writeLog("[WARNING] Get text! Element is hidden: " + element);
                            return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText", elem);
                        } else {
                            log.writeLog("[WARNING] Text is empty: " + element);
                            return "";
                        }
                    } catch (StaleElementReferenceException | ElementNotVisibleException e) {/* skip */}
                } catch (NoSuchElementException ex) {/* skip */}
                Utils.wait(TWO_HUNDRED_MILLISECONDS);
            } while (++tries < BROWSER_MAX_TRIES);
            log.writeLog("[ERROR] Can't get text of element: " + element);
            throw new NotFoundException("[ERROR] Can't get text of element: " + element);
        } else
            return driver.findElement(element.getBy()).getText();
    }

    public String getAttributeValueOfElement(Element element, String attributeName) {
        int tries = 0;
        do {
            try {
                WebElement elem = driver.findElement(element.getBy());
                return elem.getAttribute(attributeName);
            } catch (StaleElementReferenceException | ElementNotVisibleException | NoSuchElementException e) {/* skip */}
            Utils.wait(TWO_HUNDRED_MILLISECONDS);
        } while (++tries < BROWSER_MAX_TRIES);
        log.writeLog("[ERROR] Can't get attribute " + attributeName + " of element: " + element);
        throw new NotFoundException("[ERROR] Can't get attribute " + attributeName + " of element: " + element);
    }

    public void setCookie(String cookieName, String value) {
        Cookie cookie = new Cookie(cookieName, value);
        if (this.cookies != null)
            this.cookies.clear();
        else
            this.cookies = new HashSet<>();
        ;
        this.cookies.add(cookie);
        driver.manage().deleteAllCookies();
        driver.manage().addCookie(cookie);
    }

    public void refreshPage() {
        log.writeLog("Refresh page.");
        driver.navigate().refresh();
        waitHTMLTemplateLoad();
        waitJQueryRequestsLoad();
    }

    public void dragElementToElement(Element sourceElement, Element destinationElement) {
        Actions action = new Actions(driver);
        for (int i = 0; i <= BROWSER_MAX_TRIES; i++) {
            try {
                WebElement sourceWebElement = getVisibleWebElement(sourceElement);
                WebElement destinationWebElement = getVisibleWebElement(destinationElement);
                action.dragAndDrop(sourceWebElement, destinationWebElement).perform();
                return;
            } catch (StaleElementReferenceException | ElementNotVisibleException | NoSuchElementException e) {/*skip*/}
            Utils.wait(TWO_HUNDRED_MILLISECONDS);
        }
    }

    public void takeScreenshot(String pathToSave) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(pathToSave));
    }

    private void performActionWithElement(Element element, IElementAction action) {
        if (!isBrowserGhost) {
            boolean actionPerformed = false;
            int tries = 0;
            do {
                WebElement elem = getVisibleWebElement(element);
                try {
                    scrollToElement(element);
                    if (!elem.isDisplayed()) {
                        log.writeLog(elem + " is not displayed");
                        if (action instanceof ActionElementClick) {
                            log.writeLog("[WARNING] Can't perform UI action with: " + element + " is not displayed!");
                            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
                            actionPerformed = true;
                            break;
                        }
                    }
                    ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", elem);
                    action.perform(elem);
                    actionPerformed = true;
                } catch (StaleElementReferenceException | ElementNotVisibleException | NoSuchElementException e) {
                    log.writeLog("[WARNING] " + e);
                } catch (WebDriverException ex) {
                    if (action instanceof ActionElementClick && tries > SHORT_MAX_TRIES) {
                        log.writeLog("[WARNING] Can't perform UI action with: " + element + " is not clickable!");
                        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
                        actionPerformed = true;
                        break;
                    }
                }
                Utils.wait(TWO_HUNDRED_MILLISECONDS);
            } while (!actionPerformed && ++tries < BROWSER_MAX_TRIES);
            if (!actionPerformed) {
                log.writeLog("[ERROR] Can't perform action with element: " + element);
                throw new NotFoundException("[ERROR] Can't perform action with element: " + element);
            }
        } else
            action.perform(getVisibleWebElement(element));
    }

    public int getNumberOfWebElementsOnPage(Element element) {
        waitJQueryRequestsLoad();
        int result = 0;
        Boolean isResultReliable;
        for (int i = 0; i <= SHORT_MAX_TRIES; i++) {
            List<WebElement> matching_elements = driver.findElements(element.getBy());
            result = 0;
            isResultReliable = Boolean.TRUE;
            for (WebElement elem : matching_elements) {
                try {
                    if (elem.getSize().getWidth() > 0 && elem.isEnabled()) {
                        result++;
                    }
                } catch (StaleElementReferenceException | ElementNotVisibleException | NoSuchElementException e) {
                    isResultReliable = Boolean.FALSE;
                }
            }
            if (isResultReliable && result != 0) {
                return result;
            }
            Utils.wait(ONE_SECOND);
        }
        return result;
    }

    public WebElement getVisibleWebElement(Element element, int maxTries) {
        for (int i = 0; i < maxTries; i++) {
            List<WebElement> matching_elements = driver.findElements(element.getBy());
            for (WebElement elem : matching_elements) {
                try {
                    if (elem.getSize().getWidth() > 0 && elem.isEnabled()) {
                        return elem;
                    }
                } catch (StaleElementReferenceException | ElementNotVisibleException | NoSuchElementException e) {/* skip */}
            }
            Utils.wait(TWO_HUNDRED_MILLISECONDS);
        }
        log.writeLog("[ERROR] Can't find element '" + element + "' on page.");
        throw new NotFoundException("[ERROR] Can't find element '" + element + "' on page.");
    }

    private WebElement getVisibleWebElement(Element element) {
        return getVisibleWebElement(element, BROWSER_MAX_TRIES);
    }

    public ArrayList<WebElement> getVisibleWebElements(Element element) {
        ArrayList<WebElement> elements = new ArrayList<>();
        List<WebElement> matching_elements = driver.findElements(element.getBy());
        if (!isBrowserGhost) {
            for (WebElement elem : matching_elements) {
                try {
                    if (elem.getSize().getWidth() > 0 && elem.isEnabled()) {
                        elements.add(elem);
                    }
                } catch (StaleElementReferenceException | ElementNotVisibleException | NoSuchElementException e) {/*skip */}
            }
            return elements;
        } else
            return matching_elements.stream().filter(WebElement::isEnabled).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<String> getTextValuesOnWebElements(Element element) {
        return getTextValuesOnWebElements(element, BROWSER_MAX_TRIES);
    }

    public ArrayList<String> getTextValuesOnWebElements(Element element, int tries) {
        ArrayList<String> textValues = new ArrayList<>();
        Boolean isResultReliable = Boolean.TRUE;
        if (!isBrowserGhost) {
            for (int i = 0; i <= tries; i++) {
                List<WebElement> matching_elements = driver.findElements(element.getBy());
                for (WebElement elem : matching_elements) {
                    try {
                        if (elem.getSize().getWidth() > 0 && elem.isEnabled()) {
                            textValues.add(elem.getText());
                        }
                    } catch (StaleElementReferenceException | ElementNotVisibleException | NoSuchElementException e) {
                        isResultReliable = Boolean.FALSE;
                    }
                }
                if (isResultReliable && !(textValues.isEmpty())) {
                    return textValues;
                }
                Utils.wait(TWO_HUNDRED_MILLISECONDS);
            }
        } else {
            List<WebElement> matching_elements = driver.findElements(element.getBy());
            for (WebElement elem : matching_elements) {
                try {
                    textValues.add(elem.getText());
                } catch (StaleElementReferenceException | ElementNotVisibleException | NoSuchElementException e) {/*ignored*/}
            }
        }
        return textValues;
    }

    public ArrayList<String> getAttributeValuesOnElements(Element element, String attribute) {
        return getAttributeValuesOnElements(element, attribute, BROWSER_MAX_TRIES);
    }

    public ArrayList<String> getAttributeValuesOnElements(Element element, String attribute, int tries) {
        ArrayList<String> attributeValues = new ArrayList<>();
        Boolean isResultReliable;
        for (int i = 0; i <= tries; i++) {
            attributeValues = new ArrayList<>();
            isResultReliable = Boolean.TRUE;
            List<WebElement> matching_elements = driver.findElements(element.getBy());
            for (WebElement elem : matching_elements) {
                try {
                    if (elem.getSize().getWidth() > 0 && elem.isEnabled()) {
                        attributeValues.add(elem.getAttribute(attribute));
                    }
                } catch (StaleElementReferenceException | ElementNotVisibleException | NoSuchElementException e) {
                    log.writeLog("[WARNING] " + matching_elements.indexOf(elem) + " in list is not displayed!");
                    isResultReliable = Boolean.FALSE;
                }
            }
            if (isResultReliable && !(attributeValues.isEmpty())) {
                return attributeValues;
            }
            Utils.wait(TWO_HUNDRED_MILLISECONDS);
        }
        return attributeValues;
    }

    public ArrayList<String> getAttributeValuesOnElementsEvenIfElementsIsNotVisible(Element element, String attribute) {
        return getAttributeValuesOnElementsEvenIfElementsIsNotVisible(element, attribute, BROWSER_MAX_TRIES);
    }

    public ArrayList<String> getAttributeValuesOnElementsEvenIfElementsIsNotVisible(Element element, String attribute, int tries) {
        ArrayList<String> attributeValues = new ArrayList<>();
        Boolean isResultReliable;
        for (int i = 0; i <= tries; i++) {
            attributeValues = new ArrayList<>();
            isResultReliable = Boolean.TRUE;
            List<WebElement> matching_elements = driver.findElements(element.getBy());
            for (WebElement elem : matching_elements) {
                try {
                    attributeValues.add(elem.getAttribute(attribute));
                } catch (StaleElementReferenceException | ElementNotVisibleException | NoSuchElementException e) {
                    log.writeLog("[WARNING] " + matching_elements.indexOf(elem) + " in list is not displayed!");
                    isResultReliable = Boolean.FALSE;
                }
            }
            if (isResultReliable && !(attributeValues.isEmpty())) {
                return attributeValues;
            }
            Utils.wait(TWO_HUNDRED_MILLISECONDS);
        }
        return attributeValues;
    }

    public ArrayList<String> getAttributeValuesOnWebElements(List<WebElement> webElements, String attribute) {
        ArrayList<String> attributeValues = new ArrayList<>();
        Boolean isResultReliable;
        for (int i = 0; i <= BROWSER_MAX_TRIES; i++) {
            attributeValues = new ArrayList<>();
            isResultReliable = Boolean.TRUE;
            for (WebElement elem : webElements) {
                try {
                    if (elem.getSize().getWidth() > 0 && elem.isEnabled()) {
                        attributeValues.add(elem.getAttribute(attribute));
                    }
                } catch (StaleElementReferenceException | ElementNotVisibleException | NoSuchElementException e) {
                    isResultReliable = Boolean.FALSE;
                }
            }
            if (isResultReliable && !(attributeValues.isEmpty())) {
                return attributeValues;
            }
            Utils.wait(TWO_HUNDRED_MILLISECONDS);
        }
        return attributeValues;
    }

    public ArrayList<WebElement> getSelectedWebElements(Element element) {
        ArrayList<WebElement> elements = new ArrayList<>();
        List<WebElement> matching_elements = driver.findElements(element.getBy());
        if (!isBrowserGhost) {
            for (WebElement elem : matching_elements) {
                try {
                    if (elem.getSize().getWidth() > 0 && elem.isSelected()) {
                        elements.add(elem);
                    }
                } catch (StaleElementReferenceException | ElementNotVisibleException | NoSuchElementException e) {/*skip */}
            }
            return elements;
        } else {
            return matching_elements.stream().filter(WebElement::isSelected).collect(Collectors.toCollection(ArrayList::new));
        }
    }

    public void waitUntilElementTextIsNotEmpty(Element element) {
        String elementText;
        int count = 0;
        do {
            Utils.wait(MIN_TIMEOUT);
            elementText = getTextOnElement(element);
            count++;
        } while (elementText.isEmpty() || count >= SHORT_MAX_TRIES);
    }

    public String[] getElementRGB(Element element, String styleName) {
        waitElementAppears(element);
        return driver.findElement(element.getBy()).getCssValue(styleName).replaceAll("(rgba)|(rgb)|(\\()|(\\s)|(\\))", "").split(",");
    }

    public String[] getElementRGB(WebElement element, String styleName) {
        return element.getCssValue(styleName).replaceAll("(rgba)|(rgb)|(\\()|(\\s)|(\\))", "").split(",");
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public String getWorkingBrowserHandle() {
        return handle;
    }

    public void setNewHandle() {
        this.newHandle = driver.getWindowHandle();
    }

    public String getActualHandle() {
        return driver.getWindowHandle();
    }

    public String getNewHandle() {
        return newHandle;
    }

    public Set<String> getBrowserHandles() {
        return driver.getWindowHandles();
    }

    public String getBrowserUrl() {
        return driver.getCurrentUrl();
    }

    public void switchToHandle(String newWindowHandle) {
        driver.switchTo().window(newWindowHandle);
    }

    public void scrollToElement(Element element) {
        WebElement targetElement = driver.findElement(element.getBy());
        Coordinates coordinate = ((Locatable) targetElement).getCoordinates();
        coordinate.onPage();
        coordinate.inViewPort();
    }

    public void scrollToElement(WebElement targetElement) {
        Coordinates coordinate = ((Locatable) targetElement).getCoordinates();
        coordinate.onPage();
        coordinate.inViewPort();
    }

    public Set<Cookie> getCookies() {
        return cookies;
    }

    public void setCookies(Set<Cookie> cookies) {
        if (this.cookies != null) {
            this.cookies.clear();
            this.cookies.addAll(cookies);
        } else
            this.cookies = cookies;
        driver.manage().deleteAllCookies();
        cookies.forEach(cookie -> driver.manage().addCookie(cookie));
    }

    public Object executeJS(String jsScript) {
        return ((JavascriptExecutor) driver).executeScript(jsScript);
    }

    public void setBrowserCookies() {
        this.cookies = driver.manage().getCookies();
    }

    public static Browser getGhostBrowser() {
        return new Browser(new HtmlUnitDriver());
    }
}