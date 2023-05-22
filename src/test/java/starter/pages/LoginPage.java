package starter.pages;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class LoginPage {
    public String endpoint = "http://ec2-3-26-30-178.ap-southeast-2.compute.amazonaws.com:8088/api/v1/login";

    @Step("I have endpoint post new login")
    public String setEndpointLogin() {
        return endpoint;
    }

    @Step("I send request to endpoint")
    public void sendRequestLogin() {
        String email = "dummy@gmail.com";
        String password = "aulia";

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
        Assert.assertEquals(email, "dummy@gmail.com");}
}
