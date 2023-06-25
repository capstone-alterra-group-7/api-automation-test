package starter.pages.User.Notification;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class NotificationPage {
    public static String email = "auliadummy5@gmail.com";
    public static String password = "aulia123";
    public static String token = "";
    public String url = "https://api.tripease.my.id/api/v1/login";
    public String setEndpointLoginUser() {
        return url;
    }

    public void sendReqForLoginUser() {
        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(setEndpointLoginUser());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }
    public String urlNotification = "https://api.tripease.my.id/api/v1/user/notification";

    public String setEndpointForGetNotification() {
        return urlNotification;
    }

    public void validateStatusCode() {
        restAssuredThat(response -> response.statusCode(200));
    }

    public void validateMessageResponse() {
        Response response = SerenityRest.lastResponse();
        String message = response.getBody().jsonPath().get("message");
        Assert.assertEquals(message, "Successfully to get notification by user id");
    }

    public void sendReqForGetNotification() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setEndpointForGetNotification());
    }
}
