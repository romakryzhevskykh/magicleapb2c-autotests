package com.geempower.hybris.hac.pages;

import com.geempower.hybris.hac.HACBasePage;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.hybris.hac.page_elements.HacMainPageElements.*;

@Component
public class HacMainPage extends HACBasePage {

    @Override
    public String getPageUrl() {
        return templateHAC.getBaseUrl();
    }

    @Step("Admin opens configuration section.")
    public void openConfigurationSection() {
        waitUntilPageIsFullyLoaded();
        click(PLATFORM_SECTION_XPATH);
        waitUntilPageIsFullyLoaded();
        click(CONFIGURATION_SUB_SECTION_XPATH);
    }
}
