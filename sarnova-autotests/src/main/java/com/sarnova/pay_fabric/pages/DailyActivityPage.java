package com.sarnova.pay_fabric.pages;

import com.sarnova.pay_fabric.models.Transaction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.sarnova.pay_fabric.page_elements.DailyActivityPageElements.*;

@Component
public class DailyActivityPage extends PayFabricBasePage {
    private final String pageMethodUrl = "Portal/AppCenter/PortalLoader?%s";

    @Step("Click on Run report button.")
    public void clickOnRunReportButton() {
        clickInFrame("portalFrame", RUN_REPORT_BUTTON_XPATH);
        waitUntilPageIsFullyLoaded();
    }

    @Step("Get last transaction in the list.")
    public Transaction getLastTransactionInTheList() {
        WebElement firstWallet = getElementsInFrame("portalFrame", TRANSACTION_ITEMS_XPATH).get(0);
        getDriver().switchTo().frame("portalFrame");
        String customerId = firstWallet.findElement(By.xpath("td[@aria-describedby='trxdailyactivitylist_CustomerNumber']")).getText();
        String account = firstWallet.findElement(By.xpath("td[@aria-describedby='trxdailyactivitylist_Account']")).getText();
        String expDate = firstWallet.findElement(By.xpath("td[@aria-describedby='trxdailyactivitylist_Expirationdate']")).getText();
        String amount = firstWallet.findElement(By.xpath("td[@aria-describedby='trxdailyactivitylist_Trxamount']")).getText();
        String dateTime = firstWallet.findElement(By.xpath("td[@aria-describedby='trxdailyactivitylist_Trxdate']")).getText();
        if (dateTime.indexOf("/") == 1)
            dateTime = "0" + dateTime;
        if (dateTime.indexOf(":") == 12)
            dateTime = dateTime.substring(0, 11) + "0" + dateTime.substring(11);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
        LocalDateTime createdDate = LocalDateTime.parse(dateTime, formatter);
        getDriver().switchTo().defaultContent();
        return new Transaction(createdDate, account, expDate, amount, customerId);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().contains(getPageUrl()) && payFabricLeftBarBlock.isDailyActivityItemSelected();
    }

    @Override
    public String getPageUrl() {
        return payFabric.getBaseUrl() + String.format(pageMethodUrl, "");
    }

}
