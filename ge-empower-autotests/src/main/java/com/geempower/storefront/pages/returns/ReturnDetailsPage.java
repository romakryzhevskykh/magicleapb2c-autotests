package com.geempower.storefront.pages.returns;

import com.geempower.storefront.StorefrontBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.stream.Stream;

import static com.geempower.storefront.page_elements.returns.ReturnDetailsPageElements.*;

@Component
public class ReturnDetailsPage extends StorefrontBasePage {
    private final String pageUri = "return/";

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl().concat(pageUri);
    }

    @Step("Return Details page is opened.")
    public boolean isOpened(String caseNo){
        return getCurrentUrl().contains(pageUri) && getCurrentUrl().endsWith(caseNo);
    }

    @Step("Click On Comments Tab")
    public void clickOnCommentsTab() {
        click(COMMENTS_TAB_XPATH);
    }

    @Step("Click On Add Comment Button.")
    public void clickOnAddCommentButton() {
        waitUntilPageIsFullyLoaded();
        click(ADD_COMMENT_BUTTON_XPATH);
    }

    @Step("Fill Comments Field.")
    public void fillCommentsField(String comment) {
        $(By.id(COMMENTS_FIELD_ID)).clear();
        $(By.id(COMMENTS_FIELD_ID)).sendKeys(comment);
    }

    @Step("Click On Submit Button In Comments Pop-Up.")
    public void clickOnSubmitButtonInCommentsPopUp() {
        click($(By.id(SUBMIT_COMMENTS_BUTTON_ID)));
    }

    @Step("Get All Comment Titles.")
    public Stream<WebElement> getAllCommentTitles() {
        waitUntilPageIsFullyLoaded();
        return $$(ALL_COMMENT_MESSAGES_XPATH).stream();
    }

    @Step("Is Add Comments Button Disabled.")
    public boolean isAddCommentsButtonDisabled() {
        waitUntilPageIsFullyLoaded();
        return Boolean.parseBoolean($(ADD_COMMENT_BUTTON_XPATH).getAttribute("disabled"));
    }
}