package acceptanceTests;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "acceptanceTests.cucumberSteps",
        features="src/test/java/features",
        monochrome = true
)
public class TestRunner {
}
