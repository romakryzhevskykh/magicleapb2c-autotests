package com.sarnova.pay_fabric.pages;

import com.sarnova.pay_fabric.models.CustomerWallet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.sarnova.pay_fabric.page_elements.CustomerWalletsPageElements.*;

@Component
public class CustomerWalletsPage extends PayFabricBasePage {
    private final String pageMethodUrl = "Portal/AppCenter/PortalLoader?%s";

    @Override
    public boolean isOpened() {
        return getCurrentUrl().contains(getPageUrl()) && payFabricLeftBarBlock.isWalletsItemSelected();
    }

    @Override
    public String getPageUrl() {
        return payFabric.getBaseUrl() + String.format(pageMethodUrl, "");
    }

    @Step("Get last wallet in the list.")
    public CustomerWallet getLastWalletInTheList() {
        WebElement firstWallet = getElementsInFrame("portalFrame", WALLETS_ITEMS_XPATH).get(0);
        getDriver().switchTo().frame("portalFrame");
        String customerId = firstWallet.findElement(By.xpath("td[@aria-describedby='walletCardslist_Customer.CustomerNumber']")).getText();
        String tender = firstWallet.findElement(By.xpath("td[@aria-describedby='walletCardslist_PaymentType']")).getText();
        String cardType = firstWallet.findElement(By.xpath("td[@aria-describedby='walletCardslist_CardName']")).getText();
        String account = firstWallet.findElement(By.xpath("td[@aria-describedby='walletCardslist_AccountNumber']")).getText();
        String firstName = firstWallet.findElement(By.xpath("td[@aria-describedby='walletCardslist_CardHolder.CardHolderFirstName']")).getText();
        String lastName = firstWallet.findElement(By.xpath("td[@aria-describedby='walletCardslist_CardHolder.CardHolderLastName']")).getText();
        String dateTime = firstWallet.findElement(By.xpath("td[@aria-describedby='walletCardslist_LastUsedDate']")).getText();
        if (dateTime.indexOf("/") == 1)
            dateTime = "0" + dateTime;
        if (dateTime.indexOf(":") == 12)
            dateTime = dateTime.substring(0, 11) + "0" + dateTime.substring(11);
        System.out.println(dateTime);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
        LocalDateTime createdDate = LocalDateTime.parse(dateTime, formatter);
        getDriver().switchTo().defaultContent();
        return new CustomerWallet(customerId, tender, cardType, account, firstName, lastName, createdDate);
    }
}
