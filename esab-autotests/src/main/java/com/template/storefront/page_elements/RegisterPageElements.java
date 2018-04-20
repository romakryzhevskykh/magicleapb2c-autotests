package com.template.storefront.page_elements;

public class RegisterPageElements {
	private static String FORM_GROUP_XPATH = "//div[@class='form-group']";
	private static String REGISTRATION_SECTION_XPATH = "//div[@class='register__section']";
	public static String REGISTRATION_PAGE_FIELD_LABELS_XPATH = FORM_GROUP_XPATH + "//label[normalize-space(text())]";
	public static String REGISTRATION_PAGE_LABELS_XPATH = FORM_GROUP_XPATH + "//label[normalize-space(text())]";
	public static String REGISTRATION_PAGE_HEADLINE_TEXT_XPATH = "//div[@class='headline']";
	public static String REGISTRATION_PAGE_SECOND_LINE_TEXT_XPATH = REGISTRATION_SECTION_XPATH
			+ "//p[normalize-space(text())]";
	private static String REGISTRATION_PAGE_INPUT_BASIC_XPATH = "//input[@id='text.secureportal.register.%s']";
	public static String FIRST_AND_LAST_NAME_XPATH = String.format(REGISTRATION_PAGE_INPUT_BASIC_XPATH, "firstAndLastName");
	public static String ACCOUNT_NUMBER_XPATH = String.format(REGISTRATION_PAGE_INPUT_BASIC_XPATH, "accountNumber");
}
