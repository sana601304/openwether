package testRunner;
import java.io.File;
import com.cucumber.listener.ExtentCucumberFormatter;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature/",
        glue= {"stepDef"},
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
        monochrome = true
)

public class testrunner {

    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("src/test/java/report.xml"));

    }
}
