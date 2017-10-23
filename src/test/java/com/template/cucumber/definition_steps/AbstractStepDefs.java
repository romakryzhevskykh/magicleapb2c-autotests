package com.template.cucumber.definition_steps;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration(locations = {"classpath:spring-application-context.xml"})
public abstract class AbstractStepDefs extends AbstractTestNGSpringContextTests {
}
