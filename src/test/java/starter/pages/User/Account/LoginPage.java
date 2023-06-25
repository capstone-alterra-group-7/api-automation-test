package starter.pages.User.Account;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class LoginPage {
    public String endpoint = "https://capstone.hanifz.com/api/v1/login";

    @Step("I have endpoint post new login")
    public String setEndpointLogin() {
        return endpoint;
    }

    @Step("I send request to endpoint")
    public void sendRequestLogin() {
        String email = "aulia@dummy.com";
        String password = "aulia1234";

        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setEndpointLogin());
    }

    @Step("I see validate response code")
    public void validateResponseCodeLogin() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I see validate response code")
    public void validateDataLogin() {
        Response response = SerenityRest.lastResponse();
        String email = response.getBody().jsonPath().get("data.email");
        Assert.assertEquals(email, "aulia@dummy.com");}

/* ========================================== TEST CASE INVALID ENDPOINT ================================================ */
    public String invalidEndpoint = "https://capstone.hanifz.com/api/v1/login-user";
    public String setInvalidEndpointLogin() {
        return invalidEndpoint;
    }

    public void sendRequestToInvalidEndpoint() {
        String email = "aulia@dummy.com";
        String password = "aulia1234";

        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setInvalidEndpointLogin());
    }

    public void validateErrorStatus() {
        restAssuredThat(response -> response.statusCode(404));
    }


    /* ========================================== TEST CASE INVALID REQUEST ================================================ */

    public String setValidEndpoint() {
        return endpoint;
    }


    public void sendInvalidRequest() {
        String email = "aulia@dummy3.com";
        String password = "aulia1234";

        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setValidEndpoint());
    }

    public void validateErrorCode() {
        restAssuredThat(response -> response.statusCode(400));
    }

    public void validateResponseMessage() {
        Response response = SerenityRest.lastResponse();
        String message = response.getBody().jsonPath().get("message");
        Assert.assertEquals(message, "Failed to login");
    }

}
