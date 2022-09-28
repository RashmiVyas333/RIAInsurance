package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/resources/Feature"}, glue = {"Steps"},
        plugin = {"pretty", "html:target/cucumber-reports"}, monochrome = true)

public class CucumberTestNGRunner extends AbstractTestNGCucumberTests {

}