package com.geempower.cucumber.definition_steps;

import com.geempower.helpers.ThreadVarsHashMap;
import com.geempower.helpers.models.Region;
import com.geempower.helpers.user_engine.UserSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;

@ContextConfiguration(locations = {"classpath:spring-application-context.xml"})
public abstract class AbstractStepDefs {
    @Autowired protected ThreadVarsHashMap threadVarsHashMap;
    @Autowired protected UserSessions userSessions;

    @SuppressWarnings("unchecked")
    protected ArrayList<Region> getChosenRegions() {
        ArrayList<Region> regions = null;
        if (threadVarsHashMap.get(TestKeyword.CHOSEN_REGION) == null) {
            regions = new ArrayList<>();
            threadVarsHashMap.put(TestKeyword.CHOSEN_REGION, regions);
        } else {
            regions = (ArrayList<Region>) threadVarsHashMap.get(TestKeyword.CHOSEN_REGION);
        }
        return regions;
    }
}
