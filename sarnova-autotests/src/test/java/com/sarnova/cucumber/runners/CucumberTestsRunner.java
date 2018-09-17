package com.sarnova.cucumber.runners;

import com.sarnova.helpers.SeleniumGridSettings;
import com.sarnova.helpers.managers.CustomCategoriesManager;
import com.sarnova.helpers.managers.SupplyListsManager;
import com.sarnova.helpers.managers.UserGroupsManager;
import com.sarnova.helpers.models.supply_lists.SupplyList;
import com.sarnova.helpers.user_engine.StorefrontUserRole;
import com.sarnova.helpers.user_engine.UserSessions;
import com.sarnova.helpers.user_engine.UsersManager;
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
    @Autowired WebDriverSessions webDriverPool;
    @Autowired SeleniumGridSettings seleniumGridSettings;
    @Autowired WebDriverThreadTestSetups webDriverThreadTestSetups;

    @Autowired SupplyListsManager supplyListsManager;
    @Autowired UserGroupsManager userGroupsManager;
    @Autowired UsersManager usersManager;
    @Autowired UserSessions userSessions;
    @Autowired CustomCategoriesManager customCategoriesManager;

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
        supplyListsManager.getTestSupplyLists()
                .stream()
                .filter(SupplyList::isActive)
                .forEach(supplyList -> supplyListsManager.deactivate(supplyList));
        customCategoriesManager.deleteAllCustomCategories();
        userGroupsManager.deleteAllCreatedUserGroups(userSessions.getAnyUserSessionForUser(usersManager.getUsers()
                .stream()
                .filter(user -> user.getUserRoles().contains(StorefrontUserRole.ADMIN))
                .findAny().get()));
    }
}
