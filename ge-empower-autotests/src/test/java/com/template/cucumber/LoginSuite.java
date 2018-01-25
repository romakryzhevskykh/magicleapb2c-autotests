package com.template.cucumber;

import com.template.cucumber.runners.CucumberTestsRunner;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        format={"pretty"},
        features = "src/test/resources/features/login_features/"
)

public class LoginSuite extends CucumberTestsRunner {
}
