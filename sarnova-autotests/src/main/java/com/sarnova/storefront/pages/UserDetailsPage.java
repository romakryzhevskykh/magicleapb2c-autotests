package com.sarnova.storefront.pages;

import com.sarnova.helpers.user_engine.User;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.sarnova.storefront.page_elements.UserDetailsPageElements.*;

@Component
public class UserDetailsPage extends StorefrontBasePage {

    private String pageUrlMethod = "boundtree/en/USD/my-company/organization-management/manage-users/details?user=%s";

    @Step("Is details page opened for {0}.")
    public boolean isOpened(User user) {
        return getDecodedCurrentUrl().equalsIgnoreCase(String.format(getPageUrl(), user.getUsername()));
    }

    public void open(User user) {
        open(String.format(getPageUrl(), user.getUsername()));
    }

    @Step("Get title field text.")
    public String getTitle() {
        return $(NAME_FIELD_VALUE_XPATH).getText().replaceAll("  ", " ").split(" ")[0].trim();
    }

    @Step("Get first name field text.")
    public String getFirstName() {
        return $(NAME_FIELD_VALUE_XPATH).getText().replaceAll("  ", " ").split(" ")[0].trim();
    }

    @Step("Get last name field text.")
    public String getLastName() {
        return $(NAME_FIELD_VALUE_XPATH).getText().replaceAll("  ", " ").split(" ")[1].trim();
    }

    @Step("Get email field text.")
    public String getEmail() {
        return $(EMAIL_FIELD_VALUE_XPATH).getText().trim();
    }

    @Step("Get username field text.")
    public String getUsername() {
        return $(USERNAME_FIELD_VALUE_XPATH).getText().trim();
    }

//    @Step("Get user roles.")
//    public List<UserRole> getRoles() {
//        return Stream.of($(ROLES_FIELD_VALUE_XPATH).getText().split("\n"))
//                .map(StorefrontUserRole::getRoleByRoleName)
//                .collect(Collectors.toList());
//    }

    @Step("Click on Reset password button.")
    public void clickOnResetPasswordButton() {
        click(RESET_PASSWORD_BUTTON_XPATH);
    }

    @Step("Get user status.")
    public String getStatus() {
        return $(STATUS_FIELD_VALUE_XPATH).getText().trim();
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}
