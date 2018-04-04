package com.sarnova.storefront.pages;

import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.sarnova.storefront.page_elements.UsersManagementPageElements.ADD_NEW_USER_BUTTON_XPATH;

@Component
public class UsersPage extends StorefrontBasePage {

    private String pageUrlMethod = "boundtree/en/USD/my-company/organization-management/manage-users/";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }

    @Step("Click on Add new user button.")
    public void clickOnAddNewUser() {
        click(ADD_NEW_USER_BUTTON_XPATH);
    }

}
