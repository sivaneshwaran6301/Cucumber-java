package Testing;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features= {"features"},
		dryRun = !true,
		glue= {"step"},
		monochrome = true,
		plugin = {"pretty", "junit:target/JUnitReports/report.xml",
				"json:target/JSONReports/report.json",
		"html:target/HtmlReports"},
		tags = {"@f1"}
		)

public class Testrunner extends AbstractTestNGCucumberTests  {


}
