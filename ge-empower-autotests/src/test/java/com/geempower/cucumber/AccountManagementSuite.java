package com.geempower.cucumber;

import com.geempower.cucumber.runners.CucumberTestsRunner;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        format = {"pretty"},
        features = {
                "src/test/resources/features/AccountManagement.feature",
                "src/test/resources/features/AccountManagementForExternalUser.feature",
                "src/test/resources/features/AccountManagementForMfgRepUser.feature"}
)
public class AccountManagementSuite extends CucumberTestsRunner {
}
