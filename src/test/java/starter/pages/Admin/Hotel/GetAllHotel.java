package starter.pages.Admin.Hotel;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;


public class GetAllHotel {

    public static String email = "admin@gmail.com";
    public static String password = "qweqwe123";
    public String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2ODczNjU1OTYsInJvbGUiOiJhZG1pbiIsInVzZXJJZCI6MX0.LZ1JCh7zuxoHehOs--2SppdlaWY8MTRHO_d2Y_6dK40";
    public String endpointLogin = "https://api.tripease.my.id/api/v1/login";
    protected String ValidGetAllHotel = "https://api.tripease.my.id/api/v1/public/hotel?page=1&limit=10&minimum_price=15000&maximum_price=150000&rating_class=1&address=Jln.%20Pahlawan%2051%2C%20Semarang&name=RedDoors&sort_by_price=desc";
    protected String InvalidGetAllHotel = "https://api.tripease.my.id/api/v1/public/hotel?page=1&limit=10&minimum_price=15000&maximum_price=1500000&rating_class=1&address=Jln.%20Pahlawan%2051%2C%20Semarang&name=RedDoors&sort_by_price=desc";

    @Step("I set Hotel API api endpoints")
    public String SetHotelAPIEndpoint() {
        return endpointLogin;
    }

    @Step("I request to endpoint for Get All Hotel")
    public void HotelSendRequestLogin() {

        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").queryParam("page", 1).body(reqBody.toString()).post(SetHotelAPIEndpoint());
        token = lastResponse().getBody().jsonPath().get("data.token");

    }

    @Step("user set GET Hotel valid endpoints")
    public String UserSetGetHotelValidEndpoints() {
        return ValidGetAllHotel;
    }


    @Step("user send GET Hotel HTTP request with valid endpoint")
    public void SendHttpRequestHotelGet() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(UserSetGetHotelValidEndpoints());
    }


    @Step("I receive valid HTTP Get Hotel response code")
    public void ReceiveHttpGetHotel200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I set Hotel API invalid endpoints")
    public String SetHotelApiInvalidEndpoints () {
        return endpointLogin;
    }

    @Step("I request to invalid endpoint for Get All Hotel")
    public void RequstInvalidloginGetAllHotel () {

        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").queryParam("page", 1).body(reqBody.toString()).post(SetHotelApiInvalidEndpoints());
        token = lastResponse().getBody().jsonPath().get("data.token");

    }

    @Step("user set GET Hotel invalid endpoints")
    public String setPostInvalidEndpointForGetAllHotel () {
        return InvalidGetAllHotel;
    }

    @Step("user send GET Hotel HTTP request with invalid endpoint")
    public void sendPOSTInvalidHTTPRequestForGetAllHotel () {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setPostInvalidEndpointForGetAllHotel());
    }

    @Step("I receive invalid HTTP Get Hotel response code 404")
    public void validateInvalidHTTPResponseCode404ForGetAllHotel () {
        restAssuredThat(response -> response.statusCode(404));
    }

}
