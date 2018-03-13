package com.sarnova.cucumber;

import com.sarnova.cucumber.runners.CucumberTestsRunner;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        format={"pretty"},
        features = "src/test/resources/features/cart_features/Cart_Page_Add_To_Supply_List.feature"
)
public class AddToSupplyListFromCartSuit extends CucumberTestsRunner {
}
