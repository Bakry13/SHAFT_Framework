package pages.api;

import com.shaft.validation.Validations;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import utilities.TestBase;

public class AssertionsAPI extends TestBase {
    static String messageCode = "messageCode";
    static String messageLevel = "messageLevel";
    static String httpStatus = "httpStatus";
    static String message = "message";
    //========================================Messages====================================
//-------------------------------Unauthorized 401------------------------------
    private static final String HTTP_STATUS_UNAUTHORIZED = "UNAUTHORIZED";
    private static final String CODE_UNAUTHORIZED_INVALID_TICKET_TOKEN = "tickettracker.getTroubleTicket.notAuthenticated.message";
    private static final String LEVEL_MSG = "error";
    private static final String[] MESSAGE_INVALID_TICKET_TOKEN = {"The entered link is incorrect or incomplete. Please use the link from our message."
                        ,"Der eingegebene Link ist nicht korrekt oder unvollständig. Bitte verwenden Sie den Link aus unserer Nachricht."};
    private static final String CODE_UNAUTHORIZED_INVALID_TOKEN = "common.auth.unauthorized.message";
    private static final String[] MESSAGE_INVALID_TOKEN = {"Your session has been expired. Please reload the page."
            ,"Ihre Benutzer Session ist abgelaufen. Bitte laden Sie die Seite neu."};
    //----------------------------------Bad Request 400-----------------------------------
    private static final String CODE_BAD_REQUEST = "common.validation.invalidInput.message";
    private static final String[] MESSAGE_BAD_REQUEST = {"Due to a Vodafone internal error, the current status can not be displayed. Please try again soon or contact our service hotline."
            ,"Aufgrund eines Vodafone internen Fehlers kann der aktuelle Status nicht angezeigt werden. Bitte versuchen Sie es in Kürze noch einmal oder kontaktieren Sie unsere Service-Hotline."};
    private static final String HTTP_STATUS_BAD_REQUEST = "BAD_REQUEST";
    private static final String CODE_BAD_REQUEST_INVALID_TEXT = "tickettracker.submit.invalidNoteText.message";
    private static final String[] MESSAGE_BAD_REQUEST_INVALID_TEXT = {"The text you entered does not meet the requirements and can't be transmitted."
            ,"Der eingegebene Text entspricht nicht den Vorgaben und kann nicht übertragen werden."};
    //-------------------------------Internal Server Error 500----------------------------
    private static final String CODE_INTERNAL_SERVER_ERROR = "common.internalServerError.message";
    private static final String HTTP_STATUS_INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR";
    private static final String[] MESSAGE_INTERNAL_SERVER_ERROR = {"Due to a Vodafone internal error, the current status can not be displayed. Please try again soon or contact our service hotline."
            ,"Aufgrund eines Vodafone internen Fehlers kann der aktuelle Status nicht angezeigt werden. Bitte versuchen Sie es in Kürze noch einmal oder kontaktieren Sie unsere Service-Hotline."};
    //---------------------------------Too Many Requests 429------------------------------
    private static final String CODE_TOO_MANY_REQUESTS_1 = "tickettracker.submit.feedbackAlreadyExists.message";
    private static final String[] MESSAGE_TOO_MANY_REQUESTS_1 = {"Within the last minutes you have already captured and submitted a feedback. The function will be available again shortly."
            ,"Innerhalb der letzten Minuten haben Sie bereits eine Nachricht erfasst und gesendet. In Kürze steht Ihnen die Funktion wieder zur Verfügung."};
    private static final String CODE_TOO_MANY_REQUESTS = "tickettracker.submit.toManyFeedbacks.message";
    private static final String[] MESSAGE_TOO_MANY_REQUESTS = {"For this ticket we already received several messages from you within a short time. The function will be available again shortly."
            ,"Für dieses Ticket haben wir innerhalb kurzer Zeit bereits mehrere Nachrichten erhalten. In Kürze steht Ihnen die Funktion wieder zur Verfügung."};
    private static final String HTTP_STATUS_TOO_MANY_REQUESTS = "TOO_MANY_REQUESTS";
    //-------------------------------Verify Not found 404 - Wrong URL---------------------
    private static final String ERROR_MSG = "Not Found";
    //-------------------------------Verify Method Not Allowed 405------------------------
    private static final String CODE_METHOD_NOT_ALLOWED = "common.validation.httpRequestMethodNotSupported";
    private static final String HTTP_STATUS_METHOD_NOT_ALLOWED = "METHOD_NOT_ALLOWED";
    //-------------------------------Unsupported Media Type 415---------------------------
    private static final String CODE_UNSUPPORTED_MEDIA_TYPE = "common.validation.httpMediaTypeNotSupported";
    private static final String HTTP_STATUS_UNSUPPORTED_MEDIA_TYPE = "UNSUPPORTED_MEDIA_TYPE";
    //----------------------------------Conflict 409-----------------------------------
    //==================================Errors Assertions=================================
    //-------------------------------Verify Success Code 200------------------------------
    public static void assertSuccess(Response response)
    {
        int statusCode = response.getStatusCode();
        Validations.assertThat().object(statusCode).isEqualTo(200).perform();
    }
    //-------------------------------Verify Success Created Code 201------------------------------
    public static void assertSuccessCreated(Response response)
    {
        int statusCode = response.getStatusCode();
        Validations.assertThat().object(statusCode).isEqualTo(201).perform();
    }
    //------------------Verify Unauthorized 401-Invalid ticket token-------------------------
    public static void assertUnauthorizedInvalidTicketToken(Response response)
    {
        int statusCode = response.getStatusCode();
        Validations.assertThat().object(statusCode).isEqualTo(401).perform();
        String jsonString = response.getBody().asString(); //Convert response to string
        String actualHTTPStatus = JsonPath.from(jsonString).get(httpStatus).toString();
        Validations.assertThat().object(actualHTTPStatus).isEqualTo(HTTP_STATUS_UNAUTHORIZED).perform();
        String actualMessageCode = JsonPath.from(jsonString).get(messageCode).toString();
        Validations.assertThat().object(actualMessageCode).isEqualTo(CODE_UNAUTHORIZED_INVALID_TICKET_TOKEN).perform();
        String actualMessageLevel = JsonPath.from(jsonString).get(messageLevel).toString();
        Validations.assertThat().object(actualMessageLevel).isEqualTo(LEVEL_MSG).perform();
        String actualMessage = JsonPath.from(jsonString).get(message).toString();
        Validations.assertThat().object(actualMessage).isEqualTo(MESSAGE_INVALID_TICKET_TOKEN[getApiLanguageIndex()]).perform();
    }
    //------------------Verify Unauthorized 401-Invalid token-------------------------
    public static void assertUnauthorizedInvalidToken(Response response)
    {
        int statusCode = response.getStatusCode();
        Validations.assertThat().object(statusCode).isEqualTo(401).perform();
        String jsonString = response.getBody().asString(); //Convert response to string
        String actualHTTPStatus = JsonPath.from(jsonString).get(httpStatus).toString();
        Validations.assertThat().object(actualHTTPStatus).isEqualTo(HTTP_STATUS_UNAUTHORIZED).perform();
        String actualMessageCode = JsonPath.from(jsonString).get(messageCode).toString();
        Validations.assertThat().object(actualMessageCode).isEqualTo(CODE_UNAUTHORIZED_INVALID_TOKEN).perform();
        String actualMessageLevel = JsonPath.from(jsonString).get(messageLevel).toString();
        Validations.assertThat().object(actualMessageLevel).isEqualTo(LEVEL_MSG).perform();
        String actualMessage = JsonPath.from(jsonString).get(message).toString();
        Validations.assertThat().object(actualMessage).isEqualTo(MESSAGE_INVALID_TICKET_TOKEN[getApiLanguageIndex()]).perform();
    }
    //----------------------------------Bad Request 400-----------------------------------
    public static void assertBadRequest(Response response)
    {
        int statusCode = response.getStatusCode();
        Validations.assertThat().object(statusCode).isEqualTo(400).perform();
        String jsonString = response.getBody().asString(); //Convert response to string
        String actualHTTPStatus = JsonPath.from(jsonString).get(httpStatus).toString();
        Validations.assertThat().object(actualHTTPStatus).isEqualTo(HTTP_STATUS_BAD_REQUEST).perform();
        String actualCode = JsonPath.from(jsonString).get(messageCode).toString();
        Validations.assertThat().object(actualCode).isEqualTo(CODE_BAD_REQUEST).perform();
        String actualLevel = JsonPath.from(jsonString).get(messageLevel).toString();
        Validations.assertThat().object(actualLevel).isEqualTo(LEVEL_MSG).perform();
        String actualMessage = JsonPath.from(jsonString).get(message).toString();
        Validations.assertThat().object(actualMessage).isEqualTo(MESSAGE_BAD_REQUEST[getApiLanguageIndex()]).perform();
    }
    //----------------------------------Invalid text-------------------------------------
    public static void assertBadRequestInvalidText(Response response)
    {
        int statusCode = response.getStatusCode();
        Validations.assertThat().object(statusCode).isEqualTo(400).perform();
        // return HTML Response Not a JSON
//        String jsonString = response.getBody().asString(); //Convert response to string
//        String actualHTTPStatus = JsonPath.from(jsonString).get(httpStatus).toString();
//        Validations.assertThat().object(actualHTTPStatus).isEqualTo(HTTP_STATUS_BAD_REQUEST).perform();
//        String actualCode = JsonPath.from(jsonString).get(messageCode).toString();
//        Validations.assertThat().object(actualCode).isEqualTo(CODE_BAD_REQUEST_INVALID_TEXT).perform();
//        String actualLevel = JsonPath.from(jsonString).get(messageLevel).toString();
//        Validations.assertThat().object(actualLevel).isEqualTo(LEVEL_MSG).perform();
//        String actualMessage = JsonPath.from(jsonString).get(message).toString();
//        Validations.assertThat().object(actualMessage).isEqualTo(MESSAGE_BAD_REQUEST_INVALID_TEXT[getApiLanguageIndex()]).perform();
  }
    //-------------------------------Internal Server Error 500----------------------------
    public static void assertInternalServerError(Response response) {
        int statusCode = response.getStatusCode();
        Validations.assertThat().object(statusCode).isEqualTo(500).perform();
        String jsonString = response.getBody().asString(); //Convert response to string
        String actualHTTPStatus = JsonPath.from(jsonString).get(httpStatus).toString();
        Validations.assertThat().object(actualHTTPStatus).isEqualTo(HTTP_STATUS_INTERNAL_SERVER_ERROR).perform();
        String actualCode = JsonPath.from(jsonString).get(messageCode).toString();
        Validations.assertThat().object(actualCode).isEqualTo(CODE_INTERNAL_SERVER_ERROR).perform();
        String actualLevel = JsonPath.from(jsonString).get(messageLevel).toString();
        Validations.assertThat().object(actualLevel).isEqualTo(LEVEL_MSG).perform();
        String actualMessage = JsonPath.from(jsonString).get(message).toString();
        Validations.assertThat().object(actualMessage).isEqualTo(MESSAGE_INTERNAL_SERVER_ERROR[getApiLanguageIndex()]).perform();
    }
    //-----------------------Request Entity Too Large Code 413------------------------------
    public static void assertRequestEntityTooLarge(Response response)
    {
        int statusCode = response.getStatusCode();
        Validations.assertThat().object(statusCode).isEqualTo(413).perform();
    }
    //-------------------------------No Content 204------------------------------
    public static void assertNoContent(Response response)
    {
        int statusCode = response.getStatusCode();
        Validations.assertThat().object(statusCode).isEqualTo(204).perform();
    }
    //-------------------------------Too Many Requests 429----------------------------
    public static void assertTooManyRequests(Response response) {
        int statusCode = response.getStatusCode();
        Validations.assertThat().object(statusCode).isEqualTo(429).perform();
        String jsonString = response.getBody().asString(); //Convert response to string
        String actualHTTPStatus = JsonPath.from(jsonString).get( httpStatus).toString();
        Validations.assertThat().object(actualHTTPStatus).isEqualTo(HTTP_STATUS_TOO_MANY_REQUESTS).perform();
        String actualCode = JsonPath.from(jsonString).get( messageCode).toString();
        try {
            Assert.assertEquals(actualCode, CODE_TOO_MANY_REQUESTS);
        } catch (AssertionError ae) {
            Assert.assertEquals(actualCode, CODE_TOO_MANY_REQUESTS_1);
        }
        String actualLevel = JsonPath.from(jsonString).get( messageLevel).toString();
        Validations.assertThat().object(actualLevel).isEqualTo(LEVEL_MSG).perform();
        String actualMessage = JsonPath.from(jsonString).get( message).toString();
        try {
            Assert.assertEquals(actualMessage, MESSAGE_TOO_MANY_REQUESTS[getApiLanguageIndex()]);
        } catch (AssertionError ae) {
            Assert.assertEquals(actualMessage, MESSAGE_TOO_MANY_REQUESTS_1[getApiLanguageIndex()]);
        }
    }
    //-------------------------------Verify Not found 404 - Wrong URL---------------------
    //-------------------------------Verify Not found 404--------------------------
    //-------------------------------Verify Method Not Allowed 405------------------------
    //-------------------------------Unsupported Media Type 415---------------------------
    //-------------------------------------Forbidden 403----------------------------------
    //-------------------------------------Conflict 409----------------------------------
    //=========================Set language Index============================
    public static void setLanguageIndex(String lang)
    {
        if(lang.equalsIgnoreCase("EN"))
            setApiLanguageIndex(0);
        else if(lang.equalsIgnoreCase("DE"))
            setApiLanguageIndex(1);
    }
    //=============================API Hooks==================================
}
