package starter.pages.Admin.Hotel_Room;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Delete_HR {

    public static String email = "admin@gmail.com";
    public static String password = "qweqwe123";
    public String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2ODc0NTMyMDgsInJvbGUiOiJhZG1pbiIsInVzZXJJZCI6MX0.49BArThpZJ0emfPd7QVBmoRqZ1qqschudNQR638UZBg";
    public String endpointLogin = "https://api.tripease.my.id/api/v1/login";
    protected String DeleteHRValid = "https://api.tripease.my.id/api/v1/admin/hotel-room/45";

    @Step("I have endpoint post new login for delete hotel room")
    public String SetEndpointLoginDeleteHR () {
        return endpointLogin;
    }

    @Step("I send request to endpoint for delete hotel room")
    public void sendRequestLoginForDeleteHR () {

        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(SetEndpointLoginDeleteHR());
        token = lastResponse().getBody().jsonPath().get("data.token");

    }

    @Step("user set DELETE valid endpoint for delete hotel room")
    public String setDeleteValidEndpointForDeleteHR () {
        return DeleteHRValid;
    }

    @Step("user send DELETE hotel room HTTP request with valid endpoint")
    public void sendPOSTHTTPRequestForDeleteHR () {
        SerenityRest.given().header("Authorization", "Bearer " + token).delete(setDeleteValidEndpointForDeleteHR());
    }

    @Step("user received valid DELETE hotel room HTTP response code  200")
    public void validateHTTPResponseCode200ForDeleteHR () {
        restAssuredThat(response -> response.statusCode(200));
    }


}
