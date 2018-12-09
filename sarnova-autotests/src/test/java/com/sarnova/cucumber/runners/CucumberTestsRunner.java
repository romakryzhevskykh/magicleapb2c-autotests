package com.sarnova.cucumber.runners;

import com.sarnova.helpers.SeleniumGridSettings;
import com.sarnova.helpers.managers.CustomCategoriesManager;
import com.sarnova.helpers.managers.SupplyListsManager;
import com.sarnova.helpers.managers.UserGroupsManager;
import com.sarnova.helpers.models.supply_lists.SupplyList;
import com.sarnova.helpers.user_engine.UserSessions;
import com.sarnova.helpers.web_engine.WebDriverSessions;
import com.sarnova.helpers.web_engine.WebDriverSetups;
import com.sarnova.helpers.web_engine.WebDriverThreadTestSetups;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;

@ContextConfiguration(locations = {"classpath:spring-application-context.xml"})
public class CucumberTestsRunner extends AbstractTestNGSpringContextTests {
    @Autowired private WebDriverSessions webDriverPool;
    @Autowired private SeleniumGridSettings seleniumGridSettings;
    @Autowired private WebDriverThreadTestSetups webDriverThreadTestSetups;

    @Autowired private SupplyListsManager supplyListsManager;
    @Autowired private UserGroupsManager userGroupsManager;
    @Autowired private UserSessions userSessions;

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
        deactivateSupplyLists();
        deleteUserGroupsForEachUser();
    }

    private void deactivateSupplyLists() {
        supplyListsManager.getTestSupplyLists()
                .stream()
                .filter(SupplyList::isActive)
                .forEach(supplyList -> supplyListsManager.deactivate(supplyList));
    }

    private void deleteUserGroupsForEachUser() {
        userSessions.getAllUserSession().forEach(userSession -> userGroupsManager.deleteAllCreatedUserGroups(userSession));
    }
}
