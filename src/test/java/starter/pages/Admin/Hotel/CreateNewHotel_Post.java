package starter.pages.Admin.Hotel;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONArray;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class CreateNewHotel_Post {

    public static String email = "admin@gmail.com";
    public static String password = "qweqwe123";
    public String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2ODczNjY3MjUsInJvbGUiOiJhZG1pbiIsInVzZXJJZCI6MX0.72wqy9VZQjc0fylomnE_yyNjuk7Q_Fx-AA-RZ4V5LUQ";
    public String endpointLogin = "https://api.tripease.my.id/api/v1/login";

    protected String ValidPostCreateNewHotel = "https://api.tripease.my.id/api/v1/admin/hotel";

    @Step("Enter Endpoint Login Valid Endpoint New Hotel")
    public String SetPostApiNewHotel () {
        return endpointLogin;
    }

    @Step("Enter Request Login Valid Endpoint New Hotel")
    public void RequestCreateNewHotel() {

        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(SetPostApiNewHotel());
        token = lastResponse().getBody().jsonPath().get("data.token");

    }


    @Step("Enter Endpoint New Hotel Valid Endpoint")
    public String setPostValidEndpointPOSTCrateNewHotel () {
        return ValidPostCreateNewHotel;
    }

    @Step("Enter Request New Hotel Valid Endpoint")
    public void PostNewHotelEndpoints() {

        JSONObject requestBody = new JSONObject();
        requestBody.put("address", "Jln. Pahlawan 51, Semarang");
        requestBody.put("class", 1);
        requestBody.put("description", "string");
        requestBody.put("email", "Zorojuro@gmail.com");

        JSONArray hotelFacilities = new JSONArray();
        JSONObject facility = new JSONObject();
        facility.put("name", "RedDoors");
        hotelFacilities.put(facility);
        requestBody.put("hotel_facilities", hotelFacilities);

        JSONArray hotelImages = new JSONArray();
        JSONObject image = new JSONObject();
        image.put("image_url", "ooo.jpg");
        hotelImages.put(image);
        requestBody.put("hotel_image", hotelImages);

        JSONArray hotelPolicies = new JSONArray();
        JSONObject policy = new JSONObject();
        policy.put("is_breakfast", true);
        policy.put("is_check_in_check_out", true);
        policy.put("is_check_in_early", true);
        policy.put("is_check_out_overdue", true);
        policy.put("is_pet", true);
        policy.put("is_policy_canceled", true);
        policy.put("is_policy_minimum_age", true);
        policy.put("is_smoking", true);
        policy.put("policy_minimum_age", 0);
        policy.put("time_breakfast_end", "string");
        policy.put("time_breakfast_start", "string");
        policy.put("time_check_in", "string");
        policy.put("time_check_out", "string");
        hotelPolicies.put(policy);
        requestBody.put("hotel_policy", hotelPolicies);

        requestBody.put("name", "Derry");
        requestBody.put("phone_number", "081290182736");


        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setPostValidEndpointPOSTCrateNewHotel());

    }

    @Step("Receive Valid Http Create New Hotel response code 201")
    public void SuccessCreateNewHotel() {
        restAssuredThat(response -> response.statusCode(201));
    }


}
