package starter.pages.User.Account;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class PutUpdateProfilePage {
    protected static String email="newuser2@gmail.com";
    protected static String password="newuser2";
    public String token ="";

    public String login = "https://capstone.hanifz.com/api/v1/login";


    public String setEndpointLogin() {
        return login;
    }

    public void sendReqEndpointLogin() {
        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setEndpointLogin());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }

    public String updateProfile = "https://capstone.hanifz.com/api/v1/user/update-profile";
    public String setEndpointUpdateProfile() {
        return updateProfile;
    }

    public void sendReqForUpdateProfile() {
        String birth_date = "2000-01-01";
        String citizen = "Indonesia";
        String full_name = "Aulia";
        String phone_number = "081387081174";

        String body = "{\n" +
                "    \"birth_date\":" + birth_date + ",\n" +
                "    \"citizen\":" + citizen + ",\n" +
                "    \"full_name\":" + full_name + ",\n" +
                "    \"phone_number\":" + phone_number + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).header("Content-Type", "application/json").body(reqBody.toString()).put(setEndpointUpdateProfile());
    }


    public void canSeeStatusCode() {
        restAssuredThat(response -> response.statusCode(200));
    }

    public void seeValidDataResponse() {
        Response response = SerenityRest.lastResponse();
        String message = response.getBody().jsonPath().get("message");
        String full_name = response.getBody().jsonPath().get("data.full_name");
        Assert.assertEquals(message, "Successfully updated profile");
        Assert.assertEquals(message, "Aulia");
    }
}
