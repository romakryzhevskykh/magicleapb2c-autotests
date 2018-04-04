package com.sarnova.storefront.pages;

import com.sarnova.helpers.user_engine.StorefrontUserRole;
import com.sarnova.helpers.user_engine.User;
import com.sarnova.helpers.user_engine.UserRole;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.sarnova.storefront.page_elements.UserDetailsPageElements.*;

@Component
public class UserDetailsPage extends StorefrontBasePage {

    private String pageUrlMethod = "boundtree/en/USD/my-company/organization-management/manage-users/details?user=%s";
    @Step("Is details page opened for {0}.")
    public boolean isOpened(User user) {
        return getDecodedCurrentUrl().equals(String.format(getPageUrl(), user.getUsername().toLowerCase()));
    }

    @Step("Get title field text.")
    public String getTitle() {
        return $(NAME_FIELD_VALUE_XPATH).getText().replaceAll("  ", " ").split(" ")[0].trim();
    }

    @Step("Get first name field text.")
    public String getFirstName() {
        return $(NAME_FIELD_VALUE_XPATH).getText().replaceAll("  ", " ").split(" ")[1].trim();
    }

    @Step("Get last name field text.")
    public String getLastName() {
        return $(NAME_FIELD_VALUE_XPATH).getText().replaceAll("  ", " ").split(" ")[2].trim();
    }

    @Step("Get email field text.")
    public String getEmail() {
        return $(EMAIL_FIELD_VALUE_XPATH).getText().trim();
    }

    @Step("Get user roles.")
    public List<UserRole> getRoles() {
        return Stream.of($(ROLES_FIELD_VALUE_XPATH).getText().split("\n"))
                .map(StorefrontUserRole::getRoleByRoleName)
                .collect(Collectors.toList());
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}
