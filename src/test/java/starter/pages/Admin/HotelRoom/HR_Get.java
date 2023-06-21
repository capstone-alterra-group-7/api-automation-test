package starter.pages.Admin.Hotel_Room;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class HR_Get {

    public static String email = "admin@gmail.com";
    public static String password = "qweqwe123";
    public String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2ODc0MjExNjUsInJvbGUiOiJhZG1pbiIsInVzZXJJZCI6MX0.w9Jb1VAmIiEpeZ0Ff7ITWuIdhUFOfphByy2w8ivhV40";
    public String endpointLogin = "https://api.tripease.my.id/api/v1/login";
    protected String GetAllHotelRoom = "https://api.tripease.my.id/api/v1/public/hotel-room?page=1&limit=10";
    protected String InvalidGetAllHotelRoom = "https://api.tripease.my.id/api/v1/public/hotel-room?page=1&limit=100";


    @Step("I set hotel room API api endpoints")
    public String SetHotelRoomAPIEndpoint() {
        return endpointLogin;
    }

    @Step("I request to endpoint for Get All Hotel")
    public void HotelRoomSendRequestLogin() {

        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").queryParam("page", 1).body(reqBody.toString()).post(SetHotelRoomAPIEndpoint());
        token = lastResponse().getBody().jsonPath().get("data.token");

    }

    @Step("user set GET Hotel room valid endpoints")
    public String UserSetGetHotelRoomValidEndpoints() {
        return GetAllHotelRoom;
    }

    @Step("user send GET Hotel room HTTP request with valid endpoint")
    public void SendHttpRequestHotelRoomGet() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(UserSetGetHotelRoomValidEndpoints());
    }

    @Step("I receive valid HTTP Get Hotel room response code 200")
    public void ReceiveHttpGetHotelRoom200() {
        restAssuredThat(response -> response.statusCode(200));
    }



    @Step(" I set hotel room API invalid endpoints")
    public String SetHotelRoomAPInvalidEndpoint() {
        return endpointLogin;
    }

    @Step("I request to endpoint for Get All Hotel room invalid")
    public void HotelRoomSendRequestLogin1() {

        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").queryParam("page", 1).body(reqBody.toString()).post(SetHotelRoomAPInvalidEndpoint());
        token = lastResponse().getBody().jsonPath().get("data.token");

    }

    @Step("user set GET Hotel room invalid endpoints")
    public String UserSetGetHotelRoomInvalidEndpoints() {
        return InvalidGetAllHotelRoom;
    }

    @Step("user send GET invalid Hotel room HTTP  request with valid endpoint")
    public void SendHttpRequestHotelRoomGetInvalid () {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(UserSetGetHotelRoomInvalidEndpoints());
    }

    @Step("I receive valid HTTP Get invalid Hotel room response code")
    public void ReceiveHttpGetHotelRoom400() {
        restAssuredThat(response -> response.statusCode(400));
    }


}
