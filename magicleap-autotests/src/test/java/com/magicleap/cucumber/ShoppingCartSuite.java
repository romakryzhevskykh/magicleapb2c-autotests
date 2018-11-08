package com.magicleap.cucumber;

import com.magicleap.cucumber.runners.CucumberTestsRunner;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        format={"pretty"},
        features = "src/test/resources/features/shopping_cart_features/"
)

public class ShoppingCartSuite extends CucumberTestsRunner {
}
