package com.template.cucumber.runners;

import com.template.helpers.SeleniumGridSettings;
import com.template.helpers.WebDriverIstansiator;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;

@ContextConfiguration(locations = {"classpath:spring-application-context.xml"})
public class CucumberTestsRunner extends AbstractTestNGSpringContextTests {
    @Autowired WebDriverIstansiator webDriverPool;
    @Autowired SeleniumGridSettings seleniumGridSettings;
//
    private static boolean isPreconditionSet = false;
    private TestNGCucumberRunner testNGCucumberRunner;

    @Parameters("browserName")
    @BeforeTest
    public void initSuite(String browserName) throws Exception {
        if (!isPreconditionSet) {
            super.springTestContextBeforeTestClass();
            super.springTestContextPrepareTestInstance();
            webDriverPool.setDriver(seleniumGridSettings.getHubUrl(), browserName);
        }
    }

    @BeforeClass
    public void initClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass
    public void finishClass() {
        testNGCucumberRunner.finish();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownClass() throws Exception {
    }
}
