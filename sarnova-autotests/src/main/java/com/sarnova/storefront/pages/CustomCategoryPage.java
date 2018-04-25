package com.sarnova.storefront.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.allure.annotations.Step;

import static com.sarnova.storefront.page_elements.CustomCategoryPageElements.*;

@Component
public class CustomCategoryPage extends StorefrontBasePage {

    private String pageUrlMethod = "boundtree/en/USD/custom-category";

    @Step("Is Custom categories tree visible?")
    public boolean isCustomCategoriesTreeVisible() {
        return isDisplayed(CATEGORIES_TREE_XPATH);
    }

    @Step("Is new Custom category name field visible?")
    public boolean isNewCustomCategoryNameFieldVisible() {
        return isDisplayed(By.id(NEW_CUSTOM_CATEGORY_NAME_FIELD_ID));
    }

    @Step("Is Add new Custom category button visible?")
    public boolean isAddNewCustomCategoryButtonVisible() {
        return isDisplayed(By.id(ADD_NEW_CUSTOM_CATEGORY_BUTTON_ID));
    }

    @Override
    public String getPageUrl() {
        return storefrontProject.getBaseUrl() + pageUrlMethod;
    }
}
