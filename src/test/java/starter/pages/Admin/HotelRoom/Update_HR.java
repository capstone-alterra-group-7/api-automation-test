package starter.pages.Admin.Hotel_Room;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONArray;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Update_HR {

    public static String email = "admin@gmail.com";
    public static String password = "qweqwe123";
    public String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2ODc0NTMyMDgsInJvbGUiOiJhZG1pbiIsInVzZXJJZCI6MX0.49BArThpZJ0emfPd7QVBmoRqZ1qqschudNQR638UZBg";
    public String endpointLogin = "https://api.tripease.my.id/api/v1/login";

    protected String ValidateUpdateHR = "https://api.tripease.my.id/api/v1/admin/hotel-room/45";


    @Step("Enter Endpoint Login Valid Endpoint update hotel room")
    public String SetUpdateApiNewHR () {
        return endpointLogin;
    }

    @Step("Enter Request Login Valid Endpoint update hotel room")
    public void RequestLoginUpdateHR() {

        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(SetUpdateApiNewHR());
        token = lastResponse().getBody().jsonPath().get("data.token");

    }

    @Step("Enter Endpoint update hotel room Valid Endpoint")
    public String setValidEndpointUpdateHR () {
        return ValidateUpdateHR;
    }

    @Step("Enter Request update hotel room Valid Endpoint")
    public void PutUpdateHREndpoints() {

        JSONObject requestBody = new JSONObject();
        requestBody.put("description", "String");
        requestBody.put("discount", 50);
        requestBody.put("hotel_id", 20);

        JSONArray hotelroomfacilityArray = new JSONArray();
        JSONObject hotelroomfacility = new JSONObject();
        hotelroomfacility.put("name", "Hotel Aqua");
        hotelroomfacilityArray.put(hotelroomfacility);
        requestBody.put("hotel_room_facility", hotelroomfacilityArray);

        JSONArray hotelroomimageArray = new JSONArray();
        JSONObject hotelRoomImage = new JSONObject();
        hotelRoomImage.put("image_url", "Bandit.jpg");
        hotelroomimageArray.put(hotelRoomImage);
        requestBody.put("hotel_room_image", hotelroomimageArray);

        requestBody.put("mattress_size", "Queen");
        requestBody.put("name", "Ace");
        requestBody.put("normal_price", 20000);
        requestBody.put("number_of_guest", 300000);
        requestBody.put("number_of_mattress", 9);
        requestBody.put("quantity_of_room", 9);
        requestBody.put("size_of_room", 9);


        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(requestBody.toString())
                .put(setValidEndpointUpdateHR());

    }

    @Step("Receive response code Update hotel room")
    public void SuccessUpdateHR() {
        restAssuredThat(response -> response.statusCode(200));
    }









}
