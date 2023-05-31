package starter.pages;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetCredentialPage {

    protected static String email="aulia@dummy.com";
    protected static String password="aulia1234";
    public String token ="";
    public String endpointLogin = "http://ec2-3-26-30-178.ap-southeast-2.compute.amazonaws.com:8088/api/v1/login";
    public String setEndpointAuthLogin() {
        return endpointLogin;
    }

    public void sendReqToEndpointAuthLogin() {
        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setEndpointAuthLogin());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }

    public String endpointCredential = "http://ec2-3-26-30-178.ap-southeast-2.compute.amazonaws.com:8088/api/v1/user";
    public String getEndpointGetCredential() {
        return endpointCredential;
    }


    public void getCredentials() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(getEndpointGetCredential());
    }

    public void validateStatusCode() {
        restAssuredThat(response -> response.statusCode(200));
    }

    public void validateMessageResponse() {
        Response response = lastResponse();
        String email = response.getBody().jsonPath().get("data.email");
        Assert.assertEquals(email, "aulia@dummy.com");
    }
}
