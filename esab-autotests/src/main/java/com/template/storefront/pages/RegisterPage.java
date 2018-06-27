package com.template.storefront.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.template.storefront.models.UserModel;
import static com.template.storefront.page_elements.RegisterPageElements.*;
import ru.yandex.qatools.allure.annotations.Step;

@Component
public class RegisterPage extends StorefrontBasePage {

	final static Logger logger = Logger.getLogger(RegisterPage.class);
	private String pageUrlMethod = "/esab/en/register";
	private List<String> verificationListOfLabelsEn = new ArrayList<>(Arrays.asList("Country  *", "Title  *",
			"First and Last Name  *", "Company ID  *", "Company Name  *", "Address Line 1  *",
			"Address Line 2 (optional)", "Town/City  *", "Postcode  *", "Your Position  *", "Telephone  *",
			"Ext. (optional)", "Email Address  *", "Confirm Email Address  *", "Comment (optional)"));
	private List<String> verificationHeadlineText = new ArrayList<>(Arrays.asList("New Customer Registration"));
	private List<String> verificationSecondlineText = new ArrayList<>(Arrays.asList("Submit your registration below"));
	private Map<String, String> customerData = new HashMap<String, String>();
	private UserModel userModel;

	public Map<String, String> getCustomerData() {
		return customerData;
	}

	@Override
	public String getPageUrl() {
		String registerPageUrl = storefrontProject.getBaseUrl() + pageUrlMethod;
		logger.info("Register page URL: " + registerPageUrl);
		return registerPageUrl;
	}

	public void createUserModel(String newCountry, String newTitle, String newFirstLastName, String newCompanyId,
			String newCompanyName, String newAddr1, String newAddr2, String newCity, String newPostCode,
			String newPosition, String newTelephone, String newExt, String newEmailAddr, String newConfirmEmailaddr,
			String newComment) {
		userModelBuilder.setNewCountry(newCountry);
		userModelBuilder.setNewTitle(newTitle);
		userModelBuilder.setNewFirstLastName(newFirstLastName);
		userModelBuilder.setNewCompanyId(newCompanyId);
		userModelBuilder.setNewCompanyName(newCompanyName);
		userModelBuilder.setNewAddr1(newAddr1);
		userModelBuilder.setNewAddr2(newAddr2);
		userModelBuilder.setNewCity(newCity);
		userModelBuilder.setNewPostCode(newPostCode);
		userModelBuilder.setNewPosition(newPosition);
		userModelBuilder.setNewTelephone(newTelephone);
		userModelBuilder.setNewExt(newExt);
		userModelBuilder.setNewEmailAddr(newEmailAddr);
		userModelBuilder.setNewConfirmEmailaddr(newConfirmEmailaddr);
		userModelBuilder.setNewComment(newComment);
		userModel = userModelBuilder.createUserModel();
		logger.info("UserModel: " + userModel);
	}

	@Step("Verify current page is Register page.")
	public void isCurrentUrlIsRegisterPageUrl() {
		String expectedUrl = getPageUrl();
		isCurrentUrlExpectedURL(expectedUrl);
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
	public void fillInFirstLastNameInput() {
		fillInTextInput(userModel.getFirstLastName(), FIRST_AND_LAST_NAME_XPATH);
	}

	@Step("Select specific Country.")
	public void selectCountry() {
		//String country = getWebElement(String.format(COUNTRY_VALUE_XPATH, userModel.getCountry())).getText().trim();
		click(String.format(COUNTRY_VALUE_XPATH, userModel.getCountry()));
		/*logger.error("Country value: " + country);
		customerData.put("Country", country);
		logger.info("Country field value entered: " + getCustomerData().get("Country"));*/
	}

	@Step("Select specific title")
	public void selectTitle() {
		click(String.format(TITLE_VALUE_XPATH, userModel.getTitle()));
	}

	@Step("Fill in CompanyID.")
	public void fillInCompanyId() {
		fillInTextInput(userModel.getCompanyId(), COMPANY_ID_XPATH);
	}

	@Step("Fill in Company Name.")
	public void fillInCompanyName() {
		fillInTextInput(userModel.getCompanyName(), COMPANY_NAME_XPATH);
	}

	@Step("Fill in Address Line 1.")
	public void fillInAddrLine1() {
		fillInTextInput(userModel.getAddr1(), ADDRESS_LINE_1_XPATH);
	}

	@Step("Fill in Address Line 2.")
	public void fillInAddrLine2() {
		fillInTextInput(userModel.getAddr2(), ADDRESS_LINE_2_XPATH);
	}

	@Step("Fill in City.")
	public void fillInCity() {
		fillInTextInput(userModel.getCity(), ADDRESS_CITY_XPATH);
	}

	@Step("Fill in Post Code.")
	public void fillInPostCode() {
		fillInTextInput(userModel.getPostCode(), ADDRESS_POST_CODE_XPATH);
	}

	@Step("Fill in Your Position.")
	public void fillInYourPosition() {
		fillInTextInput(userModel.getPosition(), YOUR_POSIRION_XPATH);
	}

	@Step("Fill in Telephone.")
	public void fillInTelephone() {
		fillInTextInput(userModel.getTelephone(), TELEPHONE_XPATH);
	}

	@Step("Fill in Ext.")
	public void fillInExt() {
		fillInTextInput(userModel.getExt(), EXT_XPATH);
	}

	@Step("Fill in EmailAddr.")
	public void fillInEmailAddr() {
		fillInTextInput(userModel.getEmailAddr().trim(), EMAIL_ADDRESS_XPATH);
	}

	@Step("Re enter EmailAddr.")
	public void fillInConfirmEmailAddr() {
		fillInTextInput(userModel.getConfirmEmailaddr().trim(), CONFIRM_EMAIL_XPATH);
	}

	@Step("Fill in Comment.")
	public void fillInComment() {
		fillInTextInput(userModel.getComment(), COMMENT_XPATH);
	}

	@Step("Press on Register button.")
	public void clickOnRegisterButton() {
		click(REGISTER_BUTTON_XPATH);
	}

}
