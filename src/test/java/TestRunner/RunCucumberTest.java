package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Resources/Features", glue = "StepDefinitions", monochrome = true, plugin = {
        "pretty", "html:target/Reports/HTML_Report.html",
        "junit:target/Reports/JUnit_Report.xml" }, tags = "not @WIP and @HotelTest")
public class RunCucumberTest {
}
