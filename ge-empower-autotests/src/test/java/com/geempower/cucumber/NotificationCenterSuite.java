package com.geempower.cucumber;

import com.geempower.cucumber.runners.CucumberTestsRunner;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        format = {"pretty"},
        features = "src/test/resources/features/NotificationCenter.feature"
)

public class NotificationCenterSuite extends CucumberTestsRunner {
}
