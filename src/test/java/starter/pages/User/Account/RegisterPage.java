package starter.pages.User.Account;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class RegisterPage {
    public String endpoint = "https://api.tripease.my.id/api/v1/register";

    @Step("I have endpoint for create user")
    public String setEndpointRegister() {
        return endpoint;
    }

    @Step("I send request to endpoint")
    public void sendReqToEndpointRegister() {
        String confirm_password = "aulia123";
        String email = "auliadummy5@gmail.com";
        String full_name = "Aulia Claudia Rahma";
        String password = "aulia123";
        String phone_number = "081387081174";
        String role = "user";

        String body = "{\n" +
                "    \"confirm_password\":" + confirm_password + ",\n" +
                "    \"email\":" + email + ",\n" +
                "    \"full_name\":" + full_name + ",\n" +
                "    \"password\":" + password + ",\n" +
                "    \"phone_number\":" + phone_number + ",\n" +
                "    \"role\":" + role + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(reqBody.toString())
                .post(setEndpointRegister());
    }

    @Step("I see validate response code")
    public void validateStatusCode() {
        restAssuredThat(response -> response.statusCode(201));
    }

    @Step("I see validate data")
    public void validateDataNewAccount() {
        Response response = SerenityRest.lastResponse();
        String email = response.getBody().jsonPath().get("data.email");
        Assert.assertEquals(email, "auliadummy5@gmail.com");}
    
/* ============================================ TEST CASE EXISTING EMAIL ========================================== */    
    
    public void sendReqWithExistingEmail() { String confirm_password = "aulia123";
        String email = "auliadummy2@gmail.com";
        String full_name = "Aulia Claudia Rahma";
        String password = "aulia123";
        String phone_number = "081387081174";
        String role = "user";

        String body = "{\n" +
                "    \"confirm_password\":" + confirm_password + ",\n" +
                "    \"email\":" + email + ",\n" +
                "    \"full_name\":" + full_name + ",\n" +
                "    \"password\":" + password + ",\n" +
                "    \"phone_number\":" + phone_number + ",\n" +
                "    \"role\":" + role + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setEndpointRegister());
    }

    public void seeErrorCode() {
        restAssuredThat(response -> response.statusCode(400));
    }

    public void validateMessageError() {
        Response response = SerenityRest.lastResponse();
        String errors = response.getBody().jsonPath().get("errors");
        Assert.assertEquals(errors, "Email already used");
    }
}
