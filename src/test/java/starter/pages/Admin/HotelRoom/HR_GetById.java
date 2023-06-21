package starter.pages.Admin.Hotel_Room;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class HR_GetById {

    public static String email = "admin@gmail.com";
    public static String password = "qweqwe123";
    public String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2ODc0MjExNjUsInJvbGUiOiJhZG1pbiIsInVzZXJJZCI6MX0.w9Jb1VAmIiEpeZ0Ff7ITWuIdhUFOfphByy2w8ivhV40";
    public String endpointLogin = "https://api.tripease.my.id/api/v1/login";
    protected String GetByIdHotelRoom = "https://api.tripease.my.id/api/v1/public/hotel-room/3";
    protected String InvalidGetByIdHR = "https://api.tripease.my.id/api/v1/public/hotel-room/30";



    @Step("I have endpoint post new login for Id Hotel room")
    public String SetHotelRoomAPIEndpointForId() {
        return endpointLogin;
    }

    @Step("I send request to endpoint for Id Hotel room")
    public void HotelRoomSendRequestLoginForId() {

        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").queryParam("page", 3).body(reqBody.toString()).post(SetHotelRoomAPIEndpointForId());
        token = lastResponse().getBody().jsonPath().get("data.token");

    }

    @Step("user set GET valid endpoint for Id Hotel room")
    public String UserSetGetIdHotelRoomValidEndpoints() {
        return GetByIdHotelRoom;
    }

    @Step("user send GET HTTP request with valid endpoint for Id Hotel room")
    public void SendHttpRequestHotelRoomGetId() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(UserSetGetIdHotelRoomValidEndpoints());
    }

    @Step("user received valid Get By Id hr HTTP response code 200")
    public void ReceiveHttpGetIdHotelRoom200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I have endpoint post new login for Id Invalid Hotel room ")
    public String InvalidHotelRoomAPIEndpointForId() {
        return endpointLogin;
    }

    @Step("I send request to endpoint for Id Invalid Hotel room")
    public void HotelRoomSendRequestLoginForId1() {

        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").queryParam("page", 3).body(reqBody.toString()).post(InvalidHotelRoomAPIEndpointForId());
        token = lastResponse().getBody().jsonPath().get("data.token");

    }

    @Step("user set GET valid endpoint for Id Invalid Hotel room")
    public String UserSetGetIdHotelRoomInvalidEndpoints() {
        return InvalidGetByIdHR;
    }

    @Step("user send GET HTTP request with invalid endpoint for Id Hotel room")
    public void InvalidSendHttpRequestHotelRoomGetId() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(UserSetGetIdHotelRoomInvalidEndpoints());
    }

    @Step("user received invalid Get By Id hr HTTP response code 400")
    public void InvalidReceiveHttpGetIdHotelRoom400() {
        restAssuredThat(response -> response.statusCode(400));
    }



}
