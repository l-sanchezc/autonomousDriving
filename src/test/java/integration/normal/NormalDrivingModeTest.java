package integration.normal;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty"}, features = {"src/test/resources/integration/NormalDrivingMode.feature"})
public class NormalDrivingModeTest {
}
