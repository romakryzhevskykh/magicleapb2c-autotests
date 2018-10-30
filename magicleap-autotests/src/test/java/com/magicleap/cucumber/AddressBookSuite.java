package com.magicleap.cucumber;

import com.magicleap.cucumber.runners.CucumberTestsRunner;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        format={"pretty"},
        features = "src/test/resources/features/address_book_features/"
)

public class AddressBookSuite extends CucumberTestsRunner {
}