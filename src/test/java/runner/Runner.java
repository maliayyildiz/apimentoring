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
 //       tags = "@omer",
//        tags = "@mahmut",
//        tags = "@berati",
//        tags = "@baris",
//        tags = "@leyla",
//        tags = "@mali",
        //tags = "@countryUpdate"
       tags = "@ReaderOfCountries",//tcO1,tc02,tc03,tc04,tc05,loginemployeeAndus10 //tc06,tc07,tc08,tc09, logincustomerAndus15
//        tags = "@US11",
//        tags = "@tugba",
//        tags = "@deniz",
//        tags = "@fatih",
//        tags = "@US_03",
//        tags = "@US_13",
//        tags = "@US17",
        dryRun = false,
        monochrome  = true
)
public class Runner {
}
