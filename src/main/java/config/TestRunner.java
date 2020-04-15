package config;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"@test"},
        plugin = {"json:build/report/cucumber.json"},
        features = {"src/main/resources/features"},
        glue = "stepDefs")
public class TestRunner {
}