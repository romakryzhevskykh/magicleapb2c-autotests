package com.geempower.storefront.pages;

import com.geempower.helpers.models.RegionType;
import com.geempower.storefront.StorefrontBasePage;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;
import java.util.stream.Collectors;

import static com.geempower.helpers.models.RegionType.getRegionTypes;
import static com.geempower.storefront.page_elements.ProfilePageElements.*;

@Component
public class ProfilePage extends StorefrontBasePage {
    private final String pageUri = "my-account/profile";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        return getCurrentUrl().equals(getPageUrl());
    }

    @Step("Get Profile title.")
    public String getProfileTitle() {
        return $(PROFILE_TITLE_XPATH).getText();
    }

    @Step("Get user name from user's profile.")
    public String getUserName() {
        return $(USER_FIRST_NAME_XPATH).getText();
    }
    @Step("Get user last name from user's profile.")
    public String getUserLastName() {
        return $(USER_LAST_NAME_XPATH).getText();
    }

    @Step("Get Role For Each Region in user Profile")
    public HashMap<String, String> getRoleForEachRegion() {
        waitUntilPageIsFullyLoaded();
        HashMap<String, String> rolesForRegions = new HashMap<>();
        rolesForRegions.putAll(getRegionTypes().stream()
                .collect(Collectors.toMap(RegionType::getRegionName,
                        region -> $(USER_ROLE_IN_EACH_REGION_XPATH, region.getRegionName()).getText())));
        return rolesForRegions;
    }
}