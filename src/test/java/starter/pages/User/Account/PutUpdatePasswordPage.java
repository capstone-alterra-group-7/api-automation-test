package starter.pages.User.Account;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class PutUpdatePasswordPage {
    protected static String email="aulia_updatepw@dummy.com";
    protected static String password="aulia1234";
    public String token ="";

    public String login = "https://capstone.hanifz.com/api/v1/login";
    public String setEndpointLoginUser() {
        return login;
    }

    public void sendReqToEndpointLoginuser() {
        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setEndpointLoginUser());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }
    public String updatePassword = "https://capstone.hanifz.com/api/v1/user/update-password";
    public String setEndpointForUpdatePassword() {
        return updatePassword;
    }

    public void sendEndpointForUpdatePassword() {
        String confirm_password = "aulia123";
        String new_password = "aulia123";
        String old_password = "aulia1234";

        String body = "{\n" +
                "    \"confirm_password\":" + confirm_password + ",\n" +
                "    \"new_password\":" + new_password + ",\n" +
                "    \"old_password\":" + old_password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).header("Content-Type", "application/json").body(reqBody.toString()).put(setEndpointForUpdatePassword());
    }

    public void seeStatusCodeForUpdatePassword() {
        restAssuredThat(response -> response.statusCode(200));
    }

    public void validateMessageForUpdatePassword() {
        Response response = SerenityRest.lastResponse();
        String message = response.getBody().jsonPath().get("message");
        Assert.assertEquals(message, "Successfully updated password");
    }
}
