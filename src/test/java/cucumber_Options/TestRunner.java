package cucumber_Options;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
//**** Annotation is case sensitive 
//**** glue contains step definition package name 
@CucumberOptions(features="src/test/java/features",glue={"step_definitions"},plugin="json:target/JsonReports/Cucumber-report.json",tags={"@DeletePlace"})
//plugin="JSON:target/JsonReports/Cucumber-report.json",
public class TestRunner {

}
