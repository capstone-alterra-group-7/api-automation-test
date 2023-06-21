package starter.pages.Admin.Hotel_Room;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONArray;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;


public class CreateNewHR {

    public static String email = "admin@gmail.com";
    public static String password = "qweqwe123";
    public String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2ODc0NDA0NDIsInJvbGUiOiJhZG1pbiIsInVzZXJJZCI6MX0.JDb-JXfOeOHB9Fa5PsiVuH-B_3ki9pGarnn2UKQ_k-0";
    public String endpointLogin = "https://api.tripease.my.id/api/v1/login";
    protected String ValidPostCreateNewHR = "https://api.tripease.my.id/api/v1/admin/hotel-room";


    @Step("Enter Endpoint Login Valid Endpoint New hotel room")
    public String SetPostApiNewHotelRoom() {
        return endpointLogin;
    }

    @Step("Enter Request Login Valid Endpoint New hotel room")
    public void RequestCreateNewHR() {

        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(SetPostApiNewHotelRoom());
        token = lastResponse().getBody().jsonPath().get("data.token");

    }

    @Step("Enter Endpoint New Hotel room Valid Endpoint")
    public String setPostValidEndpointPOSTCrateNewHR() {
        return ValidPostCreateNewHR;
    }

    @Step("Enter Request New Hotel room Valid Endpoint")
    public void PostNewHREndpoints() {

        JSONObject requestBody = new JSONObject();
        requestBody.put("description", "String");
        requestBody.put("discount", 10);
        requestBody.put("hotel_id", 20);

        JSONArray hotelroomfacilityArray = new JSONArray();
        JSONObject hotelroomfacility = new JSONObject();
        hotelroomfacility.put("name", "Fantasy");
        hotelroomfacilityArray.put(hotelroomfacility);
        requestBody.put("hotel_room_facility", hotelroomfacilityArray);

        JSONArray hotelroomimageArray = new JSONArray();
        JSONObject hotelRoomImage = new JSONObject();
        hotelRoomImage.put("image_url", "windah.jpg");
        hotelroomimageArray.put(hotelRoomImage);
        requestBody.put("hotel_room_image", hotelroomimageArray);



        requestBody.put("mattress_size", "Kings");
        requestBody.put("name", "KingOfbocil");
        requestBody.put("normal_price", 1500);
        requestBody.put("number_of_guest", 150000);
        requestBody.put("number_of_mattress", 5);
        requestBody.put("quantity_of_room", 5);
        requestBody.put("size_of_room", 5);

        String body = requestBody.toString();

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setPostValidEndpointPOSTCrateNewHR());

    }

    @Step("Receive Valid Http Create New Hotel room response code 201")
    public void receiveValidHttpCreateNewHotelRoomResponseCode201 () {
        restAssuredThat(response -> response.statusCode(201));
    }

}
