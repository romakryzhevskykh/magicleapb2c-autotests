package com.geempower.cucumber.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Run cucumber scenarios directly from context menu.
 * 1. Change default cucumber configuration for Intellij Idea to use this class as the main class.
 * 2. Add system variables if necessary (e.g. spring profile)
 * <p>
 * todos list:
 * 1. to make idea be familiar with the listeners.
 */

public class CucumberTestNGIdeaRunner {

    private static final String ANNOTATIONS = "annotations";
    private static final String ANNOTATION_DATA = "annotationData";

    private static final String HEADLESS_TAG = "headless";
    private static final String HEADLESS_MODE_VALUE = "false";

    private static final String BROWSER_NAME = "browserName";
    private static final String BROWSER_VALUE = "chrome"; // be sure that you filled valid browser name, in other cases it'll throw Java null

    public static void main(String[] argv) throws Throwable {
        // set annotation fields with the arguments values
        setUpSuiteClass(argv);
        // run test
        run();
    }

    private static void run() {
        TestNG testNG = getConfiguredTestNG();
        testNG.run();
    }

    private static TestNG getConfiguredTestNG() {
        // Create the test xml suite for TestNG
        TestNG testNG = new TestNG();
        XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setName("Developer Suite");
        xmlSuite.setParallel(XmlSuite.DEFAULT_PARALLEL);
        XmlTest test = new XmlTest(xmlSuite);
        test.setName("Developer test");
        Map<String, String> parameters = new HashMap<>();
        parameters.put(BROWSER_NAME, BROWSER_VALUE);
        parameters.put(HEADLESS_TAG, HEADLESS_MODE_VALUE);
        test.setParameters(parameters);
        List<XmlClass> clazzes = new ArrayList<>();
        XmlClass clazz = new XmlClass(IdeaSuite.class);
        clazzes.add(clazz);
        test.setClasses(clazzes);
        List<XmlTest> tests = new ArrayList<>();
        tests.add(test);
        xmlSuite.setTests(tests);
        List<XmlSuite> suites = new ArrayList<>();
        suites.add(xmlSuite);
        testNG.setXmlSuites(suites);
        testNG.setOutputDirectory("target/test-output");
        return testNG;
    }

    private static void setUpSuiteClass(String[] args) throws Exception {
        String[] name = new String[0];
        List<String> glue = new ArrayList<>();
        String[] features = new String[1];
        String[] format = {"pretty"};
        String[] plugin = new String[0];

        // Parse input arguments
        for (int i = 0; i < args.length; i++) {
            if ("--name".equalsIgnoreCase(args[i])) {
                name = new String[1];
                name[0] = args[i + 1];
                i++;
            } else if ("--glue".equalsIgnoreCase(args[i]) && !"cucumber.api.spring".equalsIgnoreCase(args[i + 1])) {
                glue.add(args[i + 1]);
                i++;
            } else if (i == args.length - 1) {
                features[0] = args[i];
            }
        }

        String[] finalName = name;
        Annotation cucumberOptions = new CucumberOptions() {

            @Override
            public Class<? extends Annotation> annotationType() {
                return null;
            }

            @Override
            public boolean dryRun() {
                return false;
            }

            @Override
            public boolean strict() {
                return false;
            }

            @Override
            public String[] features() {
                return features;
            }

            @Override
            public String[] glue() {
                return glue.toArray(new String[0]);
            }

            @Override
            public String[] tags() {
                return new String[0];
            }

            @Override
            public String[] format() {
                return format;
            }

            @Override
            public String[] plugin() {
                return plugin;
            }

            @Override
            public boolean monochrome() {
                return false;
            }

            @Override
            public String[] name() {
                return finalName;
            }

            @Override
            public SnippetType snippets() {
                return SnippetType.UNDERSCORE;
            }


            @Override
            public String[] junit() {
                return new String[0];
            }
        };
        Method method = Class.class.getDeclaredMethod(ANNOTATION_DATA, null);
        method.setAccessible(true);
        //Since AnnotationData is a private class we cannot create a direct reference to it. We will have to
        //manage with just Object
        Object annotationData = method.invoke(IdeaSuite.class);
        //We now look for the map called "annotations" within AnnotationData object.
        Field field = annotationData.getClass().getDeclaredField(ANNOTATIONS);
        field.setAccessible(true);
        Field annotations = annotationData.getClass().getDeclaredField(ANNOTATIONS);
        annotations.setAccessible(true);
        Map<Class<? extends Annotation>, Annotation> map =
                (Map<Class<? extends Annotation>, Annotation>) annotations.get(annotationData);
        map.put(CucumberOptions.class, cucumberOptions);
    }

    @CucumberOptions(
    )
    class IdeaSuite extends CucumberTestsRunner {
    }
}
