package com.magicleap.cucumber;

import com.magicleap.cucumber.runners.CucumberTestsRunner;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        format={"pretty"},
        features = "src/test/resources/features/login_features/"
)

public class LoginSuite extends CucumberTestsRunner {
}
