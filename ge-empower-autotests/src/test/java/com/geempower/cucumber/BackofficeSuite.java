package com.geempower.cucumber;

import com.geempower.cucumber.runners.CucumberTestsRunner;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        format = {"pretty"},
        features = {
                "src/test/resources/features/Backoffice.feature"}
)
public class BackofficeSuite extends CucumberTestsRunner {
}
