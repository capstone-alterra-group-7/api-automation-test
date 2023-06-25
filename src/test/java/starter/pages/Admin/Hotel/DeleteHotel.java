package starter.pages.Admin.Hotel;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DeleteHotel {

    public static String email = "admin@gmail.com";
    public static String password = "qweqwe123";
    public String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2ODczNjU1OTYsInJvbGUiOiJhZG1pbiIsInVzZXJJZCI6MX0.LZ1JCh7zuxoHehOs--2SppdlaWY8MTRHO_d2Y_6dK40";
    public String endpointLogin = "https://api.tripease.my.id/api/v1/login";

    protected String ValidateDeleteHotel = "https://api.tripease.my.id/api/v1/admin/hotel/37";
    protected String InvalidDeleteHotel = "https://api.tripease.my.id/api/v1/admin/hotel/46";



    @Step("I have endpoint post new login for delete hotel")
    public String SetEndpointLoginDeleteHotel () {
        return endpointLogin;
    }


    @Step("I send request to endpoint for delete hotel")
    public void sendRequestLoginForDeleteHotel () {

        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(SetEndpointLoginDeleteHotel());
        token = lastResponse().getBody().jsonPath().get("data.token");

    }


    @Step("user set DELETE valid endpoint for delete hotel")
    public String setDeleteValidEndpointForDeleteHotel () {
        return ValidateDeleteHotel;
    }

    @Step("user send DELETE hotel HTTP request with valid endpoint")
    public void sendPOSTHTTPRequestForDeleteHotel () {
        SerenityRest.given().header("Authorization", "Bearer " + token).delete(setDeleteValidEndpointForDeleteHotel());

    }

    @Step("user received valid DELETE hotel HTTP response code")
    public void validateHTTPResponseCode200ForDeleteHotel () {
        restAssuredThat(response -> response.statusCode(200));
    }


    @Step("I have invalid endpoint post new login for delete hotel")
    public String SetEndpointLoginDeleteHotel1 () {
        return endpointLogin;
    }

    @Step("I send request to endpoint invalid for delete hotel")
    public void sendRequestLoginForDeleteHotel1 () {

        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(SetEndpointLoginDeleteHotel1());
        token = lastResponse().getBody().jsonPath().get("data.token");

    }

    @Step("user set DELETE invalid endpoint for delete hotel")
    public String setDeleteValidEndpointForDeleteHotel1 () {
        return InvalidDeleteHotel;
    }

    @Step("user send DELETE hotel HTTP request with invalid endpoint")
    public void sendPOSTHTTPRequestForDeleteHotel1 () {
        SerenityRest.given().header("Authorization", "Bearer " + token).delete(setDeleteValidEndpointForDeleteHotel1());

    }

    @Step("user received invalid DELETE hotel HTTP response code")
    public void validateHTTPResponseCode400ForDeleteHotel () {
        restAssuredThat(response -> response.statusCode(400));
    }


}
