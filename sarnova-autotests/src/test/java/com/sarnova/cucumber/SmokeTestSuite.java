package com.sarnova.cucumber;

import com.sarnova.cucumber.runners.CucumberTestsRunner;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        format={"pretty"},
        tags = {"@SmokeTest"},
        features = {
        "src/test/resources/features/login_features/Login.feature",
        "src/test/resources/features/login_features/Registration.feature",
        "src/test/resources/features/my_account_menu_features/MyAccountMenuItems.feature",
        "src/test/resources/features/my_account_menu_features/MyAccountMenuItemsRedirects.feature",
        "src/test/resources/features/checkout_features/Guest_Checkout.feature",
        "src/test/resources/features/checkout_features/Logged_In_User_Checkout.feature",
        "src/test/resources/features/pdp_features/individual_pdp_features/Individual_PDP_Add_To_Cart.feature",
        "src/test/resources/features/pdp_features/individual_pdp_features/Individual_PDP_Add_To_Supply_List.feature",
        "src/test/resources/features/quick_order_features/Quick_Order_Add_To_Cart.feature",
}

)

public class SmokeTestSuite extends CucumberTestsRunner {
}
