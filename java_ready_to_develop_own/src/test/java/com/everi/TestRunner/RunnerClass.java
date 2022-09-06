package com.everi.TestRunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.everi.utilities.ReportGeneration;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\feature", glue = "com.everi.stepdefinition", 
		monochrome = true, dryRun = false, plugin = {
		"pretty", "html:report.com/HtmpReport", "junit:report.com/testrep.xml",
		"json:report.com/reporttest.json" }, tags = "@drop", publish = true)

//tag{~@tagname} ,{ @ or @},{@ and @}

public class RunnerClass {

	@AfterClass
	public static void finalReport() {
		ReportGeneration.reportGeneration(System.getProperty("user.dir") + "\\report.com\\reporttest.json");
	}
}
