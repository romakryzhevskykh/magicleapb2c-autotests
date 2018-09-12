package com.sarnova.cucumber;

import com.sarnova.cucumber.runners.CucumberTestsRunner;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        format = {"pretty"},
        features = {
                "src/test/resources/features/user_management_features/guest_user_permissions_features/Supply_Lists_Permissions.feature",
        }
)

public class GuestUserSuit extends CucumberTestsRunner {
}
