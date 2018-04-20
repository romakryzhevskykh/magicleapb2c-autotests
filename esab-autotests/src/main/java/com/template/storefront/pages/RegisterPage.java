package com.template.storefront.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import static com.template.storefront.page_elements.RegisterPageElements.*;
import static org.testng.Assert.assertEquals;

import ru.yandex.qatools.allure.annotations.Step;

@Component
public class RegisterPage extends StorefrontBasePage {

	final static Logger logger = Logger.getLogger(RegisterPage.class);
	private String pageUrlMethod = "/esab/en/register";
	private List<String> verificationListOfLabelsEn = new ArrayList<>(Arrays.asList("Country  *", "Title  *",
			"First and Last Name  *", "Company ID  *", "Company Name  *", "Address Line 1  *",
			"Address Line 2 (optional)", "City  *", "Post Code  *", "Your Position  *", "Telephone  *",
			"Ext. (optional)", "Email Address  *", "Confirm Email Address", "Comment (optional)"));
	private List<String> verificationHeadlineText = new ArrayList<>(Arrays.asList("New Customer Registration"));
	private List<String> verificationSecondlineText = new ArrayList<>(Arrays.asList("Submit your registration below")); 

	@Override
	public String getPageUrl() {
		String registerPageUrl = storefrontProject.getBaseUrl() + pageUrlMethod;
		logger.info("Register page URL: " + registerPageUrl);
		return registerPageUrl;
	}

	@Step("Verify current page is Register page.")
	public boolean isCurrentUrlIsRegisterPageUrl() {
		return getPageUrl().equals(getCurrentUrl());
	}

	@Step("Verify field label names on Register page.")
	public void verifyRegisterPageFieldLabels() {
		verifyWebElementsTextValuesEqual(verificationListOfLabelsEn, REGISTRATION_PAGE_LABELS_XPATH);
	}

	@Step("Verify headline text on Register page.")
	public void verifyRegisterPageHeadLineText() {
		verifyWebElementsTextValuesEqual(verificationHeadlineText, REGISTRATION_PAGE_HEADLINE_TEXT_XPATH);
	}

	@Step("Verify second line text on Register page.")
	public void verifyRegisterPageSecondLineText() {
		verifyWebElementsTextValuesEqual(verificationSecondlineText, REGISTRATION_PAGE_SECOND_LINE_TEXT_XPATH);
	}
	//TODO: implement send text method
	@Step("Fill in First and Last name.")
	public void fillInFirstLastNameInput(String firstNameLastName){
		fillInTextInput(firstNameLastName, FIRST_AND_LAST_NAME_XPATH);
	}

}
