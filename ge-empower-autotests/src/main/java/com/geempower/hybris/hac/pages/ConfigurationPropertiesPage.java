package com.geempower.hybris.hac.pages;

import com.geempower.hybris.hac.HACBasePage;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.hybris.hac.page_elements.ConfigurationPropertiesPageElements.*;

@Component
public class ConfigurationPropertiesPage extends HACBasePage {
    private final String URI = "/platform/config";

    @Override
    public boolean isOpened() {
        return getCurrentUrl().contains(URI);
    }

    @Override
    public String getPageUrl() {
        return templateHAC.getBaseUrl().concat(URI);
    }

    @Step("Search property by property name.")
    public void searchPropertyByPropertyName(String propertyName) {
        waitUntilPageIsFullyLoaded();
        $(SEARCH_PROPERTY_INPUT_XPATH).clear();
        $(SEARCH_PROPERTY_INPUT_XPATH).sendKeys(propertyName);
    }

    @Step("Set new property value.")
    public void setNewPropertyValue(String newPropertyValue) {
        waitUntilPageIsFullyLoaded();
        if (!$(LESSONLY_ENABLED_PROPERTY_VALUE_FIELD_XPATH).getAttribute("value").equals("true")) {
            $(LESSONLY_ENABLED_PROPERTY_VALUE_FIELD_XPATH).clear();
            $(LESSONLY_ENABLED_PROPERTY_VALUE_FIELD_XPATH).sendKeys(newPropertyValue);
            waitUntilPageIsFullyLoaded();
            click(SAVE_NEW_PROPERTY_VALUE_BUTTON_XPATH);
        }
    }
}
