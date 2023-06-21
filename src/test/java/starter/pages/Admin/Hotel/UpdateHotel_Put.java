package starter.pages.Admin.Hotel;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONArray;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class UpdateHotel_Put {

    public static String email = "admin@gmail.com";
    public static String password = "qweqwe123";
    public String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJleHAiOjE2ODczNjU1OTYsInJvbGUiOiJhZG1pbiIsInVzZXJJZCI6MX0.LZ1JCh7zuxoHehOs--2SppdlaWY8MTRHO_d2Y_6dK40";
    public String endpointLogin = "https://api.tripease.my.id/api/v1/login";

    protected String UpdateHotelValid = "https://api.tripease.my.id/api/v1/admin/hotel/37";


    @Step("Enter Endpoint Login Valid Endpoint update hotel")
    public String EndpointLoginUpdateHotel() {
        return endpointLogin;
    }

    @Step("Enter Request Login Valid Endpoint update hotel")
    public void RequestLoginUpdateHotel() {

        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Authorization", "Bearer " + token).contentType("application/json").body(reqBody.toString()).post(EndpointLoginUpdateHotel());
        token = lastResponse().getBody().jsonPath().get("data.token");

    }

    @Step("Enter Endpoint update hotel Valid Endpoint")
    public String setValidEndpointUpdateHotel () {
        return UpdateHotelValid;
    }

    @Step("Enter Request update hotel Valid Endpoint")
    public void PostUpdateHotelEndpoints() {

        JSONObject requestBody = new JSONObject();
        requestBody.put("address", "Jln. Desa Ultra, GG-77");
        requestBody.put("class", 5);
        requestBody.put("description", "string");
        requestBody.put("email", "UltimateZero@gmail.com");

        JSONArray hotelFacilities = new JSONArray();
        JSONObject facility = new JSONObject();
        facility.put("name", "Ultraman Zero");
        hotelFacilities.put(facility);
        requestBody.put("hotel_facilities", hotelFacilities);

        JSONArray hotelImages = new JSONArray();
        JSONObject image = new JSONObject();
        image.put("image_url", "windah-.jpg");
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

        requestBody.put("name", "Ultraman Zero");
        requestBody.put("phone_number", "09375839221234");


        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(requestBody.toString())
                .post(setValidEndpointUpdateHotel());

    }

    @Step("Receive response code Update hotel 200")
    public void SuccessUpdateHotel() {
        restAssuredThat(response -> response.statusCode(200));
    }

}
