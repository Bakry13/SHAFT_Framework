package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/features/api"}
        ,glue = {"stepDefinition/api", "pages/api","utilities"}
        ,tags = ("@APIRegression") //and not @STOnly
        ,plugin = {"pretty","html:test-output/DefaultReport/DefaultReport.html"
//        ,"json:test-output/jsonReport/jsonReport.json"
        //,"junit:test-output/junitReport/xmlReport.xml"
        //,"com.cucumber.listener.ExtentCucumberFormatter:"
        ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
        //,plugin = {"pretty","html:cucumber-reports/DefaultReport.html"}
)
public class APITestRunner extends AbstractTestNGCucumberTests {
}