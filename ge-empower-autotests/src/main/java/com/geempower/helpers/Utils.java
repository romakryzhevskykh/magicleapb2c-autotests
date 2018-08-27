package com.geempower.helpers;

import com.geempower.helpers.web_engine.WebDriverSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class Utils extends UIComponent {
    @Autowired
    private WebDriverSessions webDriverPool;

    @Step("Refresh the page.")
    public void refreshCurrentPage() {
        webDriverPool.getActiveDriver().navigate().refresh();
    }

    @Step("Focus on browser.")
    public void focusOnActiveBrowser() {
        webDriverPool.getActiveDriver().switchTo().window(webDriverPool.getActiveDriver().getWindowHandle());
    }

    @Step("Upload file with appropriate name.")
    public void uploadFileByName(String fileName, String uploadInputXpath) {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata/" + fileName;
        $(uploadInputXpath).sendKeys(filePath);
    }

    @Step("Get Local Date Time Stamp.")
    public String getLocalDateTimeStamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm");
        return now.format(formatter);
    }

    @Step("Get Local Date Time Stamp.")
    public String getLocalDateTimeStamp(String dateFormat) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        return now.format(formatter);
    }
}
