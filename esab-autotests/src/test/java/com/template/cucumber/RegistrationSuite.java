package com.template.cucumber;

import com.template.cucumber.runners.CucumberTestsRunner;
import cucumber.api.CucumberOptions;

@CucumberOptions(
		format = {"pretty"},
		features = "src/test/resources/features/registrationFrontoffice_features/"
		)

public class RegistrationSuite extends CucumberTestsRunner {

}
