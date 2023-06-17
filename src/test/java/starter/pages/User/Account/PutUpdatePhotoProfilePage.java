package starter.pages.User.Account;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;
import org.junit.Assert;

import java.io.File;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class PutUpdatePhotoProfilePage {
    protected static String email="newuser3@gmail.com";
    protected static String password="newuser3";
    public String token ="";

    public String loginUser = "https://api.tripease.my.id/api/v1/login";

    public String setEndpointLoginUserr() { return loginUser;
    }

    public void sendReqForLoginUserr() {
        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setEndpointLoginUserr());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }
    public String EndpointPhotoProfile = "https://api.tripease.my.id/api/v1/user/update-photo-profile";

    public String setEndpointPhotoProfile() { return EndpointPhotoProfile;
    }
    public void uploadPhotoProfile() {

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType("multipart/form-data")
                .multiPart("file", new File("D:\\D\\QE_Alta\\capstone\\api-automation-test\\src\\test\\resources\\features\\User\\Account\\inputgaji.png"))
                .when()
                .put(setEndpointPhotoProfile());
    }
    public void validateResponseWithStatusCode() {
        restAssuredThat(response -> response.statusCode(200));
    }

    public void validateWithMessageResponse() {
        Response response = SerenityRest.lastResponse();
        String message = response.getBody().jsonPath().get("message");
        Assert.assertEquals(message, "Successfully updated information");
    }
}
