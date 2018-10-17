package com.plhb2b.cucumber;

import com.plhb2b.cucumber.runners.CucumberTestsRunner;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        format={"pretty"},
        features = "src/test/resources/features/address_book_features/"
)

public class AddressBookSuite extends CucumberTestsRunner {
}