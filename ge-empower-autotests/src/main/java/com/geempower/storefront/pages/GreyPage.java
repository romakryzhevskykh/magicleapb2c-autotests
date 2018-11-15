package com.geempower.storefront.pages;

import com.geempower.storefront.StorefrontBasePage;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.geempower.storefront.page_elements.GreyPageElements.*;

@Component
public class GreyPage extends StorefrontBasePage {
    private final String pageUri = "register/mfgUserNotActive";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Override
    public boolean isOpened() {
        waitUntilPageIsFullyLoaded();
        return getCurrentUrl().equals(getPageUrl());
    }

    @Step("Get Hello message.")
    public String getHelloMessage() {
        waitUntilPageIsFullyLoaded();
        return $(HELLO_MESSAGE_XPATH).getText();
    }

    @Step("Get Change Role And Relationship Header.")
    public String getChangeRoleAndRelationshipHeader() {
        return getTextNode(CHANGE_ROLE_RELATIONSHIP_SECTION_HEADER_XPATH);
    }

    @Step("Get Relationship Label.")
    public String getRelationshipLabel() {
        return $(CHANGE_RELATIONSHIP_LABEL_XPATH).getText();
    }

    @Step("Get Role Label.")
    public String getRoleLabel() {
        return $(CHANGE_ROLE_LABEL_XPATH).getText();
    }

    @Step("Get Footer Title Item2.")
    public String getFooterTitleItem2() {
        return $(FOOTER_TITLE_ITEM2_XPATH).getText();
    }

    @Step("Get Footer Title Item1.")
    public String getFooterTitleItem1() {
        return $(FOOTER_TITLE_ITEM1_XPATH).getText();
    }

    @Step("Get Grey Page Footer Title.")
    public String getGreyPageFooterTitle() {
        return $(FOOTER_TITLE_XPATH).getText();
    }

    @Step("Click On Abb Logo To Activate User.")
    public void clickOnAbbLogoToActivateUser() {
        waitUntilPageIsFullyLoaded();
        click(ABB_LOGO_XPATH);
    }
}