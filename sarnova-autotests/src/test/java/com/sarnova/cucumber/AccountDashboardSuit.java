package com.sarnova.cucumber;

import com.sarnova.cucumber.runners.CucumberTestsRunner;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        format={"pretty"},
        features = {"src/test/resources/features/account_dashboard_features/LeftBarMenuItems.feature",
        "src/test/resources/features/account_dashboard_features/LeftBarMenuItemsRedirects.feature"}
)

public class AccountDashboardSuit extends CucumberTestsRunner {
}
