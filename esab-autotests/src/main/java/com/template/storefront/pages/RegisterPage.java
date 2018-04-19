package com.template.storefront.pages;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import com.template.storefront.page_elements.RegisterPageElements.*;

import ru.yandex.qatools.allure.annotations.Step;

@Component
public class RegisterPage extends StorefrontBasePage {
	
	final static Logger logger = Logger.getLogger(RegisterPage.class);
	private String pageUrlMethod = "/esab/en/register";

	@Override
	public String getPageUrl() {
		String registerPageUrl = storefrontProject.getBaseUrl() + pageUrlMethod;
		logger.info("Register page URL: " + registerPageUrl);
		return registerPageUrl;
	}
	
	@Step("Verify current page is Register page.")
	public boolean isCurrentUrlIsRegisterPageUrl(){
		return getPageUrl().equals(getCurrentUrl());
	}

}
