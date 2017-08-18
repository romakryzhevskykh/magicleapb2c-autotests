package com.template.cucumber.steps;

import com.template.helpers.webengine.Browser;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;


public class BaseSteps {
    Browser browser;

    @When("Open browser.")
    public void openBro() {
        browser = Browser.createNewInstance("firefox");
//        System.out.println("chrome");
    }

    @Then("Open Google.")
    public void openGoogle() {
        browser.openUrl("http://google.com");
//        System.out.println("open");
    }

    @Then("Make screen.")
    public void makeScreen() throws IOException {
//        makeScreenshot();
//        System.out.println("screen");
    }

//    @Attachment("Screenshot")
//    private byte[] makeScreenshot() throws IOException {
//        return Files.toByteArray(new File(screenshot("")));
//    }
}
