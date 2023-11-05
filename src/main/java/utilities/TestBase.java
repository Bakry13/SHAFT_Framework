package utilities;

import com.shaft.driver.DriverFactory;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.exception.JsonPathException;
import io.restassured.response.Response;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;



public class TestBase {
    static Actions actions;
    //=========================FE variables=============================
    static WebDriver driver;
    static String testEnvironment = "ST";
    static String environmentURL = "https://digital-enterprise-services-test.de/incident-tracker/";
    static String language = "English";
    static int languageIndex = 0;

    //=========================API variables============================
    static String baseURL = "https://digital-enterprise-services-test.de/api/tt";
    static Response response;
    static String token;

    static String authorization;
    static Integer apiLanguageIndex = 0;
//=====================================Get FE Environment Properties==================================
    public WebDriver getDriver()
    {
        return driver;
    }

    public static String getTestEnvironment()
    {
        return testEnvironment;
    }

    public String getEnvironmentURL()
    {
        return environmentURL;
    }

    public String getLanguage()
    {
        return language;
    }

    public int getLanguageIndex()
    {
        return languageIndex;
    }
//=====================================Set FE Environment Properties==================================
    public void setDriver()
    {
        driver = DriverFactory.getDriver();
    }

    public void setLanguage(String languageValue)
    {
        language =  languageValue;
    }

    public void setLanguageIndex(int languageIndexValue)
    {
        languageIndex = languageIndexValue;
    }
//=====================================Get API Environment Properties=================
    public static String getBaseURL()
    {
        return baseURL;
    }

    public static Response getResponse()
    {
        return response;
    }

    public static String getToken()
    {
        return token;
    }

    public static String getAuthorization()
    {
        return authorization;
    }

    public static int getApiLanguageIndex()
    {
        return apiLanguageIndex;
    }
//===================================Set API Environment Properties===================
    public static void setResponse(Response responseValue)
    {
        response = responseValue;
    }

    public static void setToken(String tokenValue)
    {
        token = tokenValue;
    }

    public static void setAuthorization(String authorizationValue)
    {
        authorization = authorizationValue;
    }

    public static void setApiLanguageIndex(int apiLanguageIndexValue)
    {
        apiLanguageIndex = apiLanguageIndexValue;
    }
//===================================API Actions=================================
    /**
     * @param response         Response from API Request.
     * @param responseJsonPath JSON responseJsonPath to retrieve the desired value.
     * @return Return the value from JSON Path provided.
     */
    public static String getValueFromJSONResponse(Response response, String responseJsonPath) {
        String result = "null";
        try {
            String jsonString = response.getBody().asString();
            result = JsonPath.from(jsonString).get(responseJsonPath).toString();
        } catch (Exception ignored) {}
        return result;
    }
}
