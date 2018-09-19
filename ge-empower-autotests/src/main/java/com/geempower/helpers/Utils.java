package com.geempower.helpers;

import com.geempower.helpers.web_engine.WebDriverSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @Step("Check valid date.")
    public boolean isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

    @Step("Check if one date greater than Other Date.")
    public boolean isGottenDateGreaterThanOtherDate(String date1, String date2) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        dateFormat.setLenient(false);
        try {
            return dateFormat.parse(date1).after(dateFormat.parse(date2));
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Step("Check if one date equals to Other Date.")
    public boolean isGottenDateEqualsToOtherDate(String date1, String date2) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        dateFormat.setLenient(false);
        try {
            return dateFormat.parse(date1).equals(dateFormat.parse(date2));
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }
}
