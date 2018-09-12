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
}