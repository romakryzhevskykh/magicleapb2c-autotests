package com.template.cucumber.runners;

import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;

@ContextConfiguration(locations = {"classpath:spring-application-context.xml"})
public class CucumberTestsRunner extends AbstractTestNGSpringContextTests {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeSuite
    public void initSuite() throws Exception {
        super.springTestContextBeforeTestClass();
        super.springTestContextPrepareTestInstance();
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
