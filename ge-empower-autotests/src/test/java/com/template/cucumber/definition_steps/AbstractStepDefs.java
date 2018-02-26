package com.template.cucumber.definition_steps;

import com.template.helpers.ThreadVarsHashMap;
import com.template.helpers.user_engine.UserSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = {"classpath:spring-application-context.xml"})
public abstract class AbstractStepDefs {
    @Autowired protected ThreadVarsHashMap threadVarsHashMap;
    @Autowired protected UserSessions userSessions;
}
