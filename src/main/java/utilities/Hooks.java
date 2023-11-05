package utilities;

import com.shaft.gui.browser.BrowserActions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends TestBase {
    BrowserActions browserActions = new BrowserActions();
    //=========================To write test environment in the report===================
    @Before
    public void setTestEnvironmentProperties() {
        testEnvironment = System.getProperty("environment");

        if (getTestEnvironment().equals("ST"))
        {
            environmentURL = System.getProperty("STURL");
            baseURL = System.getProperty("STURL_API");
        }
        else if (getTestEnvironment().equals("SIT"))
        {
            environmentURL = System.getProperty("SITURL");
            baseURL = System.getProperty("SITURL_API");
        }
    }

    @Before(order = 0, value = "@FERegression")
    public void setFEEnvironmentProperties() {
        setDriver();

        language = System.getProperty("language");

        if (getLanguage().equals("English"))
        {
            languageIndex = 0;
        }
        else if (getLanguage().equals("Deutsch"))
        {
            languageIndex = 1;
        }
    }

    @After(order = 10, value = "@FERegression")
    public void closeBrowser() {
        browserActions.closeCurrentWindow();
    }

    //===========================To attach screenshots in the extent report======================
    @After(order = 11, value = "@FERegression")
    public void takeScreenshot(Scenario scenario) {
        byte[] src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
        //scenario.embed(src,"image/png");
        scenario.attach(src,"image/png", scenario.getName()+ ".png" );
    }
}