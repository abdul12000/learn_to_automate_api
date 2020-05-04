package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/featureFiles/", plugin = {"html:/target/ReportsDestination", "pretty"}, tags = {"@TestToRun"}, glue = {"stepDefinitions"} )
public class TestRunner {
}
