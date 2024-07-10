package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/alv/resources/features", glue = "StepDefinition", monochrome = true, plugin = {
                "pretty", "html:target/Reports/report.html", "junit:target/Reports/report.xml" }, tags = "@test")
public class RunCucumberTest {
}
