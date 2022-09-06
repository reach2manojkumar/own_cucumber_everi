package com.everi.utilities;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;


public class ReportGeneration {

	public static void reportGeneration(String jsonreport) {
		//new file path 
		File reportFile=new File(System.getProperty("user.dir")+"\\report.com\\JVMreport");
		
		//report Detail
		Configuration reportConfig=new Configuration(reportFile,"Everi Entegrity");
		reportConfig.addClassifications("PlatForm","Windows 11");
		reportConfig.addClassifications("JDK VERSION","V1.8");
		reportConfig.addClassifications("Report Generation", "Cucumber");
		
		//Add JSON file input
		List<String> reportList=new ArrayList<String>();
		reportList.add(jsonreport);
		
		//Report Generation
		ReportBuilder finalReport=new ReportBuilder(reportList, reportConfig);
		finalReport.generateReports();
	}
	
	

	
}
