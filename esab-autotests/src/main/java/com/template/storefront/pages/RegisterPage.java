package com.template.storefront.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
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

	@Step("Fill in First and Last name.")
	public void fillInFirstLastNameInput(String firstNameLastName) {
		fillInTextInput(firstNameLastName, FIRST_AND_LAST_NAME_XPATH);
	}

	@Step("Select specific Country.")
	public void selectCountry(String countryCode) {
		click(String.format(COUNTRY_VALUE_XPATH, countryCode));
	}
	
	@Step ("Select specific title")
	public void selectTitle(String title){
		click(String.format(TITLE_VALUE_XPATH, title));
	}
	
	@Step("Fill in CompanyID.")
	public void fillInCompanyId(String companyID) {
		fillInTextInput(companyID, COMPANY_ID_XPATH);
	}
	
	@Step("Fill in Company Name.")
	public void fillInCompanyName(String companyName) {
		fillInTextInput(companyName, COMPANY_NAME_XPATH);
	}
	
	@Step("Fill in Address Line 1.")
	public void fillInAddrLine1(String addrLine1) {
		fillInTextInput(addrLine1, ADDRESS_LINE_1_XPATH);
	}
	
	@Step("Fill in Address Line 2.")
	public void fillInAddrLine2(String addrLine2) {
		fillInTextInput(addrLine2, ADDRESS_LINE_2_XPATH);
	}
	
	@Step("Fill in City.")
	public void fillInCity(String city) {
		fillInTextInput(city, ADDRESS_CITY_XPATH);
	}
	
	@Step("Fill in Post Code.")
	public void fillInPostCode(String postCode) {
		fillInTextInput(postCode, ADDRESS_POST_CODE_XPATH);
	}
	
	@Step("Fill in Your Position.")
	public void fillInYourPosition(String position) {
		fillInTextInput(position, YOUR_POSIRION_XPATH);
	}
	
	@Step("Fill in Telephone.")
	public void fillInTelephone(String telephone) {
		fillInTextInput(telephone, TELEPHONE_XPATH);
	}
	
	@Step("Fill in Ext.")
	public void fillInExt(String ext) {
		fillInTextInput(ext, EXT_XPATH);
	}
	
	@Step("Fill in EmailAddr.")
	public void fillInEmailAddr(String emailAddr) {
		fillInTextInput(emailAddr, EMAIL_ADDRESS_XPATH);
	}
	
	@Step("Fill in EmailAddr.")
	public void fillInConfirmEmailAddr(String emailConfirmAddr) {
		fillInTextInput(emailConfirmAddr, CONFIRM_EMAIL_XPATH);
	}
	
	@Step("Fill in Comment.")
	public void fillInComment(String comment) {
		fillInTextInput(comment, COMMENT_XPATH);
	}
	
	@Step ("Press on Register button.")
	public void clickOnRegisterButton(){
		click(REGISTER_BUTTON_XPATH);
	}
	
	
}
