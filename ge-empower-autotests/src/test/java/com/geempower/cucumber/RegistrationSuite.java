package com.geempower.cucumber;

import com.geempower.cucumber.runners.CucumberTestsRunner;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        format = {"pretty"},
        features = "src/test/resources/features/Registration.feature"
)

public class RegistrationSuite extends CucumberTestsRunner {
}
