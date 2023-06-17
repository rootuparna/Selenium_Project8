package CucumberTest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="Feature"
		,glue={"StepDefinitions"}
		,monochrome=true
		,dryRun=true
		)
public class TestRunner {

}
