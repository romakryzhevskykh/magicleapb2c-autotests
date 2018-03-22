package com.sarnova.storefront.page_blocks;

import com.sarnova.helpers.UIComponent;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.stream.Collectors;

import static com.sarnova.storefront.page_block_elements.LoggedInHeaderRowBlockElements.*;

@Component
public class LoggedInHeaderRowBlock extends UIComponent {

    @Step("Check that user is logged in.")
    public boolean isUserLoggedIn() {
        return isDisplayed(MY_ACCOUNT_DROP_DOWM_XPATH);
    }

    @Step("Click on sign out button.")
    public void clickOnSignOutButton() {
        $(SIGN_OUT_BUTTON_XPATH).click();
    }

    @Step("Click on favorite Supply lists drop-down.")
    public void clickOnFavoriteSupplyListsDropDown() {
        click(SUPPLY_LISTS_DROP_DOWN_XPATH);
    }

    @Step("Get favorite Supply list names from Supply list drop-down.")
    public List<String> getFavoriteSupplyListsFromSupplyListsDropDown() {
        return $$(SUPPLY_LIST_NAMES_FROM_SUPPLY_LISTS_DROP_DOWN_XPATH).stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
