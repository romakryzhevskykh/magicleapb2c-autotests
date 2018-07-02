package com.template.storefront.pages;

import com.template.helpers.BasePageObject;
import com.template.helpers.user_engine.UserSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.template.storefront.page_elements.LoginPageElements.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

@Component
public class LoginPage extends StorefrontBasePage {
	// private final String pageUrlMethod = "powertools/en/USD/login";
	final static Logger logger = Logger.getLogger(LoginPage.class);
	private final String pageUrlMethod = "/esab/en/login";
	private final String validationRegistrationConfirmationMesage = "User registered with success.";

	public boolean isOpened() {
		return isCurrentURLEqualsToLoginPageURL() && isUserLoggedOut();
	}

	@Step("Fill username field.")
	public void fillUsernameFieldWith(String username) {
		$(USERNAME_FIELD_XPATH).sendKeys(username);
	}

	@Step("Fill password field.")
	public void fillPasswordFieldWith(String password) {
		$(PASSWORD_FIELD_XPATH).sendKeys(password);
	}

	@Step("Click on Login button.")
	public void clickOnLoginButton() {
		click(LOG_IN_BUTTON_XPATH);
	}

	public void loginToStorefront(UserSession user) {
		fillUsernameFieldWith(user.getUsername());
		fillPasswordFieldWith(user.getPassword());
		clickOnLoginButton();
	}

	public void goToRegisterPage() {
		clickOnRegisterButton();
	}

	@Step("Check that current url is Login page url.")
	private boolean isCurrentURLEqualsToLoginPageURL() {
		return getPageUrl().equals(getCurrentUrl());
	}

	@Override
	public String getPageUrl() {
		return storefrontProject.getBaseUrl() + pageUrlMethod;
	}

	@Step("Click on Register button.")
	public void clickOnRegisterButton() {
		click(REGISTER_BUTTON_XPATH);
	}

	@Step("Verify registration message.")
	public void verifyRegistrationConfirmationMessage() {
		String actualRegistrationConfirmationMessage = getWebElement(REGISTRATION_CONFIRMATION_MESSAGE).getText()
				.trim();
		if (actualRegistrationConfirmationMessage != null) {
			logger.info("Actual confirmation message is: " + actualRegistrationConfirmationMessage);
			assertTrue(actualRegistrationConfirmationMessage.contains(validationRegistrationConfirmationMesage),
					"Actual registration confirmation message: " + actualRegistrationConfirmationMessage
							+ " is not contains registration confirmation message: "
							+ validationRegistrationConfirmationMesage);
			/*
			 * assertEquals(actualRegistrationConfirmationMessage,
			 * validationRegistrationConfirmationMesage,
			 * "Actual registration confirmation message: " +
			 * actualRegistrationConfirmationMessage +
			 * "is different to expected registration confirmation message: " +
			 * validationRegistrationConfirmationMesage);
			 */
		}

	}
}
