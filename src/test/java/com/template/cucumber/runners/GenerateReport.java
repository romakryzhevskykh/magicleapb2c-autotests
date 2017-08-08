package com.template.cucumber.runners;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GenerateReport {

    public static void GenerateMasterthoughtReport() {
        try {
            String RootDir = System.getProperty("user.dir/target");
            File reportOutputDirectory = new File("target/Masterthought");
            List<String> list = new ArrayList<String>();
//            list.add("target/cucumber1.json");
//            list.add("target/cucumber2.json");

            String pluginUrlPath = "";
            String buildNumber = "1";
            String buildProject = "cucumber-jvm";
            boolean skippedFails = true;
            boolean pendingFails = true;
            boolean undefinedFails = true;
            boolean missingFails = true;
            boolean flashCharts = true;
            boolean runWithJenkins = false;
            boolean highCharts = false;
            boolean parallelTesting = true;
            boolean artifactsEnabled = false;
            String artifactConfig = "";
            Configuration configuration = new Configuration(reportOutputDirectory, "testProject");
            configuration.setBuildNumber(buildNumber);
            configuration.setParallelTesting(parallelTesting);
            configuration.setRunWithJenkins(runWithJenkins);
            configuration.setTagsToExcludeFromChart();

            ReportBuilder reportBuilder = new ReportBuilder(list, configuration);

            reportBuilder.generateReports();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
