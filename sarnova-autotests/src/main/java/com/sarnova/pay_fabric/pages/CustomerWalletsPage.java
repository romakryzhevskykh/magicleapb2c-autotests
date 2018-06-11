package com.sarnova.pay_fabric.pages;

import com.sarnova.pay_fabric.models.CustomerWallet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.sarnova.pay_fabric.page_elements.CustomerWalletsPageElements.WALLETS_ITEMS_XPATH;

@Component
public class CustomerWalletsPage extends PayFabricBasePage {
    private final String pageMethodUrl = "Portal/AppCenter/PortalLoader?%s";

    @Override
    public boolean isOpened() {
        return super.isOpened() && leftBarBlock.isWalletsItemSelected();
    }

    @Override
    public String getPageUrl() {
        return payFabric.getBaseUrl() + String.format(pageMethodUrl, "");
    }

    @Step("Get last wallet in the list.")
    public CustomerWallet getLastWalletInTheList() {
        WebElement firstWallet = $$(WALLETS_ITEMS_XPATH).get(0);
        String customerId = firstWallet.findElement(By.xpath("/td[@aria-describedby='walletCardslist_Customer.CustomerNumber']")).getText();
        String tender = firstWallet.findElement(By.xpath("/td[@aria-describedby='walletCardslist_PaymentType']")).getText();
        String cardType = firstWallet.findElement(By.xpath("/td[@aria-describedby='walletCardslist_CardName']")).getText();
        String account = firstWallet.findElement(By.xpath("/td[@aria-describedby='walletCardslist_AccountNumber']")).getText();
        String firstName = firstWallet.findElement(By.xpath("/td[@aria-describedby='walletCardslist_CardHolder.CardHolderFirstName']")).getText();
        String lastName = firstWallet.findElement(By.xpath("/td[@aria-describedby='walletCardslist_CardHolder.CardHolderLastName']")).getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
        LocalDateTime createdDate = LocalDateTime.parse(firstWallet.findElement(By.xpath("/td[@aria-describedby='walletCardslist_LastUsedDate']")).getText(), formatter);
        return new CustomerWallet(customerId, tender, cardType, account, firstName, lastName, createdDate);
    }
}
