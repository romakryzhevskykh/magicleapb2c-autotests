package com.template.storefront.page_blocks;

//import static com.template.storefront.page_elements.LoggedInHeaderRowBlockElements.CUSTOMER_NAME;
import static com.template.storefront.page_elements.LoggedInHeaderRowBlockElements.MY_ACCOUNT_ADDRESS_BOOK_XPATH;
import static com.template.storefront.page_elements.LoggedInHeaderRowBlockElements.MY_ACCOUNT_DROP_DOWM_XPATH;
import static com.template.storefront.page_elements.LoggedInHeaderRowBlockElements.SIGN_OUT_BUTTON_XPATH;
import static com.template.storefront.page_elements.LoggedInHeaderRowBlockElements.WELCOME_TO_DASHBOARD_NAME;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.template.helpers.BasePageObject;
import com.template.helpers.user_engine.UserSessions;

import ru.yandex.qatools.allure.annotations.Step;

@Component
public class LoggedInHeaderRowBlock extends BasePageObject {
	@Autowired UserSessions userSessions;
	
	final static Logger logger = Logger.getLogger(LoggedInHeaderRowBlock.class);

    @Step("Check that user is logged in.")
    public boolean isUserLoggedIn() {
        return isDisplayed(MY_ACCOUNT_DROP_DOWM_XPATH);
    }
    
    @Step("Check that user is logged in ESAB.")
    public boolean isUserLoggedInEsab(){
    	boolean userLoggedIn = false;
    	String userName = userSessions.getActiveUserSession().getName();
    	logger.info("User name is: " + userName);
    	userLoggedIn = isStringContainsText(WELCOME_TO_DASHBOARD_NAME, userName);
    	logger.info("User is logged in: " + userLoggedIn);
    	return userLoggedIn;
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
