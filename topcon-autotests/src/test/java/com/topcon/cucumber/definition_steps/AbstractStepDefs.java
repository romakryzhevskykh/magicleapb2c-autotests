package com.topcon.cucumber.definition_steps;

import com.topcon.helpers.ThreadVarsHashMap;
import com.topcon.helpers.user_engine.UserSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = {"classpath:spring-application-context.xml"})
public abstract class AbstractStepDefs {
    @Autowired protected UserSessions userSessions;
    @Autowired protected ThreadVarsHashMap threadVarsHashMap;
}
