package com.template.cucumber;

import com.template.cucumber.runners.CucumberTestsRunner;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/login_features/"
)

//@ContextConfiguration(locations = {"classpath:spring-application-context.xml"})
public class LoginSuite extends CucumberTestsRunner {

//    @Autowired WebDriver driver;
//
//    @After
//    public void onFailure(Scenario scenario) {
//        System.out.println(driver);
//        if (scenario.isFailed()) {
//            captureScreenshot();
//        }
//    }
//
//    @Attachment("Screenshot")
//    private byte[] captureScreenshot() {
//        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//    }
}
