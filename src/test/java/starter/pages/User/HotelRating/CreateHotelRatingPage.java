package starter.pages.User.HotelRating;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class CreateHotelRatingPage {
    protected static String email="auliadummy5@gmail.com";
    protected static String password="aulia123";
    public String token ="";
    public String Login = "https://api.tripease.my.id/api/v1/login";

    public String setEndpointLoginUser() {
        return Login;
    }

    public void sendReqToAuthUser() {
        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(reqBody.toString())
                .post(setEndpointLoginUser());
        token = lastResponse().getBody().jsonPath().get("data.token");
    }

    public String hotelRating = "https://api.tripease.my.id/api/v1/user/hotel-ratings";
    public String setEndpointNewRatingHotel() {
         return hotelRating;
    }

    public void sendReqForCreateNewHotelRating() {
        int hotel_id = 2;
        int hotel_order_id = 97;
        int rating = 3;
        String review = "sangat rekomen";
        int user_id = 85;

        String body = "{\n" +
                "    \"hotel_id\":" + hotel_id + ",\n" +
                "    \"hotel_order_id\":" + hotel_order_id + ",\n" +
                "    \"rating\":" + rating + ",\n" +
                "    \"review\":" + review + ",\n" +
                "    \"user_id\":" + user_id + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given()
                .header("Content-Type", "Bearer " + token)
                .contentType("application/json")
                .body(reqBody.toString())
                .post(setEndpointNewRatingHotel());
    }

    public void validateStatusCode() {
        restAssuredThat(response -> response.statusCode(201));
    }

    public void validateDataHotelRating() {
        Response response = SerenityRest.lastResponse();
        String message = response.getBody().jsonPath().get("message");
        Assert.assertEquals(message, "Successfully created hotel rating");
    }
}
