package com.template.cucumber.steps;

import com.codeborne.selenide.Configuration;
import com.google.common.io.Files;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.screenshot;

public class BaseSteps {

    @When("Open browser.")
    public void openBro() {
        Configuration.browser="chrome";
//        System.out.println("chrome");
    }

    @Then("Open Google.")
    public void openGoogle() {
//        System.out.println("open");
    }

    @Then("Make screen.")
    public void makeScreen() throws IOException {
        makeScreenshot();
//        System.out.println("screen");
    }

    @Attachment("Screenshot")
    private byte[] makeScreenshot() throws IOException {
        return Files.toByteArray(new File(screenshot("")));
    }
}
