package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {
                "html:target/default-cucumber-reports",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml"
        },
        //plugin = "html:target\\default-cucumber-reports",//for windows
        features ="src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@smoke",
        dryRun = false
)
public class SmokeRunner {
}
