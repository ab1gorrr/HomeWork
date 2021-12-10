package testCases.lesson12.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty",features = "src\\test\\resources\\cucumber.lesson12.cartAction")
public class CucumberSuite {
}
