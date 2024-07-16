package utils;

import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.Base;
import cucumber.api.java.Before;

public class Report extends Base {
	public static ExtentReports report;
	public static ExtentTest Test;
	public static Properties prop;
	@Before
	public static ExtentReports report() {
		prop = new Properties();
		if(report==null) {
			ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter("./report.html");
			report = new ExtentReports();
			report.attachReporter(htmlreporter);

			//Setting informations in the report
			htmlreporter.config().setDocumentTitle("cucumber automation");
			htmlreporter.config().setTimeStampFormat("dd MM YYYY, HH:mm:ss ");
		}
		return report;
	}
}
