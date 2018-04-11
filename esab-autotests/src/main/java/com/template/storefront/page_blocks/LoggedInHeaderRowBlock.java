package com.template.storefront.page_blocks;

import static com.template.storefront.page_elements.LoggedInHeaderRowBlockElements.CUSTOMER_NAME;
import static com.template.storefront.page_elements.LoggedInHeaderRowBlockElements.MY_ACCOUNT_ADDRESS_BOOK_XPATH;
import static com.template.storefront.page_elements.LoggedInHeaderRowBlockElements.MY_ACCOUNT_DROP_DOWM_XPATH;
import static com.template.storefront.page_elements.LoggedInHeaderRowBlockElements.SIGN_OUT_BUTTON_XPATH;
import static com.template.storefront.page_elements.LoggedInHeaderRowBlockElements.WELCOME_TO_DASHBOARD_NAME;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.template.helpers.BasePageObject;

import ru.yandex.qatools.allure.annotations.Step;

@Component
public class LoggedInHeaderRowBlock extends BasePageObject {
	
	final static Logger logger = Logger.getLogger(LoggedInHeaderRowBlock.class);

    @Step("Check that user is logged in.")
    public boolean isUserLoggedIn() {
        return isDisplayed(MY_ACCOUNT_DROP_DOWM_XPATH);
    }
    
    @Step("Check that user is logged in ESAB.")
    public boolean isUserLoggedInEsab(){
    	boolean UserLoggedIn = false;
    	UserLoggedIn = isStringContainsText(WELCOME_TO_DASHBOARD_NAME, CUSTOMER_NAME);
    	logger.info("User is logged in: " + UserLoggedIn);
    	return UserLoggedIn;
    }
    
    @Step("Click on sign out button.")
    public void clickOnSignOutButton() {
        $(SIGN_OUT_BUTTON_XPATH).click();
    }

    @Step("Click on My Account menu(drop-down).")
    public void clickOnMyAccountMenu() {
        $(MY_ACCOUNT_DROP_DOWM_XPATH).click();
    }

    @Step("Click on Address Book item in My Account drop-down.")
    public void clickOnAddressBookItemInMyAccount() {
        $(MY_ACCOUNT_ADDRESS_BOOK_XPATH).click();
    }
}
