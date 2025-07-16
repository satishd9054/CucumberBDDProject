package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)

@CucumberOptions(features = {".//Features//LoginFeature.feature", ".//Features//AddCustomer.feature"},
glue = "StepDefinition", // glue= Find the step
// definition files(Java
// methods) for the feature
// files
		dryRun = false, // dryRun= To map Feature file to stepDefination file.
// dryRun = true → Cucumber checks if all steps in the feature file have
// matching step definitions (but does NOT run the tests). //dryRun = false →
// Cucumber will run the full test normally.

		monochrome = true, // for output readability
// plugin = {"pretty","junit:Reports/cucumber-reports/xml.xml"}
// plugin = {"pretty","json:Reports/cucumber-reports/reports_json1.json"}
		tags = "@sanity",
		//plugin = { "pretty", "html:Reports/cucumber-reports/reports_html1.html" } // To generate reports
				plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }
		
)
public class Run extends AbstractTestNGCucumberTests{

}
