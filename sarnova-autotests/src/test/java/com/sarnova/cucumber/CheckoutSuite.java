package com.sarnova.cucumber;

import com.sarnova.cucumber.runners.CucumberTestsRunner;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        format = {"pretty"},
        features = {
                "src/test/resources/features/checkout_features/License_Restricted_Pop_Up.feature",
                "src/test/resources/features/checkout_features/Logged_In_User_Checkout.feature",
                "src/test/resources/features/checkout_features/Guest_Checkout.feature",
                "src/test/resources/features/checkout_features/GuestUser_Doesnt_Have_ReplenishmentOrder_Option.feature"
        }
)
public class CheckoutSuite extends CucumberTestsRunner {
}
