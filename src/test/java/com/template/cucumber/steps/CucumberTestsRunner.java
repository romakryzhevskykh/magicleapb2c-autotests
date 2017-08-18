package com.template.cucumber.steps;

import com.template.helpers.Logging;
import com.template.helpers.Utils;
import com.template.site.TemplateProjectSettings;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

@CucumberOptions(
        features = "src/test/resources/features/")

@ContextConfiguration(locations = {"classpath:spring-test-config.xml"})
public class CucumberTestsRunner extends AbstractTestNGSpringContextTests {
    private TestNGCucumberRunner testNGCucumberRunner;
    @Autowired public TemplateProjectSettings templateProjectSettings;

    //logging fields
    protected static Logging log = Logging.getLogging();
    protected static Logging failsLog = Logging.getFailsLogging();
    private final static int intervalBetweenMethodsLogging = 2;
    private final String START_TEST_MESSAGE = "START --%s--";
    private final String END_FAILED_TEST_MESSAGE = "END --%s-- FAILED\n\n";
    private final String END_PASSED_TEST_MESSAGE = "END --%s-- PASSED\n\n";
    private static int FAIL_COUNT = 0;
    private static int PASS_COUNT = 0;
    private static int PROJECT_FAILS = 0;
    private static int PROJECT_PASSES = 0;

    private static boolean isPreconditionsCreated = false;

    @BeforeSuite
    public void setUpClass() throws Exception {
        if (!isPreconditionsCreated) {
            testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
            //create Logs folder if it is not present
            Utils.createFolder(Logging.FOLDER_WITH_LOGS);
            //delete all files from folder with logs
            File logsFolder = new File(Utils.getPathInsideProject(Logging.FOLDER_WITH_LOGS));
            FileUtils.cleanDirectory(logsFolder);
            isPreconditionsCreated = true;
        }
    }

    @BeforeSuite(alwaysRun = true)
    public void startLogging() {
        log.writeLog("Start tests\n");
    }

    @Before
    public void startTestLog(Scenario scenario) {
        failsLog.clearMessagesBuffer();
        failsLog.writeAssertLog("No assert information about failed test!");
        log.writeLog(String.format(START_TEST_MESSAGE, scenario.getName()), intervalBetweenMethodsLogging);
    }

    @Test(dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        System.out.println(templateProjectSettings);
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @After
    public void endTestLog(Scenario scenario) throws Exception {
        String name = scenario.getName();
        if (!scenario.isFailed()) {
            PASS_COUNT++;
            log.writeLog(String.format(END_PASSED_TEST_MESSAGE, name));
        } else {
            FAIL_COUNT++;
            log.writeLog(failsLog.getAssertFailMessage());
            log.writeLog(String.format(END_FAILED_TEST_MESSAGE, name));
            failsLog.writeLog(log.getMessages());
        }
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }

    @AfterSuite(alwaysRun = true)
    public void endSuiteLog() {
        log.writeLog("End of log. Passed tests: " + PASS_COUNT + "; Failures: " + FAIL_COUNT, intervalBetweenMethodsLogging);
        PROJECT_PASSES += PASS_COUNT;
        PROJECT_FAILS += FAIL_COUNT;
        PASS_COUNT = 0;
        FAIL_COUNT = 0;
        log.writeLog("Passed general project tests: " + PROJECT_PASSES + "; Failures: " + PROJECT_FAILS + "\n\n");
    }
}
