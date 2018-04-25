package com.sarnova.cucumber;

import com.sarnova.cucumber.runners.CucumberTestsRunner;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        format={"pretty"},
        features = {"src/test/resources/features/my_account_menu_features/MyAccountMenuItems.feature"}//,
//        "src/test/resources/features/my_account_menu_features/MyAccountMenuItemsRedirects.feature"}
)

public class MyAccountMenuSuit extends CucumberTestsRunner {
}
