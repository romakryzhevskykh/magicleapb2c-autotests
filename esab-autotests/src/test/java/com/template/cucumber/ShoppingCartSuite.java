package com.template.cucumber;

import com.template.cucumber.runners.CucumberTestsRunner;

import cucumber.api.CucumberOptions;
@CucumberOptions(
		format = {"pretty"},
		features = "src/test/resources/features/shopping_cart_features"
		)

public class ShoppingCartSuite extends CucumberTestsRunner {

}
