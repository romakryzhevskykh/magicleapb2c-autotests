package com.sarnova.cucumber;

import com.sarnova.cucumber.runners.CucumberTestsRunner;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        format={"pretty"},
        features = "src/test/resources/features/user_management_features/instances_creation_features/Users_Creation.feature"
)

public class UserManagementSuite extends CucumberTestsRunner {
}
