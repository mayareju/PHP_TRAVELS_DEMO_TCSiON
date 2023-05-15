package test.runner.phpteavels;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		//features="src\\test\\resources\\Features",
	features="src/test/resources/Features/5Login.feature",
		glue="stepDefinitions",
		dryRun=false,
		monochrome=true,
		plugin= {"pretty","html:target/test-output/report.html",
				"json:target/test-output/report.json","junit:target/test-output/report.xml"}
		
		
		)
public class TestRunner {

}
