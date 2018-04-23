package com.template.storefront.page_elements;

public class RegisterPageElements {
	private static String FORM_GROUP_XPATH = "//div[@class='form-group']";
	private static String REGISTRATION_SECTION_XPATH = "//div[@class='register__section']";
	public static String REGISTRATION_PAGE_FIELD_LABELS_XPATH = FORM_GROUP_XPATH + "//label[normalize-space(text())]";
	public static String REGISTRATION_PAGE_LABELS_XPATH = FORM_GROUP_XPATH + "//label[normalize-space(text())]";
	public static String REGISTRATION_PAGE_HEADLINE_TEXT_XPATH = "//div[@class='headline']";
	public static String REGISTRATION_PAGE_SECOND_LINE_TEXT_XPATH = REGISTRATION_SECTION_XPATH
			+ "//p[normalize-space(text())]";
	private static String REGISTRATION_PAGE_SELECT_BASIC_XPATH = "//select[@id='%s']";
	public static String COUNTRY_DROPDOWN = String.format(REGISTRATION_PAGE_SELECT_BASIC_XPATH, "address.country_del");
	// Need to be used with specific country value. i.e. "US"
	public static String COUNTRY_VALUE_XPATH = COUNTRY_DROPDOWN + "/option[@value='%s']";
	public static String TITLE_DROPDOWN = String.format(REGISTRATION_PAGE_SELECT_BASIC_XPATH, "register.title");
	public static String TITLE_VALUE_XPATH = TITLE_DROPDOWN + "/option[@value='%s']";
	private static String REGISTRATION_PAGE_SECURE_PORTAL_BASIC_XPATH = "//input[@id='text.secureportal.register.%s']";
	public static String FIRST_AND_LAST_NAME_XPATH = String.format(REGISTRATION_PAGE_SECURE_PORTAL_BASIC_XPATH,
			"firstAndLastName");
	public static String COMPANY_ID_XPATH = String.format(REGISTRATION_PAGE_SECURE_PORTAL_BASIC_XPATH, "accountNumber");
	public static String COMPANY_NAME_XPATH = String.format(REGISTRATION_PAGE_SECURE_PORTAL_BASIC_XPATH, "companyName");
	private static String ADDRESS_BASIC_XPATH = "//input[@id='address.%s']";
	public static String ADDRESS_LINE_1_XPATH = String.format(ADDRESS_BASIC_XPATH, "line1");
	public static String ADDRESS_LINE_2_XPATH = String.format(ADDRESS_BASIC_XPATH, "line2");
	public static String ADDRESS_CITY_XPATH = String.format(ADDRESS_BASIC_XPATH, "townCity");
	public static String ADDRESS_POST_CODE_XPATH = String.format(ADDRESS_BASIC_XPATH, "postcode");
	public static String YOUR_POSIRION_XPATH = String.format(REGISTRATION_PAGE_SECURE_PORTAL_BASIC_XPATH, "position");
	public static String TELEPHONE_XPATH = "//input[@id='storeDetails.table.telephone']";
	public static String EXT_XPATH = String.format(REGISTRATION_PAGE_SECURE_PORTAL_BASIC_XPATH, "extension");
	public static String EMAIL_ADDRESS_XPATH = "//input[@id='register.email']";
	public static String CONFIRM_EMAIL_XPATH = "//input[@id='register.confirm.email']";
	public static String COMMENT_XPATH = "//textarea[@id='text.secureportal.register.message']";
	public static String REGISTER_BUTTON_XPATH = "//div[@class='register-form-action row']//button[normalize-space(text()='Register')]";

}
