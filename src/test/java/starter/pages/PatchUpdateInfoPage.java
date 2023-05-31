package starter.pages;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class PatchUpdateInfoPage {

    protected static String email="aulia@dummy.com";
    protected static String password="aulia1234";
    public String token ="";
    public String EndpointLogin = "http://ec2-3-26-30-178.ap-southeast-2.compute.amazonaws.com:8088/api/v1/login";
    public String setEndpointLogin() {
        return EndpointLogin;
    }
    public void SendReqToEndpointLogin() {
        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setEndpointLogin());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }
    public String endpointInfo = "http://ec2-3-26-30-178.ap-southeast-2.compute.amazonaws.com:8088/api/v1/user/update-information";
    public String setEndpointToUpdatInfo() {
        return endpointInfo;}

    public void sendRequestToUpdateInfo() {
        String birth_date = "2003-09-02";
        String gender = "Perempuan";

        String body = "{\n" +
                "    \"birth_date\":" + birth_date + ",\n" +
                "    \"gender\":" + gender + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).patch(setEndpointToUpdatInfo());
    }

    public void validateStatusCodeUpdate() {
        restAssuredThat(response -> response.statusCode(200));
    }

    public void validateResponseMessageUpdate() {
        Response response = SerenityRest.lastResponse();
        String message = response.getBody().jsonPath().get("message");
        Assert.assertEquals(message, "Successfully updated information");}
}
