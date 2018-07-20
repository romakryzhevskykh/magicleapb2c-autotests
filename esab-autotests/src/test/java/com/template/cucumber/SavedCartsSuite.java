package com.template.cucumber;

import com.template.cucumber.runners.CucumberTestsRunner;
import cucumber.api.CucumberOptions;

@CucumberOptions(
		format = { "pretty" }, 
		features = "src/test/resources/features/saved_carts_features"
		)

public class SavedCartsSuite extends CucumberTestsRunner {

}
