package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;

@CucumberOptions(features = {"src/test/resources"}
        ,glue = {"stepDefinition", "utilities"}
        ,tags = ("@Regression and not @SITOnly and not @RunOnce") //("and @FERegression @THOR-24 or @THOR-25 and @THOR-48 and not @STOnly and not @RunOnce")
        ,plugin = {"pretty","html:test-output/DefaultReport/DefaultReport.html"
        ,"html:allure-results/cucumberReport.html"
}
)
public class TestRunner extends AbstractTestNGCucumberTests {
//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }

    @BeforeSuite
    public static void decryptData() {
        try {
            Process p = Runtime.getRuntime().exec("java -jar ./DecryptorTool.jar Tickets.json"); //Decrypt data file
            p.waitFor();
            // Need to repeat this command in case of multiple files
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterSuite
    public static void deleteDecryptedFiles() {
        try {
            //            File temp = new File("src/test/resources/temp/");
            File temp = new File("temp/");
//            FileUtils.deleteDirectory(temp);
//            Runtime.getRuntime().exec("rmdir /s /q ./src/test/resources/temp");
            Runtime.getRuntime().exec("rmdir /s /q ./temp");
            //No need to repeat it
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}