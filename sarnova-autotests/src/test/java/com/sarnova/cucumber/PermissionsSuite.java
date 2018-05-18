package com.sarnova.cucumber;

import com.sarnova.cucumber.runners.CucumberTestsRunner;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        format = {"pretty"},
        features = {//"src/test/resources/features/user_management_features/permissions_management_features/Supply_Lists_Permission.feature",
                //"src/test/resources/features/user_management_features/permissions_management_features/Supply_Lists_Manager_Permission.feature",
                //"src/test/resources/features/user_management_features/permissions_management_features/Manage_Custom_Categories_Permission.feature",
                //"src/test/resources/features/user_management_features/permissions_management_features/Checkout_Permission.feature",
                "src/test/resources/features/user_management_features/permissions_management_features/Saved_Carts_Permission.feature",
        }
)

public class PermissionsSuite extends CucumberTestsRunner {
}
