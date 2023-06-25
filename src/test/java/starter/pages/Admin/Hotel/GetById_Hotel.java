package starter.pages.Admin.Hotel;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetById_Hotel {

    public static String email = "admin@gmail.com";
    public static String password = "qweqwe123";
    public String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2ODczNjU1OTYsInJvbGUiOiJhZG1pbiIsInVzZXJJZCI6MX0.LZ1JCh7zuxoHehOs--2SppdlaWY8MTRHO_d2Y_6dK40";
    public String endpointLogin = "https://api.tripease.my.id/api/v1/login";

    protected String GetIdHotelValid = "https://api.tripease.my.id/api/v1/public/hotel/37";
    protected String GetIdHotelInvalid = "https://api.tripease.my.id/api/v1/public/hotel/37012";


    @Step("I have endpoint post new login for Id Hotel")
    public String EndpointLoginForIdHotel () {
        return endpointLogin;
    }

    @Step("I send request to endpoint for Id Hotel")
    public void SendRequestForIdHotel () {

        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(EndpointLoginForIdHotel());
        token = lastResponse().getBody().jsonPath().get("data.token");

    }

    @Step("user set GET valid endpoint for Id Hotel")
    public String setPostValidEndpointForIdHotel () {
        return GetIdHotelValid;
    }

    @Step("user send GET HTTP request with valid endpoint for Id Hotel")
    public void sendPOSTHTTPRequestForIdHotel () {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setPostValidEndpointForIdHotel());
    }

    @Step("user received valid Get By Id HTTP response code 200")
    public void validateHTTPResponseCode200ForIdHotel () {
        restAssuredThat(response -> response.statusCode(200));
    }


    @Step("I have endpoint post new login for invalid Id Hotel")
    public String EndpointInvalidIdHotel () {
        return endpointLogin;
    }

    @Step("I send request to endpoint for invalid Id Hotel")
    public void SendRequestForIdHotel2 () {

        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(EndpointInvalidIdHotel());
        token = lastResponse().getBody().jsonPath().get("data.token");


    }

    @Step("user set GET invalid endpoint for Id Hotel")
    public String setPostInvalidEndpointForIdHotel () {
        return GetIdHotelInvalid;
    }

    @Step("user send GET HTTP request with invalid endpoint for Id Hotel")
    public void sendGetHTTPRequestInvalidForIdHotel () {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setPostInvalidEndpointForIdHotel());
    }

    @Step("user received invalid Get By Id HTTP response code 404")
    public void validateHTTPInvalidEndpointResponseCode404ForGetIdHotel () {
        restAssuredThat(response -> response.statusCode(404));
    }


}
