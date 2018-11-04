package com.magicleap.cucumber;

import com.magicleap.cucumber.runners.CucumberTestsRunner;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        format = {"pretty"},
        features = "src/test/resources/features/account_management_features/"
)

public class AccountManagementSuite extends CucumberTestsRunner {
}
