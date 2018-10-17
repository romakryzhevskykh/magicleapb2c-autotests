package com.plhb2b.cucumber.runners;

import com.plhb2b.helpers.SeleniumGridSettings;
import com.plhb2b.helpers.web_engine.WebDriverSessions;
import com.plhb2b.helpers.web_engine.WebDriverSetups;
import com.plhb2b.helpers.web_engine.WebDriverThreadTestSetups;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;

@ContextConfiguration(locations = {"classpath:spring-application-context.xml"})
public class CucumberTestsRunner extends AbstractTestNGSpringContextTests {
    @Autowired WebDriverSessions webDriverPool;
    @Autowired SeleniumGridSettings seleniumGridSettings;
    @Autowired WebDriverThreadTestSetups webDriverThreadTestSetups;

    private TestNGCucumberRunner testNGCucumberRunner;

    @Parameters({"browserName", "headless"})
    @BeforeTest
    public void initSuite(String browserName, String headless) throws Exception {
        super.springTestContextBeforeTestClass();
        super.springTestContextPrepareTestInstance();
        webDriverThreadTestSetups.setTlDriverSetups(new WebDriverSetups(seleniumGridSettings.getHubUrl(), browserName, headless));
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

    @AfterTest
    public void finishTestSuit() {
        webDriverPool.dismissAll();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownClass() throws Exception {
    }
}
